package net.theks.exploration.procedures;

import net.minecraft.world.item.ItemStack;

public class DeleteItemOnInventoryTickProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.setCount(0);
	}
}