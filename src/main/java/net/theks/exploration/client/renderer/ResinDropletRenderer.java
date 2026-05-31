package net.theks.exploration.client.renderer;

import net.theks.exploration.entity.ResinDropletEntity;
import net.theks.exploration.client.model.animations.ResinDropletAnimation;
import net.theks.exploration.client.model.ModelResinDroplet;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

public class ResinDropletRenderer extends MobRenderer<ResinDropletEntity, ModelResinDroplet<ResinDropletEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("exploration:textures/entities/resindroplet.png");

	public ResinDropletRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelResinDroplet.LAYER_LOCATION)), 0.25f);
	}

	@Override
	public ResourceLocation getTextureLocation(ResinDropletEntity entity) {
		if (entity.getTexture() != "resindroplet")
			return ResourceLocation.parse("exploration:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}

	private static final class AnimatedModel extends ModelResinDroplet<ResinDropletEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<ResinDropletEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(ResinDropletEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, ResinDropletAnimation.Hit, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(ResinDropletEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}