package net.theks.exploration.procedures;

import net.theks.exploration.entity.HushPuppyEntity;
import net.theks.exploration.entity.BoundSoulEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Stray;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import java.util.Comparator;

public class HushPuppyOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HushPuppyEntity) {
			if (entity.getPersistentData().getBoolean("heardSomething") == true) {
				if (entity.getPersistentData().getDouble("moveTimer") <= 0) {
					entity.getPersistentData().putDouble("moveTimer", 4);
					if (entity instanceof Mob _entity)
						_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("targetX")), (entity.getPersistentData().getDouble("targetY")), (entity.getPersistentData().getDouble("targetZ")), 1.25);
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3.25 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (!(entityiterator instanceof HushPuppyEntity || entityiterator instanceof Stray || entityiterator instanceof BoundSoulEntity)) {
								if (entity instanceof Mob _entity && entityiterator instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
								if (entityiterator instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("exploration:hush_a"));
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
					}
				}
				if (entity.getPersistentData().getDouble("moveTimer") > 0) {
					entity.getPersistentData().putDouble("moveTimer", (entity.getPersistentData().getDouble("moveTimer") - 1));
				}
			}
			if ((entity.position()).distanceTo((new Vec3((entity.getPersistentData().getDouble("targetX")), (entity.getPersistentData().getDouble("targetY")), (entity.getPersistentData().getDouble("targetZ"))))) < 1.5) {
				entity.getPersistentData().putBoolean("heardSomething", false);
			}
		}
	}
}