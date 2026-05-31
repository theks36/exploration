package net.theks.exploration.block;

import net.theks.exploration.init.ExplorationModWoodTypes;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.CeilingHangingSignBlock;

public class LeakingWoodHangingSignBlock extends CeilingHangingSignBlock {
	public LeakingWoodHangingSignBlock() {
		super(ExplorationModWoodTypes.LEAKING_WOOD_HANGING_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().sound(SoundType.HANGING_SIGN).strength(1.3f).noCollission().ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn());
	}
}