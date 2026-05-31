package net.theks.exploration.block;

import net.theks.exploration.procedures.PulsatingLampOnTickUpdateProcedure;
import net.theks.exploration.procedures.PulsatingLampLuminanceProcedure;
import net.theks.exploration.procedures.PulsatingLampBlockAddedProcedure;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class PulsatingLampBlock extends Block {
	public static final IntegerProperty LIGHTLEVEL = IntegerProperty.create("lightlevel", 3, 15);
	public static final IntegerProperty LIGHTLEVEL_SKIN = IntegerProperty.create("lightlevel_skin", 1, 4);
	public static final BooleanProperty LIGHTLEVEL_ASCENDING = BooleanProperty.create("lightlevel_ascending");

	public PulsatingLampBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(1.5f, 5f).lightLevel(blockstate -> (int) PulsatingLampLuminanceProcedure.execute(blockstate)).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.instrument(NoteBlockInstrument.HAT));
		this.registerDefaultState(this.stateDefinition.any().setValue(LIGHTLEVEL, 3).setValue(LIGHTLEVEL_SKIN, 1).setValue(LIGHTLEVEL_ASCENDING, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(LIGHTLEVEL, LIGHTLEVEL_SKIN, LIGHTLEVEL_ASCENDING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(LIGHTLEVEL, 3).setValue(LIGHTLEVEL_SKIN, 1).setValue(LIGHTLEVEL_ASCENDING, false);
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 5);
		PulsatingLampBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		PulsatingLampOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		world.scheduleTick(pos, this, 5);
	}
}