package net.theks.exploration.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GraveyardLightningProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		double customX = 0;
		double customY = 0;
		double customZ = 0;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("exploration:graveyard")) && Math.random() < 0.005) {
			customX = x + Math.random() * 64 - 32;
			customZ = z + Math.random() * 64 - 32;
			customY = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) customX, (int) customZ);
			if (world.getBiome(BlockPos.containing(customX, customY, customZ)).is(ResourceLocation.parse("exploration:graveyard"))) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.LIGHTNING_BOLT.spawn(_level, BlockPos.containing(customX, customY, customZ), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
		}
	}
}