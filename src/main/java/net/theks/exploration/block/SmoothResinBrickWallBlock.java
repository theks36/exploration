package net.theks.exploration.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;

public class SmoothResinBrickWallBlock extends WallBlock {
	public SmoothResinBrickWallBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(1f, 10f).requiresCorrectToolForDrops().forceSolidOn());
	}
}