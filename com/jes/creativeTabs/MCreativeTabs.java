package com.jes.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;

public class MCreativeTabs {

	public static CreativeTabs tabBlocks;
	public static CreativeTabs tabItems;
	public static CreativeTabs tabTools;
	
	public static void initializeCreativeTabs()
	{
		tabBlocks = new CreativeTabBlock("BlockTab");
		tabItems = new CreativeTabItem("ItemTab");
		tabTools = new CreativeTabTool("ToolTab");
		
	}
	
	
}
