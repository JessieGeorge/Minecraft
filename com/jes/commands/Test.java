package com.jes.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class Test extends CommandBase{
	
	@Override
	public String getCommandName()
	{
		return "test";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "Displays a test message";
	}
	
	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring)
	{
	
		if(icommandsender instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)icommandsender;
			
			player.addChatMessage(new ChatComponentText("Hello Jessie"));
		}
	}
}
