package com.jes.Main;

import com.jes.entity.EntityGrenade;
import com.jes.entity.EntityMobster;
import com.jes.entity.EntityPiggy;
import com.jes.item.MItems;
import com.jes.model.mobster;
import com.jes.model.piggy;
import com.jes.render.RenderMobster;
import com.jes.render.RenderPiggy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class ClientProxy extends ServerProxy{
	public void registerRenderInfo(){
		RenderingRegistry.registerEntityRenderingHandler(EntityPiggy.class, new RenderPiggy(new piggy(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityMobster.class, new RenderMobster(new mobster(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGrenade.class, new RenderSnowball(MItems.Grenade));
	}

	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
