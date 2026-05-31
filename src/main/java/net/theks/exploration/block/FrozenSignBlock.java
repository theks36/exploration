package net.theks.exploration.block;

import net.theks.exploration.init.ExplorationModWoodTypes;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.SoundType;

public class FrozenSignBlock extends StandingSignBlock {
	public FrozenSignBlock() {
		super(ExplorationModWoodTypes.FROZEN_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.8f).noCollission().ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn());
	}
}