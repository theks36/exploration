package net.theks.exploration.procedures;

import net.theks.exploration.entity.ResinDropletEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityAnchorArgument;

public class ResinDropletOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity target = null;
		double actionState = 0;
		double yDiff = 0;
		double dist = 0;
		double attackDamage = 0;
		if (entity instanceof ResinDropletEntity) {
			if (!world.isClientSide()) {
				actionState = entity instanceof ResinDropletEntity _datEntI ? _datEntI.getEntityData().get(ResinDropletEntity.DATA_actionState) : 0;
				if (actionState == 0) {
					entity.getPersistentData().putDouble("tickCounter", (entity.getPersistentData().getDouble("tickCounter") + 1));
					if (entity.getPersistentData().getDouble("tickCounter") > 4) {
						entity.getPersistentData().putDouble("tickCounter", 0);
						target = entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null;
						if (target != null) {
							dist = Math.pow(target.getX() - x, 2) + Math.pow(target.getZ() - z, 2);
							yDiff = target.getY() - y;
							if (dist < Math.pow(entity.getBbWidth() * 1.2 + target.getBbWidth() * 0.5, 2) && yDiff < entity.getBbHeight() && yDiff > target.getBbHeight() * (-1)) {
								if (entity instanceof ResinDropletEntity _datEntSetI)
									_datEntSetI.getEntityData().set(ResinDropletEntity.DATA_actionState, 1);
								entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((target.getX()), (target.getY()), (target.getZ())));
							}
						}
					}
				} else {
					entity.getPersistentData().putDouble("actionTicks", (entity.getPersistentData().getDouble("actionTicks") + 1));
					if (actionState == 1) {
						if (entity.getPersistentData().getDouble("actionTicks") == 11) {
							attackDamage = entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity23.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0;
							for (Entity entityiterator : world.getEntities(null, new AABB((x + (entity.getLookAngle().x * 0.6 + 0.5) * entity.getBbWidth()), y, (z + (entity.getLookAngle().z * 0.6 + 0.5) * entity.getBbWidth()),
									(x + (entity.getLookAngle().x * 0.6 - 0.5) * entity.getBbWidth()), (y + entity.getBbHeight()), (z + (entity.getLookAngle().z * 0.6 - 0.5) * entity.getBbWidth())))) {
								if (!(entity == entityiterator)) {
									entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), entity), (float) attackDamage);
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.weak")), SoundSource.HOSTILE, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.attack.weak")), SoundSource.HOSTILE, 1, 1, false);
								}
							}
						} else if (entity.getPersistentData().getDouble("actionTicks") == 19) {
							if (entity instanceof ResinDropletEntity _datEntSetI)
								_datEntSetI.getEntityData().set(ResinDropletEntity.DATA_actionState, 0);
							entity.getPersistentData().putDouble("actionTicks", 0);
						}
					}
				}
			}
		}
	}
}