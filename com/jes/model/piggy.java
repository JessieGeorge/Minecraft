package com.jes.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class piggy extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer RFrontLeg;
    ModelRenderer RBackLeg;
    ModelRenderer LFrontLeg;
    ModelRenderer LBackLeg;
    ModelRenderer Head;
    ModelRenderer Snout;
  
  public piggy()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 15, 9);
      Body.addBox(0F, 0F, 0F, 10, 8, 14);
      Body.setRotationPoint(0F, 0F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      RFrontLeg = new ModelRenderer(this, 35, 0);
      RFrontLeg.addBox(0F, 0F, 0F, 4, 7, 3);
      RFrontLeg.setRotationPoint(0F, 6F, 1F);
      RFrontLeg.setTextureSize(64, 32);
      RFrontLeg.mirror = true;
      setRotation(RFrontLeg, 0F, 0F, 0F);
      RBackLeg = new ModelRenderer(this, 50, 0);
      RBackLeg.addBox(0F, 0F, 0F, 4, 7, 3);
      RBackLeg.setRotationPoint(0F, 6F, 12F);
      RBackLeg.setTextureSize(64, 32);
      RBackLeg.mirror = true;
      setRotation(RBackLeg, 0F, 0F, 0F);
      LFrontLeg = new ModelRenderer(this, 35, 12);
      LFrontLeg.addBox(0F, 0F, 0F, 4, 7, 3);
      LFrontLeg.setRotationPoint(6F, 6F, 1F);
      LFrontLeg.setTextureSize(64, 32);
      LFrontLeg.mirror = true;
      setRotation(LFrontLeg, 0F, 0F, 0F);
      LBackLeg = new ModelRenderer(this, 50, 12);
      LBackLeg.addBox(0F, 0F, 0F, 4, 7, 3);
      LBackLeg.setRotationPoint(6F, 6F, 12F);
      LBackLeg.setTextureSize(64, 32);
      LBackLeg.mirror = true;
      setRotation(LBackLeg, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(0F, 0F, 0F, 8, 8, 8);
      Head.setRotationPoint(1F, -2F, -6F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Snout = new ModelRenderer(this, 0, 18);
      Snout.addBox(0F, 0F, 0F, 4, 3, 2);
      Snout.setRotationPoint(3F, 2F, -7F);
      Snout.setTextureSize(64, 32);
      Snout.mirror = true;
      setRotation(Snout, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    RFrontLeg.render(f5);
    RBackLeg.render(f5);
    LFrontLeg.render(f5);
    LBackLeg.render(f5);
    Head.render(f5);
    Snout.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
