/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;

@EventBusSubscriber
public class ExplorationModDispenseBehaviors {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DispenserBlock.registerBehavior(ExplorationModItems.LEAKING_WOOD_BOAT.get(), new BoatDispenseItemBehavior(ExplorationModBoatTypes.LEAKING_WOOD_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(ExplorationModItems.LEAKING_WOOD_CHEST_BOAT.get(), new BoatDispenseItemBehavior(ExplorationModBoatTypes.LEAKING_WOOD_CHEST_BOAT_TYPE.getValue(), true));
			DispenserBlock.registerBehavior(ExplorationModItems.FROZEN_BOAT.get(), new BoatDispenseItemBehavior(ExplorationModBoatTypes.FROZEN_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(ExplorationModItems.FROZEN_CHEST_BOAT.get(), new BoatDispenseItemBehavior(ExplorationModBoatTypes.FROZEN_CHEST_BOAT_TYPE.getValue(), true));
		});
	}
}