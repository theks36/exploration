package net.theks.exploration.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.PressurePlateBlock;

public class SerpentinitePressurePlateBlock extends PressurePlateBlock {
	public SerpentinitePressurePlateBlock() {
		super(BlockSetType.STONE, BlockBehaviour.Properties.of().strength(1.75f, 4f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).forceSolidOn());
	}
}