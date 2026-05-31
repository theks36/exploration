package net.theks.exploration.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MooniteItem extends Item {
	public MooniteItem() {
		super(new Item.Properties().fireResistant().rarity(Rarity.RARE));
	}
}