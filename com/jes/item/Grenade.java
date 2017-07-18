package com.jes.item;

import com.jes.entity.EntityGrenade;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Grenade extends Item{

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){
	
		if(!player.capabilities.isCreativeMode)
		{
			--itemStack.stackSize;
		}
		
		world.playSoundAtEntity(player, "random.fizz", 0.7f, 0.8f);
		
		if(world.isRemote)
		{
			world.spawnEntityInWorld(new EntityGrenade(world, player));
		}
		
		return itemStack;
	}
}
