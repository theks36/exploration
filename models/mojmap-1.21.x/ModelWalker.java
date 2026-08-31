// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelWalker<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "walker"), "main");
	private final ModelPart Head;
	private final ModelPart Torso;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public ModelWalker(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Torso = root.getChild("Torso");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 19)
						.addBox(-6.0F, -8.75F, -6.0F, 12.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(60, 37)
						.addBox(-4.0F, 0.25F, -5.0F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -15.25F, -2.0F));

		PartDefinition Torso = partdefinition.addOrReplaceChild("Torso", CubeListBuilder.create(),
				PartPose.offset(0.0F, -4.25F, 0.0F));

		PartDefinition LowerTorso_r1 = Torso.addOrReplaceChild("LowerTorso_r1",
				CubeListBuilder.create().texOffs(42, 21).addBox(-4.0F, -5.0F, -3.0F, 8.0F, 10.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 5.25F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition UpperTorso_r1 = Torso.addOrReplaceChild("UpperTorso_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -5.5F, -4.0F, 14.0F, 11.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.25F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create(),
				PartPose.offset(-10.0F, -12.0558F, 0.6817F));

		PartDefinition LowerRightArm_r1 = RightArm.addOrReplaceChild("LowerRightArm_r1",
				CubeListBuilder.create().texOffs(68, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0558F, 0.3183F, -0.0873F, 0.0F, 0.0F));

		PartDefinition UpperRightArm_r1 = RightArm.addOrReplaceChild("UpperRightArm_r1",
				CubeListBuilder.create().texOffs(44, 0).addBox(-3.0F, -0.0341F, -2.7198F, 6.0F, 15.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.9442F, -0.6817F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(),
				PartPose.offset(10.0F, -12.0558F, 0.6817F));

		PartDefinition LowerLeftArm_r1 = LeftArm.addOrReplaceChild("LowerLeftArm_r1",
				CubeListBuilder.create().texOffs(68, 50).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 13.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 10.0558F, 0.3183F, -0.0873F, 0.0F, 0.0F));

		PartDefinition UpperLeftArm_r1 = LeftArm.addOrReplaceChild("UpperLeftArm_r1",
				CubeListBuilder.create().texOffs(0, 53).addBox(-3.0F, -0.0341F, -2.7198F, 6.0F, 15.0F, 6.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -3.9442F, -0.6817F, 0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(46, 53)
				.addBox(-2.5F, 5.8153F, -3.0043F, 5.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.5F, 5.1847F, -0.9957F));

		PartDefinition UpperRightLeg_r1 = RightLeg.addOrReplaceChild("UpperRightLeg_r1",
				CubeListBuilder.create().texOffs(30, 37).addBox(-3.5F, -4.0F, -4.0F, 7.0F, 8.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.6847F, 0.0043F, -0.1309F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(24, 53)
				.addBox(-2.5F, 5.8153F, -3.0043F, 5.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.5F, 5.1847F, -0.9957F));

		PartDefinition UpperLeftLeg_r1 = LeftLeg.addOrReplaceChild("UpperLeftLeg_r1",
				CubeListBuilder.create().texOffs(0, 37).addBox(-3.5F, -4.0F, -4.0F, 7.0F, 8.0F, 8.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 3.6847F, 0.0043F, -0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}