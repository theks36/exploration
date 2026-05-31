package net.theks.exploration.world.features;

import net.theks.exploration.procedures.ExposedToAirAndTouchingSolidProcedure;

import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.RandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class PurpleCrystalsFeature extends RandomSelectorFeature {
	public PurpleCrystalsFeature() {
		super(RandomFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!ExposedToAirAndTouchingSolidProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}