/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.theks.exploration.init;

import net.theks.exploration.client.model.Modelskeleton;
import net.theks.exploration.client.model.Modelplayer_zombie_pose;
import net.theks.exploration.client.model.ModelWalker;
import net.theks.exploration.client.model.ModelResinDroplet;
import net.theks.exploration.client.model.ModelFairy;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class ExplorationModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelplayer_zombie_pose.LAYER_LOCATION, Modelplayer_zombie_pose::createBodyLayer);
		event.registerLayerDefinition(ModelFairy.LAYER_LOCATION, ModelFairy::createBodyLayer);
		event.registerLayerDefinition(ModelResinDroplet.LAYER_LOCATION, ModelResinDroplet::createBodyLayer);
		event.registerLayerDefinition(ModelWalker.LAYER_LOCATION, ModelWalker::createBodyLayer);
		event.registerLayerDefinition(Modelskeleton.LAYER_LOCATION, Modelskeleton::createBodyLayer);
	}
}