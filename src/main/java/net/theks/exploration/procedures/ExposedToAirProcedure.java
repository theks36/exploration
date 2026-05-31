package net.theks.exploration.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ExposedToAirProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getFluidState(BlockPos.containing(x + 1, y, z)).createLegacyBlock()).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))
				|| (world.getFluidState(BlockPos.containing(x - 1, y, z)).createLegacyBlock()).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))
				|| (world.getFluidState(BlockPos.containing(x, y + 1, z)).createLegacyBlock()).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))
				|| (world.getFluidState(BlockPos.containing(x, y - 1, z)).createLegacyBlock()).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))
				|| (world.getFluidState(BlockPos.containing(x, y, z + 1)).createLegacyBlock()).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))
				|| (world.getFluidState(BlockPos.containing(x, y, z - 1)).createLegacyBlock()).is(BlockTags.create(ResourceLocation.parse("minecraft:air")))) {
			return true;
		}
		return false;
	}
}