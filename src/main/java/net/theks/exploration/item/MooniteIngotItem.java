package net.theks.exploration.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MooniteIngotItem extends Item {
	public MooniteIngotItem() {
		super(new Item.Properties().fireResistant().rarity(Rarity.RARE));
	}
}