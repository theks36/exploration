package net.theks.exploration.client.renderer;

import net.theks.exploration.procedures.HasTargetProcedure;
import net.theks.exploration.entity.WalkerEntity;
import net.theks.exploration.client.model.ModelWalker;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class WalkerRenderer extends MobRenderer<WalkerEntity, ModelWalker<WalkerEntity>> {
	private final ResourceLocation entityTexture = ResourceLocation.parse("exploration:textures/entities/walker.png");

	public WalkerRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelWalker<WalkerEntity>(context.bakeLayer(ModelWalker.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(WalkerEntity entity) {
		if (entity.getTexture() != "walker")
			return ResourceLocation.parse("exploration:textures/entities/" + entity.getTexture() + ".png");
		return entityTexture;
	}

	@Override
	protected boolean isShaking(WalkerEntity entity) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return HasTargetProcedure.execute(entity);
	}
}