package net.theks.exploration.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SlabBlock;

public class SerpentiniteBricksSlabBlock extends SlabBlock {
	public SerpentiniteBricksSlabBlock() {
		super(BlockBehaviour.Properties.of().strength(1.75f, 4f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}