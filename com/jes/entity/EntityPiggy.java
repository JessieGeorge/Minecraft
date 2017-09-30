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

import com.jes.tasks.followPlayer;

import net.minecraft.entity.IEntityOwnable;
import net.java.games.input.Event;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Timer;
import org.apache.http.util.EntityUtils;
import org.lwjgl.Sys;
import java.util.TimerTask;
import java.util.UUID;

public class EntityPiggy extends EntityAnimal implements IEntityOwnable{

	String ownerid;
	
	public EntityPiggy(World p_i1738_1_) {
		super(p_i1738_1_);
		//creature and speed
		this.setSize(1.0F, 1.0F);
		
		//this.tasks.addTask(0, new followPlayer(this, 100, 100)); //NOTE: The follow player code was adapted from Srihari's code 
		
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
	
	//set Owner?
	@Override
	    public String func_152113_b() {
	    if(ownerid != null){
	        return ownerid;
	    }
	        return "err";
	    }
	
	@Override
    public EntityPlayer getOwner() {
        try{
            UUID x = UUID.fromString(this.func_152113_b());
            if(x != null){
                return  this.worldObj.func_152378_a(x);
            }

            return null;
        } catch (Exception e){

            e.printStackTrace();
        }
        
        ChatComponentText text = new ChatComponentText("Hello World");
        return null;
    }
	
	protected void applyEntityAttribute()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0d);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3d);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100D);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(1.0D);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return new EntityPiggy(worldObj);
	}
	
}
