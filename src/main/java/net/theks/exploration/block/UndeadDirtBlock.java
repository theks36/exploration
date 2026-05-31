package net.theks.exploration.block;

import net.theks.exploration.procedures.UndeadDirtOnTickUpdateProcedure;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class UndeadDirtBlock extends Block {
	public static final IntegerProperty GROWTH = IntegerProperty.create("growth", 0, 5);

	public UndeadDirtBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GRAVEL).strength(5f, 10f).requiresCorrectToolForDrops().randomTicks());
		this.registerDefaultState(this.stateDefinition.any().setValue(GROWTH, 0));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(GROWTH);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(GROWTH, 0);
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.randomTick(blockstate, world, pos, random);
		UndeadDirtOnTickUpdateProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}
}