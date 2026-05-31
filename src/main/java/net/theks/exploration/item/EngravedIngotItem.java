package net.theks.exploration.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EngravedIngotItem extends Item {
	public EngravedIngotItem() {
		super(new Item.Properties().rarity(Rarity.UNCOMMON));
	}
}