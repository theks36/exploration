/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber
public class ExplorationModGameRules {
	public static GameRules.Key<GameRules.BooleanValue> SPAWN_IN_EXPLORATION;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		SPAWN_IN_EXPLORATION = GameRules.register("spawnInExploration", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(false));
	}
}