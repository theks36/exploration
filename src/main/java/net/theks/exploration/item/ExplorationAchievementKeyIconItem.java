package net.theks.exploration.item;

import net.theks.exploration.procedures.DeleteItemOnInventoryTickProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

public class ExplorationAchievementKeyIconItem extends Item {
	public ExplorationAchievementKeyIconItem() {
		super(new Item.Properties());
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		DeleteItemOnInventoryTickProcedure.execute(itemstack);
	}
}