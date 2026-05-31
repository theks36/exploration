package net.theks.exploration.block;

import net.theks.exploration.init.ExplorationModWoodTypes;
import net.theks.exploration.init.ExplorationModBlocks;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.SoundType;

public class FrozenWallSignBlock extends WallSignBlock {
	public FrozenWallSignBlock() {
		super(ExplorationModWoodTypes.FROZEN_SIGN_WOOD_TYPE,
				BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.8f).noCollission().ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn().dropsLike(ExplorationModBlocks.FROZEN_SIGN.get()));
	}
}