package net.theks.exploration.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockOfNephriteBlock extends Block {
	public BlockOfNephriteBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 20f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BIT));
	}
}