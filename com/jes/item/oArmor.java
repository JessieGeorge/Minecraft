package com.jes.item;

import com.jes.lib.ReferenceStrings;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class oArmor extends ItemArmor {

	public oArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
		if(stack.getItem().equals(MItems.oHelmet)||stack.getItem().equals(MItems.oChest)||stack.getItem().equals(MItems.oBoots))
		{
			return ReferenceStrings.MODID + ":textures/armor/oArmor1.png";
		}
		else if(stack.getItem().equals(MItems.oPants))
		{
			return ReferenceStrings.MODID + ":textures/armor/oArmor2.png";
		}
		else
		{
			return null;
		}
    }
}
