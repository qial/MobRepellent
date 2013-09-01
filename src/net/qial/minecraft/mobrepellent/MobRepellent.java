package net.qial.minecraft.mobrepellent;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Base mod class for the MobRepellent2 mod (Minecraft Forge version)
 * 
 * @author qial
 */
@Mod(modid = "MobRepellent2", name = "MobRepellent2", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class MobRepellent {

    // Begin Basic Items
//    public final static Item genericItem = new GenericItem(5000);
//    public final static Item genericIngot = new GenericItem(5001)
//
//    .setMaxStackSize(16).setIconIndex(1).setItemName("specificItem");
    // End Basic Items

    // Begin Basic Blocks
//    public final static Block genericDirt = new GenericBlock(500, 0,
//            Material.ground).setHardness(0.5F)
//            .setStepSound(Block.soundGravelFootstep)
//            .setBlockName("genericDirt").setCreativeTab(CreativeTabs.tabBlock);
//    public final static Block genericOre = new GenericOre(501, 1);
    // End Basic Blocks
	
	public static final Block glassRepeller = new RepellerBlock(600, Material.glass)
			.setStepSound(Block.soundGlassFootstep)
			.setUnlocalizedName("glassRepeller");
	public static final Block ironRepeller = new RepellerBlock(601, Material.iron)
			.setStepSound(Block.soundMetalFootstep)
			.setUnlocalizedName("ironRepeller");
	public static final Block goldRepeller = new RepellerBlock(602, Material.iron)
			.setStepSound(Block.soundMetalFootstep)
			.setUnlocalizedName("goldRepeller");
	public static final Block diamondRepeller = new RepellerBlock(603, Material.iron)
			.setStepSound(Block.soundMetalFootstep)
			.setUnlocalizedName("diamondRepeller");
	public static final Block emeraldRepeller = new RepellerBlock(604, Material.iron)
			.setStepSound(Block.soundMetalFootstep)
			.setUnlocalizedName("emeraldRepeller");

    // Begin Damage Values and Metadata
//    public static final int multiBlockId = 502;
//    public static final Block multiBlock = new MultiBlock(multiBlockId);

//    private static final String[] multiBlockNames = { "White Block",
//            "Orange Block", "Magenta Block", "Light Blue Block",
//            "Yellow Block", "Light Green Block", "Pink Block",
//            "Dark Grey Block", "Light Grey Block", "Cyan Block",
//            "Purple Block", "Blue Block", "Brown Block", "Green Block",
//            "Red Block", "Black Block" };
    // End Damage Values and Metadata

    // Begin Packet Handling
//    public static final Block randomBlock = new RandomBlock(503, 2);
    // End Packet Handling

    // Begin Plant
//    public static final Block tomatoCrop = new TomatoCrop(504);
//    public static final ItemSeeds tomatoSeeds = (ItemSeeds) new ItemSeeds(5002,
//            tomatoCrop.blockID, Block.tilledField.blockID).setIconIndex(2)
//            .setTextureFile(CommonProxy.ITEMS_PNG);
//    public static final Item tomatoFruit = new GenericItem(5003)
//            .setIconIndex(3);
    // End Plant

    // The instance of your mod that Forge uses.
    @Instance("MobRepellent2")
    public static MobRepellent instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide = "net.qial.minecraft.mobrepellent.client.ClientProxy", serverSide = "net.qial.minecraft.mobrepellent.CommonProxy")
    public static CommonProxy proxy;
    
    private MobRepellerList repellers;

    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        // Stub Method
    	// set up our list and things
    	repellers = new MobRepellerList();
    }

    @EventHandler
    public void load (FMLInitializationEvent event) {
        proxy.registerRenderers();

        initCraftingAndSmelting();
        initBasicItems();
        initBasicBlocks();
        initDamageValuesAndMetadata();
        initPacketHandling();
        initPlants();
        initWorldGen();
        initSpawnHandlers();
    }

    @EventHandler
    public void postInit (FMLPostInitializationEvent event) {
        // Stub Method
    }
    
    private void initSpawnHandlers() {
    	MinecraftForge.EVENT_BUS.register(new SpawnHandler());
    }

    private void initCraftingAndSmelting () {
//        ItemStack dirtStack = new ItemStack(Block.dirt);
//        ItemStack diamondsStack = new ItemStack(Item.diamond, 64);
//        ItemStack blackWoolStack = new ItemStack(Block.cloth, 42, 15);
//        ItemStack gravelStack = new ItemStack(Block.gravel);
//        ItemStack cobbleStack = new ItemStack(Block.cobblestone);
    	// set up item stacks for repeller crafting
    	ItemStack glassStack = new ItemStack(Block.glass);
    	ItemStack ironStack = new ItemStack(Block.blockIron);
    	ItemStack goldStack = new ItemStack(Block.blockGold);
    	ItemStack diamondStack = new ItemStack(Block.blockDiamond);
    	ItemStack emeraldStack = new ItemStack(Block.blockEmerald);
    	
    	// set up reverse stacks for shapeless crafting
    	ItemStack glassStack7 = new ItemStack(Block.glass,7);
    	ItemStack ironStack7 = new ItemStack(Block.blockIron,7);
    	ItemStack goldStack7 = new ItemStack(Block.blockGold,7);
    	ItemStack diamondStack7 = new ItemStack(Block.blockDiamond,7);
    	ItemStack emeraldStack7 = new ItemStack(Block.blockEmerald,7);
    	
//        GameRegistry.addShapelessRecipe(diamondsStack, dirtStack);
//
//        GameRegistry.addShapelessRecipe(diamondsStack, dirtStack, dirtStack,
//                dirtStack, dirtStack, dirtStack, dirtStack, new ItemStack(
//                        Block.sand), gravelStack, cobbleStack);
//
//        GameRegistry.addRecipe(new ItemStack(Block.cobblestone), "xy", "yx",
//                'x', dirtStack, 'y', gravelStack);
//
//        GameRegistry.addRecipe(new ItemStack(Block.stone), "xyx", "y y", "xyx",
//                'x', dirtStack, 'y', gravelStack);
//
//        GameRegistry.addSmelting(Block.stone.blockID, new ItemStack(
//                Block.stoneBrick), 0.1f);
//
//        FurnaceRecipes.smelting().addSmelting(Block.cloth.blockID, 15,
//                new ItemStack(Item.bed), 0.1f);
    	
    	// add repeller crafting
    	GameRegistry.addRecipe(new ItemStack(glassRepeller), " x ", "xxx", "xxx", 'x', glassStack);
    	GameRegistry.addRecipe(new ItemStack(ironRepeller), " x ", "xxx", "xxx", 'x', ironStack);
    	GameRegistry.addRecipe(new ItemStack(goldRepeller), " x ", "xxx", "xxx", 'x', goldStack);
    	GameRegistry.addRecipe(new ItemStack(diamondRepeller), " x ", "xxx", "xxx", 'x', diamondStack);
    	GameRegistry.addRecipe(new ItemStack(emeraldRepeller), " x ", "xxx", "xxx", 'x', emeraldStack);
    	
    	GameRegistry.addShapelessRecipe(glassStack7, glassRepeller);
    	GameRegistry.addShapelessRecipe(ironStack7, ironRepeller);
    	GameRegistry.addShapelessRecipe(goldStack7, goldRepeller);
    	GameRegistry.addShapelessRecipe(diamondStack7, diamondRepeller);
    	GameRegistry.addShapelessRecipe(emeraldStack7, emeraldRepeller);
    }

    private void initBasicItems () {
//        LanguageRegistry.addName(genericItem, "Generic Item");
//        LanguageRegistry.addName(genericIngot, "Specific Item");
    	
    }

    private void initBasicBlocks () {
    	
    	GameRegistry.registerBlock(glassRepeller, "glassRepeller");
    	LanguageRegistry.addName(glassRepeller, "Glass Mob Repeller");
    	MinecraftForge.setBlockHarvestLevel(glassRepeller, "pickaxe", 1);
    	
    	GameRegistry.registerBlock(ironRepeller, "ironRepeller");
    	LanguageRegistry.addName(ironRepeller, "Iron Mob Repeller");
    	MinecraftForge.setBlockHarvestLevel(ironRepeller, "pickaxe", 1);
    	
    	GameRegistry.registerBlock(goldRepeller, "goldRepeller");
    	LanguageRegistry.addName(goldRepeller, "Gold Mob Repeller");
    	MinecraftForge.setBlockHarvestLevel(goldRepeller, "pickaxe", 1);
    	
    	GameRegistry.registerBlock(diamondRepeller, "diamondRepeller");
    	LanguageRegistry.addName(diamondRepeller, "Diamond Mob Repeller");
    	MinecraftForge.setBlockHarvestLevel(diamondRepeller, "pickaxe", 1);
    	
    	GameRegistry.registerBlock(emeraldRepeller, "emeraldRepeller");
    	LanguageRegistry.addName(emeraldRepeller, "Emerald Mob Repeller");
    	MinecraftForge.setBlockHarvestLevel(emeraldRepeller, "pickaxe", 1);
    	
    }

    private void initDamageValuesAndMetadata () {
//        GameRegistry.registerBlock(multiBlock, MultiItemBlock.class);
//
//        for (int ix = 0; ix < 16; ix++) {
//            ItemStack cloth = new ItemStack(Block.cloth, 1, ix);
//            ItemStack multiBlockStack = new ItemStack(multiBlock, 1, ix);
//
//            GameRegistry.addShapelessRecipe(multiBlockStack, cloth, cloth);
//            LanguageRegistry.addName(multiBlockStack,
//                    multiBlockNames[multiBlockStack.getItemDamage()]);
//        }
    }

    private void initPacketHandling () {
//        GameRegistry.registerBlock(randomBlock, "randomBlock");
//        LanguageRegistry.addName(randomBlock, "Random Block");
    }

    private void initPlants () {
//        LanguageRegistry.addName(tomatoSeeds, "Tomato Seeds");
//        MinecraftForge.addGrassSeed(new ItemStack(tomatoSeeds), 10);
//
//        LanguageRegistry.addName(tomatoFruit, "Tomato");
//        GameRegistry.addShapelessRecipe(new ItemStack(tomatoSeeds, 4),
//                new ItemStack(tomatoFruit));
//
//        GameRegistry.registerBlock(tomatoCrop, "tomatoCrop");
    }
    
    private void initWorldGen () {
//        GameRegistry.registerWorldGenerator(new BasicWorldGen());
    }
}
