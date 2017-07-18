package com.jes.entity;

import com.jes.Main.MainRegistry;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;

public class MEntity {
	
	public static void mainRegistry()
	{
		registerEntity();
	}
	
	public static void registerEntity()
	{
		//hex values are the color of egg
		createEntity(EntityPiggy.class, "Piggy Assistant", 0x8733FF, 0x001EFF);
		createEntity(EntityMobster.class, "Mobster", 0xEC4545, 0x001EFF);
		createEntity(EntityGrenade.class, "Grenade", 0x008521, 0x00FF0800);
	}
	
	//solid and spot colors for the spawn egg
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor)
	{
		int randomID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomID);
		EntityRegistry.registerModEntity(entityClass, entityName, randomID, MainRegistry.modInstance, 80, 1, true);
		
		createEgg(randomID, solidColor, spotColor);
	}
	
	private static void createEgg(int randomID, int solidColor, int spotColor)
	{
		EntityList.entityEggs.put(Integer.valueOf(randomID), new EntityList.EntityEggInfo(randomID, solidColor, spotColor));
		
	}

}
