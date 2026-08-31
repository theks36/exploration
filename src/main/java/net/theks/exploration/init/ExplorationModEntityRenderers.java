/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.theks.exploration.client.renderer.*;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class ExplorationModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ExplorationModEntities.RESIN_DROPLET.get(), ResinDropletRenderer::new);
		event.registerEntityRenderer(ExplorationModEntities.HUSH_PUPPY.get(), HushPuppyRenderer::new);
		event.registerEntityRenderer(ExplorationModEntities.BOUND_SOUL.get(), BoundSoulRenderer::new);
		event.registerEntityRenderer(ExplorationModEntities.MAMA_SPIDER.get(), MamaSpiderRenderer::new);
		event.registerEntityRenderer(ExplorationModEntities.CRYSTALIZED_ZOMBIE.get(), CrystalizedZombieRenderer::new);
		event.registerEntityRenderer(ExplorationModEntities.JACKO.get(), JackoRenderer::new);
		event.registerEntityRenderer(ExplorationModEntities.WALKER.get(), WalkerRenderer::new);
		event.registerEntityRenderer(ExplorationModEntities.FAIRY.get(), FairyRenderer::new);
	}
}