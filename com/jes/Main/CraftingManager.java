package com.jes.Main;

import com.jes.block.MBlocks;
import com.jes.item.MItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingManager {

	public static void mainRegistry()
	{
		addCraftingRec();
		addSmeltingRec();
	}
	public static void addCraftingRec()
	{
		
		//shaped recipes     
		//output type and number ... pattern per row, letter used in pattern, define type
		GameRegistry.addRecipe(new ItemStack(MBlocks.bluStone,1), new Object[]{"XXX","XAX","XXX", 'X', Blocks.lapis_block, 'A', Items.apple});
		GameRegistry.addRecipe(new ItemStack(MItems.obsidStick, 1), new Object[]{" X "," X ", 'X', Blocks.redstone_block});
		
		//shapeless recipe
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond_sword, 1), new Object[]{Items.pumpkin_seeds, Blocks.dirt});
	}
	public static void addSmeltingRec()
	{
		//smelting recipe - what you put in the furnace, what you get out, what amount of experience the player should get from smelting?
		GameRegistry.addSmelting(Blocks.coal_block, new ItemStack(Blocks.obsidian,3), 0.5f);
	}
}
