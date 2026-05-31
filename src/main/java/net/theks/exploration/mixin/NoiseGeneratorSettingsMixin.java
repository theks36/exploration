package net.theks.exploration.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.theks.exploration.init.ExplorationModBiomes;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements ExplorationModBiomes.ExplorationModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> exploration_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.exploration_dimensionTypeReference != null) {
			retval = ExplorationModBiomes.adaptSurfaceRule(retval, this.exploration_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setexplorationDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.exploration_dimensionTypeReference = dimensionType;
	}
}