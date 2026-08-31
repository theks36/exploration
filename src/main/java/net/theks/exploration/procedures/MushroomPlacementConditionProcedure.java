package net.theks.exploration.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MushroomPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		return Blocks.BROWN_MUSHROOM.defaultBlockState().canSurvive(world, BlockPos.containing(x, y, z));
	}
}