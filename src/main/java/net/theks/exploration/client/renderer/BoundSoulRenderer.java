package net.theks.exploration.client.renderer;

import net.theks.exploration.entity.BoundSoulEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.animation.definitions.BreezeAnimation;

public class BoundSoulRenderer extends HumanoidMobRenderer<BoundSoulEntity, HumanoidModel<BoundSoulEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("exploration:textures/entities/boundsoul.png");

	public BoundSoulRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(BoundSoulEntity entity) {
		if (entity.getTexture() != "boundsoul")
			return ResourceLocation.parse("exploration:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}

	@Override
	protected boolean isShaking(BoundSoulEntity entity) {
		return true;
	}

	private static final class AnimatedModel extends HumanoidModel<BoundSoulEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BoundSoulEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BoundSoulEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.animateWalk(BreezeAnimation.SLIDE, limbSwing, limbSwingAmount, 0f, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(BoundSoulEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}