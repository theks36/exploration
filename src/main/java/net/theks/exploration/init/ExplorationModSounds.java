/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.theks.exploration.ExplorationMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class ExplorationModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, ExplorationMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_ETERNAL_WINTER = REGISTRY.register("music.eternal_winter", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("exploration", "music.eternal_winter")));
}