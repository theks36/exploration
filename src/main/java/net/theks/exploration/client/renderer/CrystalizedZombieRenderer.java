package net.theks.exploration.client.renderer;

import net.theks.exploration.entity.CrystalizedZombieEntity;
import net.theks.exploration.client.model.Modelplayer_zombie_pose;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CrystalizedZombieRenderer extends MobRenderer<CrystalizedZombieEntity, Modelplayer_zombie_pose<CrystalizedZombieEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("exploration:textures/entities/crystalizedzombie.png");

	public CrystalizedZombieRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelplayer_zombie_pose<CrystalizedZombieEntity>(context.bakeLayer(Modelplayer_zombie_pose.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<CrystalizedZombieEntity, Modelplayer_zombie_pose<CrystalizedZombieEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("exploration:textures/entities/crystalizedzombieoverlay.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CrystalizedZombieEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(CrystalizedZombieEntity entity) {
		if (entity.getTexture() != "crystalizedzombie")
			return ResourceLocation.parse("exploration:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}
}