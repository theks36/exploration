package net.theks.exploration.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class BoneClubToolInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("wasAirborne") && entity.onGround()) {
			entity.getPersistentData().putBoolean("wasAirborne", false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.skeleton.step")), SoundSource.PLAYERS, (float) 0.75, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05));
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.skeleton.step")), SoundSource.PLAYERS, (float) 0.75, (float) Mth.nextDouble(RandomSource.create(), 0.95, 1.05), false);
				}
			}
		}
		if (!entity.onGround()) {
			entity.getPersistentData().putBoolean("wasAirborne", true);
		}
	}
}