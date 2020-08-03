package io.github.minecraftsuggestions.theroofedcanyon.entity.chomproot;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class ChomprootEntityModel extends EntityModel<ChomprootEntity> {
    private final ModelPart chomproot;
    private final ModelPart torso;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;
    private final ModelPart leftArm;
    private final ModelPart rightArm;
    private final ModelPart tail;
    private final ModelPart fluff;
    private final ModelPart skull;
    private final ModelPart crown;
    private final ModelPart leaf1;
    private final ModelPart leaf2;
    private final ModelPart leaf3;
    private final ModelPart leaf4;

    public ChomprootEntityModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;

        chomproot = new ModelPart(this);
        chomproot.setPivot(0.0F, 24.0F, 0.0F);

        torso = new ModelPart(this);
        torso.setPivot(0.0F, 0.0F, 0.0F);
        torso.setTextureOffset(0, 52).addCuboid(-7.0F, -23.0F, -4.0F, 14.0F, 16.0F, 10.0F, 0.0F, false);
        torso.setTextureOffset(0, 28).addCuboid(-8.0F, -14.0F, -9.0F, 16.0F, 8.0F, 16.0F, 0.0F, false);
        torso.setTextureOffset(72, 25).addCuboid(-7.0F, -16.0F, -8.0F, 14.0F, 2.0F, 0.0F, 0.0F, false);
        chomproot.addChild(torso);

        leftLeg = new ModelPart(this);
        leftLeg.setPivot(-4.0F, -14.0F, 0.0F);
        leftLeg.setTextureOffset(86, 9).addCuboid(-3.0F, 8.0F, -4.0F, 6.0F, 6.0F, 8.0F, 0.0F, false);
        torso.addChild(leftLeg);

        rightLeg = new ModelPart(this);
        rightLeg.setPivot(4.0F, -14.0F, 0.0F);
        rightLeg.setTextureOffset(32, 82).addCuboid(-3.0F, 8.0F, -4.0F, 6.0F, 6.0F, 8.0F, 0.0F, false);
        torso.addChild(rightLeg);

        leftArm = new ModelPart(this);
        leftArm.setPivot(-8.0F, -11.0F, 0.0F);
        setRotationAngle(leftArm, 0.0F, 0.0F, 0.3491F);
        leftArm.setTextureOffset(80, 90).addCuboid(-2.0F, -1.0F, -3.0F, 4.0F, 10.0F, 6.0F, 0.0F, false);
        torso.addChild(leftArm);

        rightArm = new ModelPart(this);
        rightArm.setPivot(8.0F, -11.0F, 0.0F);
        setRotationAngle(rightArm, 0.0F, 0.0F, -0.3491F);
        rightArm.setTextureOffset(90, 58).addCuboid(-2.0F, -1.0F, -3.0F, 4.0F, 10.0F, 6.0F, 0.0F, false);
        torso.addChild(rightArm);

        tail = new ModelPart(this);
        tail.setPivot(0.0F, -7.0F, 6.5F);
        torso.addChild(tail);
        setRotationAngle(tail, -0.5236F, 0.0F, 0.0F);
        tail.setTextureOffset(73, 75).addCuboid(-4.0F, -4.0F, -1.5F, 8.0F, 8.0F, 7.0F, 0.0F, false);

        fluff = new ModelPart(this);
        fluff.setPivot(0.0F, -0.4019F, 5.8301F);
        setRotationAngle(fluff, 0.3491F, 0.0F, 0.0F);
        fluff.setTextureOffset(52, 88).addCuboid(-3.0F, -2.5F, -2.0F, 6.0F, 5.0F, 8.0F, 0.0F, false);
        tail.addChild(fluff);

        skull = new ModelPart(this);
        skull.setPivot(0.0F, -15.0F, 6.0F);
        setRotationAngle(skull, -0.3491F, 0.0F, 0.0F);
        skull.setTextureOffset(0, 0).addCuboid(-9.0F, -9.0F, -15.0F, 18.0F, 10.0F, 18.0F, 0.0F, false);
        skull.setTextureOffset(72, 23).addCuboid(-8.0F, 0.6494F, -13.8826F, 16.0F, 2.0F, 0.0F, 0.0F, false);
        chomproot.addChild(skull);

        crown = new ModelPart(this);
        crown.setPivot(0.0F, -8.5F, -5.0F);
        crown.setTextureOffset(54, 0).addCuboid(-5.0F, -4.5F, -5.0F, 10.0F, 7.0F, 10.0F, 0.0F, false);
        skull.addChild(crown);

        leaf1 = new ModelPart(this);
        leaf1.setPivot(0.0F, -4.9389F, 3.2352F);
        setRotationAngle(leaf1, 0.7854F, 0.3491F, 0.0F);
        leaf1.setTextureOffset(64, 30).addCuboid(0.0F, -1.0F, -1.0F, 0.0F, 18.0F, 16.0F, 0.0F, false);
        crown.addChild(leaf1);
        
        leaf2 = new ModelPart(this);
        leaf2.setPivot(0.0F, -4.9389F, 3.2352F);
        setRotationAngle(leaf2, 0.7854F, 0.8727F, 0.0F);
        leaf2.setTextureOffset(48, 48).addCuboid(0.0F, -1.0F, -1.0F, 0.0F, 18.0F, 16.0F, 0.0F, false);
        crown.addChild(leaf2);

        leaf3 = new ModelPart(this);
        leaf3.setPivot(0.0F, -4.9389F, 3.2352F);
        setRotationAngle(leaf3, 0.7854F, -0.3491F, 0.0F);
        leaf3.setTextureOffset(64, 12).addCuboid(0.0F, -1.0F, -1.0F, 0.0F, 18.0F, 16.0F, 0.0F, false);
        crown.addChild(leaf3);

        leaf4 = new ModelPart(this);
        leaf4.setPivot(0.0F, -4.9389F, 3.2352F);
        setRotationAngle(leaf4, 0.7854F, -0.8727F, 0.0F);
        leaf4.setTextureOffset(0, 80).addCuboid(0.0F, -1.0F, -1.0F, 0.0F, 18.0F, 16.0F, 0.0F, false);
        crown.addChild(leaf4);
    }

    @Override
    public void setAngles(ChomprootEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        // TODO: animations
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        chomproot.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelPart ModelPart, float x, float y, float z) {
        ModelPart.pivotX = x;
        ModelPart.pivotY = y;
        ModelPart.pivotZ = z;
    }
}
