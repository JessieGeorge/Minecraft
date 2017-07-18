package com.jes.Main;

import com.jes.lib.ReferenceStrings;
import com.jes.world.MWorld;
import com.jes.block.MBlocks;
import com.jes.creativeTabs.MCreativeTabs;
import com.jes.entity.MEntity;
import com.jes.item.MItems;
import com.jes.commands.Test;
import com.jes.commands.CommandConjure;
//FML = forge mod loader
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = ReferenceStrings.MODID, name = ReferenceStrings.NAME, version = ReferenceStrings.VERSION)
public class MainRegistry {
	
	@SidedProxy(clientSide = ReferenceStrings.CLIENTSIDE, serverSide = ReferenceStrings.SERVERSIDE )
	public static ServerProxy Sproxy;
	
	@Instance
	public static MainRegistry modInstance;
	
	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent)
	{
		MCreativeTabs.initializeCreativeTabs();
		MBlocks.mainRegistry();
		MEntity.mainRegistry();
		MItems.mainRegistry();
		MWorld.mainRegistry();
		CraftingManager.mainRegistry();
		Sproxy.registerRenderInfo();
	}
	
	@EventHandler
	public void serverload(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new Test());
		event.registerServerCommand(new CommandConjure());
	}
	
	@EventHandler
	public static void load(FMLInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent)
	{
		
	}
}
