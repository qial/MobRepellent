package net.qial.minecraft.mobrepellent;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class RepellerBlock extends Block {

	public RepellerBlock(int blockId, Material material) {
		super(blockId, material);
		setCreativeTab(CreativeTabs.tabMisc);
	}

}
