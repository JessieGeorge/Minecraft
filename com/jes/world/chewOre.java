package com.jes.world;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

import com.jes.block.MBlocks;

public class chewOre implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider ChunkGenerator, IChunkProvider ChunkProvider )
	{
		switch(world.provider.dimensionId)
		{
			case -1:
				generateNether(random, chunkX*16, chunkZ*16, world);
				break;
			case 0:
				generateOverWorld(random, chunkX*16, chunkZ*16, world);
				break;
			case 1:
				generateEnd(random, chunkX*16, chunkZ*16, world);
				break;
		}
	}

	private void addOre(Block block, Block blockspawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVein, int maxVein, int spawnChance)
	{
		for(int i=0; i<spawnChance; i++)
		{
			int defaultChunkSize = 16;
			int xPos = posX + random.nextInt(defaultChunkSize);
			int yPos = minY + random.nextInt(maxY - minY);
			int zPos = posZ + random.nextInt(defaultChunkSize);
			
			new WorldGenMinable(block, minVein+random.nextInt(maxVein-minVein), blockspawn).generate(world, random, xPos, yPos, zPos);
		}
	}
	
	private void generateEnd(Random random, int chunkX, int chunkZ, World world) {
		// TODO Auto-generated method stub
		
	}

	private void generateOverWorld(Random random, int chunkX, int chunkZ, World world) {
		// TODO Auto-generated method stub
		addOre(MBlocks.bluStone, Blocks.stone, random, world, chunkX, chunkZ, 5, 100, 10, 20, 80);
		
	}

	private void generateNether(Random random, int chunkX, int chunkZ, World world) {
		// TODO Auto-generated method stub
		
	}
}
