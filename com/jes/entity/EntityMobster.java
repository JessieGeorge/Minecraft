package com.jes.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
//import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityMobster extends EntityAnimal{

	public EntityMobster(World p_i1738_1_) {
		super(p_i1738_1_);
		//creature and speed
		this.setSize(0.9F, 1.9F);
		this.tasks.addTask(0, new EntityAIWander(this, 0.3D));
		this.tasks.addTask(1, new EntityAIPanic(this, 0.8D));
		this.tasks.addTask(2, new EntityAILookIdle(this));
		this.tasks.addTask(3, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAITempt(this, 1.9D, Items.coal, false));
		
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}
	
	protected void applyEntityAttribute()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0d);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3d);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return new EntityMobster(worldObj);
	}

}
