package net.theks.exploration.world.features;

import net.theks.exploration.procedures.ExplorationDimensionConditionProcedure;

import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.RandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class MoonAsteroidFeature extends RandomSelectorFeature {
	public MoonAsteroidFeature() {
		super(RandomFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!ExplorationDimensionConditionProcedure.execute(world))
			return false;
		return super.place(context);
	}
}