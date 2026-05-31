package net.theks.exploration.client.renderer;

import net.theks.exploration.entity.MamaSpiderEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.SpiderModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class MamaSpiderRenderer extends MobRenderer<MamaSpiderEntity, SpiderModel<MamaSpiderEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("exploration:textures/entities/mamaspider.png");

	public MamaSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new SpiderModel<MamaSpiderEntity>(context.bakeLayer(ModelLayers.SPIDER)), 0.5f);
		this.addLayer(new RenderLayer<MamaSpiderEntity, SpiderModel<MamaSpiderEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("exploration:textures/entities/mamaspidereyes.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MamaSpiderEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	protected void scale(MamaSpiderEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(1.5f, 1.5f, 1.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MamaSpiderEntity entity) {
		if (entity.getTexture() != "mamaspider")
			return ResourceLocation.parse("exploration:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}