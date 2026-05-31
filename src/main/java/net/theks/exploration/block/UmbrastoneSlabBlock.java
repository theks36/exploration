package net.theks.exploration.block;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;

public class UmbrastoneSlabBlock extends SlabBlock {
	public UmbrastoneSlabBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(3f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}