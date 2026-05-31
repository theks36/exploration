/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.theks.exploration.world.features.*;
import net.theks.exploration.ExplorationMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

public class ExplorationModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, ExplorationMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> MOON_ASTEROID = REGISTRY.register("moon_asteroid", MoonAsteroidFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> WHITE_CRYSTALS = REGISTRY.register("white_crystals", WhiteCrystalsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> RED_CRYSTALS = REGISTRY.register("red_crystals", RedCrystalsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GREEN_CRYSTALS = REGISTRY.register("green_crystals", GreenCrystalsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> BLUE_CRYSTALS = REGISTRY.register("blue_crystals", BlueCrystalsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> PURPLE_CRYSTALS = REGISTRY.register("purple_crystals", PurpleCrystalsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> YELLOW_CRYSTALS = REGISTRY.register("yellow_crystals", YellowCrystalsFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> GRAVEYARD_TOMBSTONES = REGISTRY.register("graveyard_tombstones", GraveyardTombstonesFeature::new);
}