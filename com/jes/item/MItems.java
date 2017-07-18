package com.jes.item;

import com.jes.Main.MainRegistry;
import com.jes.block.MBlocks;
import com.jes.creativeTabs.MCreativeTabs;
import com.jes.lib.ReferenceStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSeeds;
import net.minecraftforge.common.util.EnumHelper;

public class MItems {

	public static void mainRegistry()
	{
		initializeItem();
		registerItem();
	}
	
	public static ToolMaterial oShard = EnumHelper.addToolMaterial("Obsidian Shard", 3, 2000, 15.0f, 4.5f, 10);
	public static ArmorMaterial oArmor = EnumHelper.addArmorMaterial("My Armor", 33, new int[]{4, 8, 4, 4}, 10);
	
	
	public static Item obsidStick;
	
	
	//tools
	public static Item oPick;
	public static Item oAxe;
	public static Item oSpade;
	public static Item oSword;
	public static Item oHoe;
	
	public static Item oSeed;
	public static Item oShardItem;
	
	//armor
	public static Item oHelmet;
	public static Item oChest;
	public static Item oPants;
	public static Item oBoots;
	
	public static Item Grenade;
	
	public static void initializeItem()
	{
		//unlocalised names are allowed to change but registry names are not?
		
		//Items
		obsidStick = new Item().setUnlocalizedName("obsidStick").setCreativeTab(MCreativeTabs.tabItems).setTextureName(ReferenceStrings.MODID + ":obsidStick");
		oSeed = new ItemSeeds(MBlocks.oPlant, Blocks.dirt).setUnlocalizedName("oSeed").setCreativeTab(MCreativeTabs.tabItems).setTextureName(ReferenceStrings.MODID + ":oSeed");
		oShardItem = new Item().setUnlocalizedName("oShardItem").setCreativeTab(MCreativeTabs.tabItems).setTextureName(ReferenceStrings.MODID + ":oShardItem");
		
		//Tools
		oPick = new OPick(oShard).setUnlocalizedName("oPick").setCreativeTab(MCreativeTabs.tabTools).setTextureName(ReferenceStrings.MODID + ":oPick");
		oAxe = new OAxe(oShard).setUnlocalizedName("oAxe").setCreativeTab(MCreativeTabs.tabTools).setTextureName(ReferenceStrings.MODID + ":oAxe");
		oSpade = new OSpade(oShard).setUnlocalizedName("oSpade").setCreativeTab(MCreativeTabs.tabTools).setTextureName(ReferenceStrings.MODID + ":oSpade");
		oSword = new OSword(oShard).setUnlocalizedName("oSword").setCreativeTab(MCreativeTabs.tabTools).setTextureName(ReferenceStrings.MODID + ":oSword");
		oHoe = new OHoe(oShard).setUnlocalizedName("oHoe").setCreativeTab(MCreativeTabs.tabTools).setTextureName(ReferenceStrings.MODID + ":oHoe");
	
		//Armor
		oHelmet = new oArmor(oArmor, MainRegistry.Sproxy.addArmor("oArmor"),0).setUnlocalizedName("oHelmet").setCreativeTab(MCreativeTabs.tabTools).setTextureName(ReferenceStrings.MODID + ":oHelmet");
		oChest = new oArmor(oArmor, MainRegistry.Sproxy.addArmor("oArmor"),1).setUnlocalizedName("oChest").setCreativeTab(MCreativeTabs.tabTools).setTextureName(ReferenceStrings.MODID + ":oChest");
		oPants = new oArmor(oArmor, MainRegistry.Sproxy.addArmor("oArmor"),2).setUnlocalizedName("oPants").setCreativeTab(MCreativeTabs.tabTools).setTextureName(ReferenceStrings.MODID + ":oPants");
		oBoots = new oArmor(oArmor, MainRegistry.Sproxy.addArmor("oArmor"),3).setUnlocalizedName("oBoots").setCreativeTab(MCreativeTabs.tabTools).setTextureName(ReferenceStrings.MODID + ":oBoots");
	
		//ItemEntity
		Grenade = new Grenade().setUnlocalizedName("Grenade").setCreativeTab(MCreativeTabs.tabItems).setTextureName(ReferenceStrings.MODID + ":Grenade");
	}
	
	public static void registerItem()
	{
		GameRegistry.registerItem(obsidStick, obsidStick.getUnlocalizedName()); 
		GameRegistry.registerItem(oPick, oPick.getUnlocalizedName()); 
		GameRegistry.registerItem(oAxe, oAxe.getUnlocalizedName()); 
		GameRegistry.registerItem(oSpade, oSpade.getUnlocalizedName()); 
		GameRegistry.registerItem(oSword, oSword.getUnlocalizedName()); 
		GameRegistry.registerItem(oHoe, oHoe.getUnlocalizedName()); 
		
		GameRegistry.registerItem(oSeed, oSeed.getUnlocalizedName()); 
		GameRegistry.registerItem(oShardItem, oShardItem.getUnlocalizedName());
		
		GameRegistry.registerItem(oHelmet, oHelmet.getUnlocalizedName());
		GameRegistry.registerItem(oChest, oChest.getUnlocalizedName());
		GameRegistry.registerItem(oPants, oPants.getUnlocalizedName());
		GameRegistry.registerItem(oBoots, oBoots.getUnlocalizedName());
		
		GameRegistry.registerItem(Grenade, Grenade.getUnlocalizedName());
	}
	
	
}
