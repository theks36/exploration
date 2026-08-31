package net.theks.exploration.procedures;

import net.theks.exploration.init.ExplorationModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class FairyOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double Cooldown = 0;
		if (Cooldown <= 0) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))) {
				world.setBlock(BlockPos.containing(x, y, z), ExplorationModBlocks.FAIRY_LIGHT.get().defaultBlockState(), 3);
				Cooldown = 20;
			}
		} else {
			Cooldown = Cooldown + 1;
		}
	}
}