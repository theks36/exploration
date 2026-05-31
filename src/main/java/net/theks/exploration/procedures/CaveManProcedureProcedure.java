package net.theks.exploration.procedures;

import net.theks.exploration.init.ExplorationModItems;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CaveManProcedureProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double offsetX = 0;
		double offsetY = 0;
		double offsetZ = 0;
		double dirtCount = 0;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().get(ResourceLocation.parse("exploration:cave_man"))).isDone())) {
			if (entity.getPersistentData().getDouble("CaveManCounter") == 0) {
				if (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && !entity.isSprinting() && entity.onGround()
						&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExplorationModItems.BONE_CLUB.get()
								|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == ExplorationModItems.BONE_CLUB.get())) {
					dirtCount = 0;
					offsetX = -1;
					for (int index0 = 0; index0 < 4; index0++) {
						offsetY = -1;
						for (int index1 = 0; index1 < 4; index1++) {
							offsetZ = -1;
							for (int index2 = 0; index2 < 4; index2++) {
								if ((world.getBlockState(BlockPos.containing(Math.floor(entity.getX()) + offsetX, Math.floor(entity.getY()) + offsetY, Math.floor(entity.getZ()) + offsetZ)))
										.is(BlockTags.create(ResourceLocation.parse("minecraft:dirt")))) {
									dirtCount = dirtCount + 1;
								}
								offsetZ = offsetZ + 1;
							}
							offsetY = offsetY + 1;
						}
						offsetX = offsetX + 1;
					}
					if (dirtCount > 34) {
						if (entity instanceof ServerPlayer _player) {
							AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("exploration:cave_man"));
							if (_adv != null) {
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
				}
				entity.getPersistentData().putDouble("CaveManCounter", 60);
			} else {
				entity.getPersistentData().putDouble("CaveManCounter", (entity.getPersistentData().getDouble("CaveManCounter") - 1));
			}
		}
	}
}