package net.theks.exploration.world.features;

import net.theks.exploration.procedures.CantSeeSkyConditionProcedure;

import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.HugeRedMushroomFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class BigGreenGlowshroomFeature extends HugeRedMushroomFeature {
	public BigGreenGlowshroomFeature() {
		super(HugeMushroomFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<HugeMushroomFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!CantSeeSkyConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}