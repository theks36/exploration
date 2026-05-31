package net.theks.exploration.client.renderer;

import net.theks.exploration.entity.HushPuppyEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.PigModel;

import com.mojang.blaze3d.vertex.PoseStack;

public class HushPuppyRenderer extends MobRenderer<HushPuppyEntity, PigModel<HushPuppyEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("exploration:textures/entities/hushpuppyt.png");

	public HushPuppyRenderer(EntityRendererProvider.Context context) {
		super(context, new PigModel<HushPuppyEntity>(context.bakeLayer(ModelLayers.PIG)), 0.5f);
	}

	@Override
	protected void scale(HushPuppyEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2f, 2f, 2f);
	}

	@Override
	public ResourceLocation getTextureLocation(HushPuppyEntity entity) {
		if (entity.getTexture() != "hushpuppyt")
			return ResourceLocation.parse("exploration:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}