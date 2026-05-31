/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.theks.exploration.init;

import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class ExplorationModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == ExplorationModVillagerProfessions.RESIN_CASTER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD), new ItemStack(ExplorationModBlocks.SMOOTH_RESIN_BLOCK.get(), 2), 10, 5, 0.05f));
		}
		if (event.getType() == ExplorationModVillagerProfessions.RESIN_CASTER.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(ExplorationModItems.RESIN_CLUSTER.get(), 32), new ItemStack(Items.EMERALD), 10, 5, 0.05f));
		}
	}
}