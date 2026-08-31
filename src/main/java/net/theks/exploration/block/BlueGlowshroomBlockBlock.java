package net.theks.exploration.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.util.FastColor;
import net.minecraft.core.BlockPos;

public class BlueGlowshroomBlockBlock extends Block {
	public BlueGlowshroomBlockBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.2f).lightLevel(blockstate -> 10).instrument(NoteBlockInstrument.BASS));
	}

	@Override
	public Integer getBeaconColorMultiplier(BlockState state, LevelReader world, BlockPos pos, BlockPos beaconPos) {
		return FastColor.ARGB32.opaque(-16738048);
	}
}