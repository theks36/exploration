package net.theks.exploration.procedures;

import net.theks.exploration.init.ExplorationModMobEffects;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class BleedingOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, double amplifier) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ExplorationModMobEffects.BLEEDING) ? _livEnt.getEffect(ExplorationModMobEffects.BLEEDING).getDuration() : 0) == Math
				.floor((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ExplorationModMobEffects.BLEEDING) ? _livEnt.getEffect(ExplorationModMobEffects.BLEEDING).getDuration() : 0) / 60d) * 60) {
			entity.hurt(new DamageSource(world.holderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.parse("exploration:bleeding_dt")))), (float) amplifier);
		}
	}
}