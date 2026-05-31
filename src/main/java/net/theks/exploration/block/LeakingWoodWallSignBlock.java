package net.theks.exploration.block;

import net.theks.exploration.init.ExplorationModWoodTypes;
import net.theks.exploration.init.ExplorationModBlocks;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.SoundType;

public class LeakingWoodWallSignBlock extends WallSignBlock {
	public LeakingWoodWallSignBlock() {
		super(ExplorationModWoodTypes.LEAKING_WOOD_SIGN_WOOD_TYPE,
				BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1.3f).noCollission().ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn().dropsLike(ExplorationModBlocks.LEAKING_WOOD_SIGN.get()));
	}
}