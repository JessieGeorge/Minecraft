package com.jes.block;

import com.jes.creativeTabs.MCreativeTabs;
import com.jes.lib.ReferenceStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MBlocks {

	public static void mainRegistry()
	{
		initializeBlock();
		registerBlock();
	}
	
	public static Block bluStone;
	public static Block oPlant;
	
	public static void initializeBlock()
	{
		bluStone = new bluStone(Material.ground).setBlockName("bluStone").setCreativeTab(MCreativeTabs.tabBlocks).setBlockTextureName(ReferenceStrings.MODID + ":bluStone");
		oPlant = new obsidianCrop().setBlockName("oPlant").setCreativeTab(MCreativeTabs.tabBlocks).setBlockTextureName(ReferenceStrings.MODID + ":oPlant");
	}
	
	public static void registerBlock()
	{
		GameRegistry.registerBlock(bluStone, bluStone.getUnlocalizedName()); 
		GameRegistry.registerBlock(oPlant, oPlant.getUnlocalizedName()); 
	}

}
