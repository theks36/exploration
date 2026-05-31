package net.theks.exploration.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class ResinClusterBlockBlock extends Block {
	public ResinClusterBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(1f, 10f).requiresCorrectToolForDrops());
	}
}