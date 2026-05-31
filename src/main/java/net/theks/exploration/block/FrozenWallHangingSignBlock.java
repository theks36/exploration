package net.theks.exploration.block;

import net.theks.exploration.init.ExplorationModWoodTypes;
import net.theks.exploration.init.ExplorationModBlocks;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.SoundType;

public class FrozenWallHangingSignBlock extends WallHangingSignBlock {
	public FrozenWallHangingSignBlock() {
		super(ExplorationModWoodTypes.FROZEN_HANGING_SIGN_WOOD_TYPE,
				BlockBehaviour.Properties.of().sound(SoundType.HANGING_SIGN).strength(0.8f).noCollission().ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn().dropsLike(ExplorationModBlocks.FROZEN_HANGING_SIGN.get()));
	}
}