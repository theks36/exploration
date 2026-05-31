/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.theks.exploration.potion.BleedingMobEffect;
import net.theks.exploration.ExplorationMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

public class ExplorationModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, ExplorationMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> BLEEDING = REGISTRY.register("bleeding", () -> new BleedingMobEffect());
}