package net.theks.exploration.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class BlockOfMooniteBlock extends Block {
	public BlockOfMooniteBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(15f, 10f).requiresCorrectToolForDrops());
	}
}