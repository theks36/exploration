package net.theks.exploration.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class SerpentiniteDiamondOreBlock extends Block {
	public SerpentiniteDiamondOreBlock() {
		super(BlockBehaviour.Properties.of().strength(1.75f, 4f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}