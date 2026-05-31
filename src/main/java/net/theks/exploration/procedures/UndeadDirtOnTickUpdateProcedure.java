package net.theks.exploration.procedures;

import net.theks.exploration.init.ExplorationModEntities;
import net.theks.exploration.init.ExplorationModBlocks;
import net.theks.exploration.ExplorationMod;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class UndeadDirtOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((getPropertyByName(blockstate, "growth") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) < 5) {
			{
				int _value = (getPropertyByName(blockstate, "growth") instanceof IntegerProperty _getip3 ? blockstate.getValue(_getip3) : -1) + 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("growth") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else {
			if ((world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("exploration:graveyard")) || Math.random() < 0.1) && !world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()
					&& !world.getBlockState(BlockPos.containing(x, y + 2, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
				ExplorationMod.queueServerWork(20, () -> {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(ExplorationModBlocks.UNDEAD_DIRT.get().defaultBlockState()));
				});
				ExplorationMod.queueServerWork(40, () -> {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(ExplorationModBlocks.UNDEAD_DIRT.get().defaultBlockState()));
				});
				ExplorationMod.queueServerWork(60, () -> {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(ExplorationModBlocks.UNDEAD_DIRT.get().defaultBlockState()));
				});
				ExplorationMod.queueServerWork(80, () -> {
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(ExplorationModBlocks.UNDEAD_DIRT.get().defaultBlockState()));
					world.levelEvent(2001, BlockPos.containing(x, y, z), Block.getId(ExplorationModBlocks.UNDEAD_DIRT.get().defaultBlockState()));
					if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SAND) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.HUSK.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.SNOW_BLOCK) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.STRAY.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BONE_BLOCK) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.SKELETON.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.MUD) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.BOGGED.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.NETHERRACK) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.ZOMBIFIED_PIGLIN.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.JACK_O_LANTERN) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = ExplorationModEntities.JACKO.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else {
						if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("exploration:graveyard")) && Math.random() <= 0.25) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = ExplorationModEntities.JACKO.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ZOMBIE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
					}
					{
						int _value = 0;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("growth") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
					if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == ExplorationModBlocks.UNDEAD_DIRT.get()) {
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("growth") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
					if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == ExplorationModBlocks.UNDEAD_DIRT.get()) {
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("growth") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == ExplorationModBlocks.UNDEAD_DIRT.get()) {
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x, y, z + 1);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("growth") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
					if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == ExplorationModBlocks.UNDEAD_DIRT.get()) {
						{
							int _value = 0;
							BlockPos _pos = BlockPos.containing(x, y, z - 1);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("growth") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					}
				});
			} else {
				{
					int _value = 0;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("growth") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
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