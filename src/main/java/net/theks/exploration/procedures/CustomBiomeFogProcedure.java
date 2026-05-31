package net.theks.exploration.procedures;

import net.neoforged.neoforge.client.event.ViewportEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@EventBusSubscriber(Dist.CLIENT)
public class CustomBiomeFogProcedure {
	@SubscribeEvent
	public static void onSkyRendered(ViewportEvent.RenderFog event) {
		if (event.getMode() == FogRenderer.FogMode.FOG_TERRAIN) {
			Minecraft mc = Minecraft.getInstance();
			execute(event, mc.player.level(), mc.player.getX(), mc.player.getY(), mc.player.getZ(), mc.player, event);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ViewportEvent.RenderFog fogRenderEvent) {
		execute(null, world, x, y, z, entity, fogRenderEvent);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ViewportEvent.RenderFog fogRenderEvent) {
		if (entity == null || fogRenderEvent == null)
			return;
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("exploration:forest_of_eternal_winter"))) {
			fogRenderEvent.setNearPlaneDistance(10);
			fogRenderEvent.setFarPlaneDistance(25);
			if (!fogRenderEvent.isCanceled()) {
				fogRenderEvent.setCanceled(true);
			}
		} else if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("exploration:graveyard"))) {
			fogRenderEvent.setNearPlaneDistance(10);
			fogRenderEvent.setFarPlaneDistance(50);
			if (!fogRenderEvent.isCanceled()) {
				fogRenderEvent.setCanceled(true);
			}
		} else {
			if (!entity.isSwimming() && (world.getBlockState(BlockPos.containing(x, y + 1.25, z))).getFluidState().isSource() || entity.isSwimming() && (world.getBlockState(BlockPos.containing(x, y + 0.1, z))).getFluidState().isSource()) {
				fogRenderEvent.setNearPlaneDistance(0);
				fogRenderEvent.setFarPlaneDistance(35);
				if (!fogRenderEvent.isCanceled()) {
					fogRenderEvent.setCanceled(true);
				}
			} else {
				fogRenderEvent.setNearPlaneDistance(512);
				fogRenderEvent.setFarPlaneDistance(1024);
				if (!fogRenderEvent.isCanceled()) {
					fogRenderEvent.setCanceled(true);
				}
			}
		}
	}
}