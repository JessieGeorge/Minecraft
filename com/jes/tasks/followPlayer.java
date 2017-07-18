package com.jes.tasks;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import java.util.Timer;
import java.util.TimerTask;

import org.w3c.dom.Text;

import com.jes.entity.EntityPiggy;

//NOTE: The follow player code was adapted from Srihari's code

public class followPlayer extends EntityAIBase {
    int counter = 0;
    private EntityPiggy piggyAssistant;
    private EntityLivingBase theOwner;
    World theWorld;
    private double field_75336_f;
    private PathNavigate pathfinder;
    private int field_75343_h;
    float maxDist;
    float minDist;
    private boolean field_75344_i;
    //private static final String __OBFID = "CL_00001585";
    public followPlayer(EntityPiggy creature, float x, float y) {
    	piggyAssistant = creature;
        this.maxDist = x;
        this.minDist = y;
        this.setMutexBits(3);
        this.pathfinder = creature.getNavigator();
    }
    @Override
    public boolean shouldExecute() {

        try {


            EntityLivingBase creature = (EntityLivingBase)piggyAssistant.getOwner();


            
            //System.out.println("THE LIVING BASE IS" + creature.toString());
            if (creature == null) {
                return false;
            }

       /* else if (this.thePet.getDistanceSqToEntity(entitylivingbase) < (double)(this.minDist * this.minDist))
        {
            return false;
        } */
            else {
                this.theOwner = creature;
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
//thepath
    @Override
    public boolean continueExecuting() {
        return !this.pathfinder.noPath() && this.piggyAssistant.getDistanceSqToEntity(this.theOwner) > (double)(this.maxDist * this.maxDist);

    }

    @Override
    public boolean isInterruptible() {
        return false;
    }

    @Override
    public void startExecuting() {
    		
            this.field_75343_h = 0;
            this.field_75344_i = this.piggyAssistant.getNavigator().getAvoidsWater();
            this.piggyAssistant.getNavigator().setAvoidsWater(false);
            this.piggyAssistant.getNavigator().setCanSwim(true);
            this.piggyAssistant.getNavigator().setBreakDoors(true);
            
            EntityPlayer p = (EntityPlayer)theOwner;
            super.startExecuting();
    }

    @Override
    public void resetTask() {
        super.resetTask();
    }

    @Override
    public void updateTask() {
        this.piggyAssistant.getLookHelper().setLookPositionWithEntity(this.theOwner, 10.0F, (float)this.piggyAssistant.getVerticalFaceSpeed());

        counter ++;
        if(counter == 40){
            EntityPlayer player = (EntityPlayer)this.theOwner;

            player.addChatComponentMessage(new ChatComponentText("Villager: " + "Get some rsoruces"));
            counter = 0;
        }
        //chat every minute or s
//move to path
        if(this.theOwner != null) {
            this.piggyAssistant.getNavigator().tryMoveToEntityLiving(this.theOwner, 1);
        }
    }
    @Override
    public void setMutexBits(int p_75248_1_) {
        super.setMutexBits(p_75248_1_);
    }

    @Override
    public int getMutexBits() {
        return super.getMutexBits();
    }
    
}