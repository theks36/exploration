package net.theks.exploration.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.ButtonBlock;

public class LeakingWoodButtonBlock extends ButtonBlock {
	public LeakingWoodButtonBlock() {
		super(BlockSetType.OAK, 30, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.65f).noCollission().pushReaction(PushReaction.DESTROY));
	}
}