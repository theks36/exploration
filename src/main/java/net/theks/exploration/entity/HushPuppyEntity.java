package net.theks.exploration.entity;

import net.theks.exploration.procedures.HushPuppyVibrationReceivedProcedure;
import net.theks.exploration.procedures.HushPuppyPlayerCollidesWithThisEntityProcedure;
import net.theks.exploration.procedures.HushPuppyOnEntityTickUpdateProcedure;
import net.theks.exploration.procedures.CanSeeSkyConditionProcedure;
import net.theks.exploration.init.ExplorationModEntities;
import net.theks.exploration.ExplorationMod;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.EntityPositionSource;
import net.minecraft.world.level.gameevent.DynamicGameEventListener;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.function.BiConsumer;

public class HushPuppyEntity extends Monster implements VibrationSystem {

	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(HushPuppyEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> ANIM = SynchedEntityData.defineId(HushPuppyEntity.class, EntityDataSerializers.INT);
	private final DynamicGameEventListener<VibrationSystem.Listener> dynamicGameEventListener = new DynamicGameEventListener(new VibrationSystem.Listener(this));
	private final VibrationSystem.User vibrationUser = new VibrationUser();
	private VibrationSystem.Data vibrationData = new VibrationSystem.Data();

	public HushPuppyEntity(EntityType<HushPuppyEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		refreshDimensions();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(TEXTURE, "hushpuppyt");
		builder.define(ANIM, 0);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < 4 && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.75));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.hoglin.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.sniffer.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.hoglin.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.hoglin.death"));
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
		VibrationSystem.Data.CODEC.encodeStart(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), this.vibrationData).resultOrPartial(e -> ExplorationMod.LOGGER.error("Failed to encode vibration listener for HushPuppy: '{}'", e))
				.ifPresent(listener -> compound.put("listener", listener));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
		if (compound.contains("listener", Tag.TAG_COMPOUND)) {
			VibrationSystem.Data.CODEC.parse(this.registryAccess().createSerializationContext(NbtOps.INSTANCE), compound.getCompound("listener"))
					.resultOrPartial(e -> ExplorationMod.LOGGER.error("Failed to parse vibration listener for HushPuppy: '{}'", e)).ifPresent(data -> this.vibrationData = data);
		}
	}

	@Override
	public void updateDynamicGameEventListener(BiConsumer<DynamicGameEventListener<?>, ServerLevel> listenerConsumer) {
		if (this.level() instanceof ServerLevel serverLevel) {
			listenerConsumer.accept(this.dynamicGameEventListener, serverLevel);
		}
	}

	@Override
	public VibrationSystem.Data getVibrationData() {
		return this.vibrationData;
	}

	@Override
	public VibrationSystem.User getVibrationUser() {
		return this.vibrationUser;
	}

	@Override
	public void tick() {
		super.tick();
		if (this.level() instanceof ServerLevel serverLevel) {
			VibrationSystem.Ticker.tick(serverLevel, this.vibrationData, this.vibrationUser);
		}
	}

	@Override
	public void baseTick() {
		super.baseTick();
		HushPuppyOnEntityTickUpdateProcedure.execute(this.level(), this);
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		HushPuppyPlayerCollidesWithThisEntityProcedure.execute(this, sourceentity);
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		return super.getDefaultDimensions(pose).scale(2f);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(ExplorationModEntities.HUSH_PUPPY.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return CanSeeSkyConditionProcedure.execute(world, x, y, z);
		}, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 100);
		builder = builder.add(Attributes.ARMOR, 6);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.STEP_HEIGHT, 1.1);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.5);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1.5);
		return builder;
	}

	private class VibrationUser implements VibrationSystem.User {
		private final HushPuppyEntity entity = HushPuppyEntity.this;
		private final PositionSource positionSource = new EntityPositionSource(this.entity, this.entity.getEyeHeight());

		@Override
		public PositionSource getPositionSource() {
			return this.positionSource;
		}

		@Override
		public TagKey<GameEvent> getListenableEvents() {
			return TagKey.create(Registries.GAME_EVENT, ResourceLocation.withDefaultNamespace("hush_puppy_can_listen"));
		}

		@Override
		public int getListenerRadius() {
			return 32;
		}

		@Override
		public boolean canReceiveVibration(ServerLevel world, BlockPos vibrationPos, Holder<GameEvent> holder, GameEvent.Context context) {
			return true;
		}

		@Override
		public void onReceiveVibration(ServerLevel world, BlockPos vibrationPos, Holder<GameEvent> holder, @Nullable Entity vibrationSource, @Nullable Entity projectileShooter, float distance) {
			HushPuppyVibrationReceivedProcedure.execute(entity, vibrationSource, vibrationPos.getX(), vibrationPos.getY(), vibrationPos.getZ());
		}
	}
}