package net.theks.exploration.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;

public class CobbledShaleSlabBlock extends SlabBlock {
	public CobbledShaleSlabBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.TUFF).strength(1f, 10f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}