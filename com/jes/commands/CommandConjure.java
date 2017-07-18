package com.jes.commands;

import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
//import 

public class CommandConjure implements ICommand{
//COMMAND TO CONJURE A MONSTER
	protected String fullEntityName;
	protected Entity conjuredEntity;
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "conjure";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO Auto-generated method stub
		return "conjure <text>";
	}

	@Override
	public List getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] argString) {
		// TODO Auto-generated method stub
		World world = sender.getEntityWorld();
		
		if(world.isRemote)
		{
			System.out.println("Not processing on Client side");
		}
		
		else
		{
			System.out.println("Processing on Server side");
			if(argString.length == 0)
			{
				sender.addChatMessage(new ChatComponentText("Invalid argument"));
				return;
			}
			
			sender.addChatMessage(new ChatComponentText("Conjuring ["+argString[0]+"]"));
			fullEntityName = argString[0];
			if (EntityList.stringToClassMapping.containsKey(fullEntityName))
            { 
                conjuredEntity = EntityList.createEntityByName(fullEntityName, world);  
                conjuredEntity.setPosition(sender.getPlayerCoordinates().posX,       
                sender.getPlayerCoordinates().posY, 
                sender.getPlayerCoordinates().posZ); 
                world.spawnEntityInWorld(conjuredEntity); 
            } 
            else 
            { 
                sender.addChatMessage(new ChatComponentText("Entity not found")); 
            } 
			
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
