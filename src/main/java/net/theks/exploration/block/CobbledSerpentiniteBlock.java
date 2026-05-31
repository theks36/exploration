package net.theks.exploration.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class CobbledSerpentiniteBlock extends Block {
	public CobbledSerpentiniteBlock() {
		super(BlockBehaviour.Properties.of().strength(1.75f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}