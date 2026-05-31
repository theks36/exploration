package net.theks.exploration.client.renderer;

import net.theks.exploration.entity.JackoEntity;
import net.theks.exploration.client.model.Modelskeleton;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class JackoRenderer extends MobRenderer<JackoEntity, Modelskeleton<JackoEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("exploration:textures/entities/jacko.png");

	public JackoRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelskeleton<JackoEntity>(context.bakeLayer(Modelskeleton.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(JackoEntity entity) {
		if (entity.getTexture() != "jacko")
			return ResourceLocation.parse("exploration:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}