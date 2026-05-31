/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.theks.exploration.block.*;
import net.theks.exploration.ExplorationMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.renderer.Sheets;

@EventBusSubscriber
public class ExplorationModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ExplorationMod.MODID);
	public static final DeferredBlock<Block> LEAKING_WOOD_LOG;
	public static final DeferredBlock<Block> LEAKING_WOOD;
	public static final DeferredBlock<Block> STRIPPED_LEAKING_WOOD_LOG;
	public static final DeferredBlock<Block> STRIPPED_LEAKING_WOOD_WOOD;
	public static final DeferredBlock<Block> LEAKING_WOOD_PLANKS;
	public static final DeferredBlock<Block> LEAKING_WOOD_LEAVES;
	public static final DeferredBlock<Block> LEAKING_WOOD_STAIRS;
	public static final DeferredBlock<Block> LEAKING_WOOD_SLAB;
	public static final DeferredBlock<Block> LEAKING_WOOD_FENCE;
	public static final DeferredBlock<Block> LEAKING_WOOD_FENCE_GATE;
	public static final DeferredBlock<Block> LEAKING_WOOD_DOOR;
	public static final DeferredBlock<Block> LEAKING_WOOD_TRAPDOOR;
	public static final DeferredBlock<Block> LEAKING_WOOD_PRESSURE_PLATE;
	public static final DeferredBlock<Block> LEAKING_WOOD_BUTTON;
	public static final DeferredBlock<Block> LEAKING_WOOD_SIGN;
	public static final DeferredBlock<Block> LEAKING_WOOD_WALL_SIGN;
	public static final DeferredBlock<Block> LEAKING_WOOD_HANGING_SIGN;
	public static final DeferredBlock<Block> LEAKING_WOOD_WALL_HANGING_SIGN;
	public static final DeferredBlock<Block> CLUSTERED_LEAKING_WOOD_LOG;
	public static final DeferredBlock<Block> RESIN_CLUSTER_BLOCK;
	public static final DeferredBlock<Block> SMOOTH_RESIN_BLOCK;
	public static final DeferredBlock<Block> SMOOTH_RESIN_STAIRS;
	public static final DeferredBlock<Block> SHALE;
	public static final DeferredBlock<Block> COBBLED_SHALE;
	public static final DeferredBlock<Block> AMBER_ORE;
	public static final DeferredBlock<Block> COBBLED_SHALE_STAIRS;
	public static final DeferredBlock<Block> COBBLED_SHALE_SLAB;
	public static final DeferredBlock<Block> SHALE_IRON;
	public static final DeferredBlock<Block> SHALE_GOLD;
	public static final DeferredBlock<Block> SHALE_REDSTONE;
	public static final DeferredBlock<Block> SHALE_COAL;
	public static final DeferredBlock<Block> RESIN_MUSHROOM;
	public static final DeferredBlock<Block> SMOOTH_RESIN_BRICKS;
	public static final DeferredBlock<Block> SMOOTH_RESIN_BRICK_SLAB;
	public static final DeferredBlock<Block> CHISELED_SMOOTH_RESIN_BRICKS;
	public static final DeferredBlock<Block> SMOOTH_RESIN_BRICK_WALL;
	public static final DeferredBlock<Block> SERPENTINITE;
	public static final DeferredBlock<Block> COBBLED_SERPENTINITE;
	public static final DeferredBlock<Block> NEPHRITE_ORE;
	public static final DeferredBlock<Block> POLISHED_SERPENTINITE;
	public static final DeferredBlock<Block> THE_EXPLORATION_PORTAL;
	public static final DeferredBlock<Block> FROZEN_LOG;
	public static final DeferredBlock<Block> FROZEN_WOOD;
	public static final DeferredBlock<Block> STRIPPED_FROZEN_LOG;
	public static final DeferredBlock<Block> STRIPPED_FROZEN_WOOD;
	public static final DeferredBlock<Block> FROZEN_PLANKS;
	public static final DeferredBlock<Block> FROZEN_LEAVES;
	public static final DeferredBlock<Block> FROZEN_STAIRS;
	public static final DeferredBlock<Block> FROZEN_SLAB;
	public static final DeferredBlock<Block> FROZEN_FENCE;
	public static final DeferredBlock<Block> FROZEN_FENCE_GATE;
	public static final DeferredBlock<Block> FROZEN_DOOR;
	public static final DeferredBlock<Block> FROZEN_TRAPDOOR;
	public static final DeferredBlock<Block> FROZEN_PRESSURE_PLATE;
	public static final DeferredBlock<Block> FROZEN_BUTTON;
	public static final DeferredBlock<Block> FROZEN_SIGN;
	public static final DeferredBlock<Block> FROZEN_WALL_SIGN;
	public static final DeferredBlock<Block> FROZEN_HANGING_SIGN;
	public static final DeferredBlock<Block> FROZEN_WALL_HANGING_SIGN;
	public static final DeferredBlock<Block> SERPENTINITE_BRICKS;
	public static final DeferredBlock<Block> SERPENTINITE_BRICK_STAIRS;
	public static final DeferredBlock<Block> SERPENTINITE_BRICKS_SLAB;
	public static final DeferredBlock<Block> SERPENTINITE_PRESSURE_PLATE;
	public static final DeferredBlock<Block> SERPENTINITE_COAL_ORE;
	public static final DeferredBlock<Block> SERPENTINITE_DIAMOND_ORE;
	public static final DeferredBlock<Block> GNEISS;
	public static final DeferredBlock<Block> HEMATITE_ORE;
	public static final DeferredBlock<Block> COBBLED_GNEISS;
	public static final DeferredBlock<Block> GNEISS_COAL_ORE;
	public static final DeferredBlock<Block> GNEISS_COPPER_ORE;
	public static final DeferredBlock<Block> GNEISS_IRON_ORE;
	public static final DeferredBlock<Block> SERPENTINITE_IRON_ORE;
	public static final DeferredBlock<Block> BLOCK_OF_NEPHRITE;
	public static final DeferredBlock<Block> GNEISS_LAPIS_LAZULI_ORE;
	public static final DeferredBlock<Block> GNEISS_GOLD_ORE;
	public static final DeferredBlock<Block> MOONSTONE;
	public static final DeferredBlock<Block> MOONITE_ORE;
	public static final DeferredBlock<Block> BLOCK_OF_MOONITE;
	public static final DeferredBlock<Block> LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> BLUE_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> CYAN_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> GREEN_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> LIGHT_BLUE_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> LIME_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> MAGENTA_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> ORANGE_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> PINK_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> PURPLE_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> RED_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> YELLOW_LUMINANT_CRYSTAL;
	public static final DeferredBlock<Block> UMBRASTONE;
	public static final DeferredBlock<Block> CRYSTALIZED_UMBRASTONE;
	public static final DeferredBlock<Block> PULSATING_LAMP;
	public static final DeferredBlock<Block> UMBRASTONE_STAIRS;
	public static final DeferredBlock<Block> UMBRASTONE_SLAB;
	public static final DeferredBlock<Block> UNDEAD_DIRT;
	public static final DeferredBlock<Block> ENGRAVED_STONE_BRICKS;
	static {
		LEAKING_WOOD_LOG = REGISTRY.register("leaking_wood_log", LeakingWoodLogBlock::new);
		LEAKING_WOOD = REGISTRY.register("leaking_wood", LeakingWoodWoodBlock::new);
		STRIPPED_LEAKING_WOOD_LOG = REGISTRY.register("stripped_leaking_wood_log", StrippedLeakingWoodLogBlock::new);
		STRIPPED_LEAKING_WOOD_WOOD = REGISTRY.register("stripped_leaking_wood_wood", StrippedLeakingWoodWoodBlock::new);
		LEAKING_WOOD_PLANKS = REGISTRY.register("leaking_wood_planks", LeakingWoodPlanksBlock::new);
		LEAKING_WOOD_LEAVES = REGISTRY.register("leaking_wood_leaves", LeakingWoodLeavesBlock::new);
		LEAKING_WOOD_STAIRS = REGISTRY.register("leaking_wood_stairs", LeakingWoodStairsBlock::new);
		LEAKING_WOOD_SLAB = REGISTRY.register("leaking_wood_slab", LeakingWoodSlabBlock::new);
		LEAKING_WOOD_FENCE = REGISTRY.register("leaking_wood_fence", LeakingWoodFenceBlock::new);
		LEAKING_WOOD_FENCE_GATE = REGISTRY.register("leaking_wood_fence_gate", LeakingWoodFenceGateBlock::new);
		LEAKING_WOOD_DOOR = REGISTRY.register("leaking_wood_door", LeakingWoodDoorBlock::new);
		LEAKING_WOOD_TRAPDOOR = REGISTRY.register("leaking_wood_trapdoor", LeakingWoodTrapdoorBlock::new);
		LEAKING_WOOD_PRESSURE_PLATE = REGISTRY.register("leaking_wood_pressure_plate", LeakingWoodPressurePlateBlock::new);
		LEAKING_WOOD_BUTTON = REGISTRY.register("leaking_wood_button", LeakingWoodButtonBlock::new);
		LEAKING_WOOD_SIGN = REGISTRY.register("leaking_wood_sign", LeakingWoodSignBlock::new);
		LEAKING_WOOD_WALL_SIGN = REGISTRY.register("leaking_wood_wall_sign", LeakingWoodWallSignBlock::new);
		LEAKING_WOOD_HANGING_SIGN = REGISTRY.register("leaking_wood_hanging_sign", LeakingWoodHangingSignBlock::new);
		LEAKING_WOOD_WALL_HANGING_SIGN = REGISTRY.register("leaking_wood_wall_hanging_sign", LeakingWoodWallHangingSignBlock::new);
		CLUSTERED_LEAKING_WOOD_LOG = REGISTRY.register("clustered_leaking_wood_log", ClusteredLeakingWoodLogBlock::new);
		RESIN_CLUSTER_BLOCK = REGISTRY.register("resin_cluster_block", ResinClusterBlockBlock::new);
		SMOOTH_RESIN_BLOCK = REGISTRY.register("smooth_resin_block", SmoothResinBlockBlock::new);
		SMOOTH_RESIN_STAIRS = REGISTRY.register("smooth_resin_stairs", SmoothResinStairsBlock::new);
		SHALE = REGISTRY.register("shale", ShaleBlock::new);
		COBBLED_SHALE = REGISTRY.register("cobbled_shale", CobbledShaleBlock::new);
		AMBER_ORE = REGISTRY.register("amber_ore", AmberOreBlock::new);
		COBBLED_SHALE_STAIRS = REGISTRY.register("cobbled_shale_stairs", CobbledShaleStairsBlock::new);
		COBBLED_SHALE_SLAB = REGISTRY.register("cobbled_shale_slab", CobbledShaleSlabBlock::new);
		SHALE_IRON = REGISTRY.register("shale_iron", ShaleIronBlock::new);
		SHALE_GOLD = REGISTRY.register("shale_gold", ShaleGoldBlock::new);
		SHALE_REDSTONE = REGISTRY.register("shale_redstone", ShaleRedstoneBlock::new);
		SHALE_COAL = REGISTRY.register("shale_coal", ShaleCoalBlock::new);
		RESIN_MUSHROOM = REGISTRY.register("resin_mushroom", ResinMushroomBlock::new);
		SMOOTH_RESIN_BRICKS = REGISTRY.register("smooth_resin_bricks", SmoothResinBricksBlock::new);
		SMOOTH_RESIN_BRICK_SLAB = REGISTRY.register("smooth_resin_brick_slab", SmoothResinBrickSlabBlock::new);
		CHISELED_SMOOTH_RESIN_BRICKS = REGISTRY.register("chiseled_smooth_resin_bricks", ChiseledSmoothResinBricksBlock::new);
		SMOOTH_RESIN_BRICK_WALL = REGISTRY.register("smooth_resin_brick_wall", SmoothResinBrickWallBlock::new);
		SERPENTINITE = REGISTRY.register("serpentinite", SerpentiniteBlock::new);
		COBBLED_SERPENTINITE = REGISTRY.register("cobbled_serpentinite", CobbledSerpentiniteBlock::new);
		NEPHRITE_ORE = REGISTRY.register("nephrite_ore", NephriteOreBlock::new);
		POLISHED_SERPENTINITE = REGISTRY.register("polished_serpentinite", PolishedSerpentiniteBlock::new);
		THE_EXPLORATION_PORTAL = REGISTRY.register("the_exploration_portal", TheExplorationPortalBlock::new);
		FROZEN_LOG = REGISTRY.register("frozen_log", FrozenLogBlock::new);
		FROZEN_WOOD = REGISTRY.register("frozen_wood", FrozenWoodBlock::new);
		STRIPPED_FROZEN_LOG = REGISTRY.register("stripped_frozen_log", StrippedFrozenLogBlock::new);
		STRIPPED_FROZEN_WOOD = REGISTRY.register("stripped_frozen_wood", StrippedFrozenWoodBlock::new);
		FROZEN_PLANKS = REGISTRY.register("frozen_planks", FrozenPlanksBlock::new);
		FROZEN_LEAVES = REGISTRY.register("frozen_leaves", FrozenLeavesBlock::new);
		FROZEN_STAIRS = REGISTRY.register("frozen_stairs", FrozenStairsBlock::new);
		FROZEN_SLAB = REGISTRY.register("frozen_slab", FrozenSlabBlock::new);
		FROZEN_FENCE = REGISTRY.register("frozen_fence", FrozenFenceBlock::new);
		FROZEN_FENCE_GATE = REGISTRY.register("frozen_fence_gate", FrozenFenceGateBlock::new);
		FROZEN_DOOR = REGISTRY.register("frozen_door", FrozenDoorBlock::new);
		FROZEN_TRAPDOOR = REGISTRY.register("frozen_trapdoor", FrozenTrapdoorBlock::new);
		FROZEN_PRESSURE_PLATE = REGISTRY.register("frozen_pressure_plate", FrozenPressurePlateBlock::new);
		FROZEN_BUTTON = REGISTRY.register("frozen_button", FrozenButtonBlock::new);
		FROZEN_SIGN = REGISTRY.register("frozen_sign", FrozenSignBlock::new);
		FROZEN_WALL_SIGN = REGISTRY.register("frozen_wall_sign", FrozenWallSignBlock::new);
		FROZEN_HANGING_SIGN = REGISTRY.register("frozen_hanging_sign", FrozenHangingSignBlock::new);
		FROZEN_WALL_HANGING_SIGN = REGISTRY.register("frozen_wall_hanging_sign", FrozenWallHangingSignBlock::new);
		SERPENTINITE_BRICKS = REGISTRY.register("serpentinite_bricks", SerpentiniteBricksBlock::new);
		SERPENTINITE_BRICK_STAIRS = REGISTRY.register("serpentinite_brick_stairs", SerpentiniteBrickStairsBlock::new);
		SERPENTINITE_BRICKS_SLAB = REGISTRY.register("serpentinite_bricks_slab", SerpentiniteBricksSlabBlock::new);
		SERPENTINITE_PRESSURE_PLATE = REGISTRY.register("serpentinite_pressure_plate", SerpentinitePressurePlateBlock::new);
		SERPENTINITE_COAL_ORE = REGISTRY.register("serpentinite_coal_ore", SerpentiniteCoalOreBlock::new);
		SERPENTINITE_DIAMOND_ORE = REGISTRY.register("serpentinite_diamond_ore", SerpentiniteDiamondOreBlock::new);
		GNEISS = REGISTRY.register("gneiss", GneissBlock::new);
		HEMATITE_ORE = REGISTRY.register("hematite_ore", HematiteOreBlock::new);
		COBBLED_GNEISS = REGISTRY.register("cobbled_gneiss", CobbledGneissBlock::new);
		GNEISS_COAL_ORE = REGISTRY.register("gneiss_coal_ore", GneissCoalOreBlock::new);
		GNEISS_COPPER_ORE = REGISTRY.register("gneiss_copper_ore", GneissCopperOreBlock::new);
		GNEISS_IRON_ORE = REGISTRY.register("gneiss_iron_ore", GneissIronOreBlock::new);
		SERPENTINITE_IRON_ORE = REGISTRY.register("serpentinite_iron_ore", SerpentiniteIronOreBlock::new);
		BLOCK_OF_NEPHRITE = REGISTRY.register("block_of_nephrite", BlockOfNephriteBlock::new);
		GNEISS_LAPIS_LAZULI_ORE = REGISTRY.register("gneiss_lapis_lazuli_ore", GneissLapisLazuliOreBlock::new);
		GNEISS_GOLD_ORE = REGISTRY.register("gneiss_gold_ore", GneissGoldOreBlock::new);
		MOONSTONE = REGISTRY.register("moonstone", MoonstoneBlock::new);
		MOONITE_ORE = REGISTRY.register("moonite_ore", MooniteOreBlock::new);
		BLOCK_OF_MOONITE = REGISTRY.register("block_of_moonite", BlockOfMooniteBlock::new);
		LUMINANT_CRYSTAL = REGISTRY.register("luminant_crystal", LuminantCrystalBlock::new);
		BLUE_LUMINANT_CRYSTAL = REGISTRY.register("blue_luminant_crystal", BlueLuminantCrystalBlock::new);
		CYAN_LUMINANT_CRYSTAL = REGISTRY.register("cyan_luminant_crystal", CyanLuminantCrystalBlock::new);
		GREEN_LUMINANT_CRYSTAL = REGISTRY.register("green_luminant_crystal", GreenLuminantCrystalBlock::new);
		LIGHT_BLUE_LUMINANT_CRYSTAL = REGISTRY.register("light_blue_luminant_crystal", LightBlueLuminantCrystalBlock::new);
		LIME_LUMINANT_CRYSTAL = REGISTRY.register("lime_luminant_crystal", LimeLuminantCrystalBlock::new);
		MAGENTA_LUMINANT_CRYSTAL = REGISTRY.register("magenta_luminant_crystal", MagentaLuminantCrystalBlock::new);
		ORANGE_LUMINANT_CRYSTAL = REGISTRY.register("orange_luminant_crystal", OrangeLuminantCrystalBlock::new);
		PINK_LUMINANT_CRYSTAL = REGISTRY.register("pink_luminant_crystal", PinkLuminantCrystalBlock::new);
		PURPLE_LUMINANT_CRYSTAL = REGISTRY.register("purple_luminant_crystal", PurpleLuminantCrystalBlock::new);
		RED_LUMINANT_CRYSTAL = REGISTRY.register("red_luminant_crystal", RedLuminantCrystalBlock::new);
		YELLOW_LUMINANT_CRYSTAL = REGISTRY.register("yellow_luminant_crystal", YellowLuminantCrystalBlock::new);
		UMBRASTONE = REGISTRY.register("umbrastone", UmbrastoneBlock::new);
		CRYSTALIZED_UMBRASTONE = REGISTRY.register("crystalized_umbrastone", CrystalizedUmbrastoneBlock::new);
		PULSATING_LAMP = REGISTRY.register("pulsating_lamp", PulsatingLampBlock::new);
		UMBRASTONE_STAIRS = REGISTRY.register("umbrastone_stairs", UmbrastoneStairsBlock::new);
		UMBRASTONE_SLAB = REGISTRY.register("umbrastone_slab", UmbrastoneSlabBlock::new);
		UNDEAD_DIRT = REGISTRY.register("undead_dirt", UndeadDirtBlock::new);
		ENGRAVED_STONE_BRICKS = REGISTRY.register("engraved_stone_bricks", EngravedStoneBricksBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@EventBusSubscriber(Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			Sheets.addWoodType(ExplorationModWoodTypes.LEAKING_WOOD_SIGN_WOOD_TYPE);
			Sheets.addWoodType(ExplorationModWoodTypes.LEAKING_WOOD_HANGING_SIGN_WOOD_TYPE);
			Sheets.addWoodType(ExplorationModWoodTypes.FROZEN_SIGN_WOOD_TYPE);
			Sheets.addWoodType(ExplorationModWoodTypes.FROZEN_HANGING_SIGN_WOOD_TYPE);
		}
	}

	@SubscribeEvent
	public static void registerSigns(BlockEntityTypeAddBlocksEvent event) {
		event.modify(BlockEntityType.SIGN, LEAKING_WOOD_SIGN.get(), LEAKING_WOOD_WALL_SIGN.get());
		event.modify(BlockEntityType.HANGING_SIGN, LEAKING_WOOD_HANGING_SIGN.get(), LEAKING_WOOD_WALL_HANGING_SIGN.get());
		event.modify(BlockEntityType.SIGN, FROZEN_SIGN.get(), FROZEN_WALL_SIGN.get());
		event.modify(BlockEntityType.HANGING_SIGN, FROZEN_HANGING_SIGN.get(), FROZEN_WALL_HANGING_SIGN.get());
	}
}