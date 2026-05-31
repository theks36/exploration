package net.theks.exploration.procedures;

import net.theks.exploration.init.ExplorationModBlocks;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class LeakingWoodLogOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z)))
				.getBlock() == (Blocks.CAMPFIRE.getStateDefinition().getProperty("lit") instanceof BooleanProperty _withbp1 ? Blocks.CAMPFIRE.defaultBlockState().setValue(_withbp1, true) : Blocks.CAMPFIRE.defaultBlockState()).getBlock()
				|| (world.getBlockState(BlockPos.containing(x, y - 2, z)))
						.getBlock() == (Blocks.CAMPFIRE.getStateDefinition().getProperty("lit") instanceof BooleanProperty _withbp4 ? Blocks.CAMPFIRE.defaultBlockState().setValue(_withbp4, true) : Blocks.CAMPFIRE.defaultBlockState()).getBlock()) {
			if ((getPropertyByName(blockstate, "clusterization") instanceof IntegerProperty _getip7 ? blockstate.getValue(_getip7) : -1) < 3) {
				{
					int _value = (getPropertyByName(blockstate, "clusterization") instanceof IntegerProperty _getip9 ? blockstate.getValue(_getip9) : -1) + 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("clusterization") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
			} else {
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = ExplorationModBlocks.CLUSTERED_LEAKING_WOOD_LOG.get().defaultBlockState();
					BlockState _bso = world.getBlockState(_bp);
					for (Property<?> _propertyOld : _bso.getProperties()) {
						Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
						if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
							try {
								_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
							} catch (Exception e) {
							}
					}
					world.setBlock(_bp, _bs, 3);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.extinguish")), SoundSource.BLOCKS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
					}
				}
			}
		}
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}