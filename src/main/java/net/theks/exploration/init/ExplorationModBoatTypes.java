/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.function.Supplier;

public class ExplorationModBoatTypes {
	public static final EnumProxy<Boat.Type> LEAKING_WOOD_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "exploration:leaking_wood_boat", ExplorationModItems.LEAKING_WOOD_BOAT,
			(Supplier<Item>) () -> Items.AIR, (Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> LEAKING_WOOD_CHEST_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "exploration:leaking_wood_chest_boat", (Supplier<Item>) () -> Items.AIR,
			ExplorationModItems.LEAKING_WOOD_CHEST_BOAT, (Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> FROZEN_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "exploration:frozen_boat", ExplorationModItems.FROZEN_BOAT, (Supplier<Item>) () -> Items.AIR,
			(Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> FROZEN_CHEST_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "exploration:frozen_chest_boat", (Supplier<Item>) () -> Items.AIR,
			ExplorationModItems.FROZEN_CHEST_BOAT, (Supplier<Item>) () -> Items.STICK, false);
}