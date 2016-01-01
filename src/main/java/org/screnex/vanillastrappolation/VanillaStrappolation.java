package org.screnex.vanillastrappolation;

import org.screnex.blazedcore.BlazedAxe;
import org.screnex.blazedcore.BlazedBlock;
import org.screnex.blazedcore.BlazedBoots;
import org.screnex.blazedcore.BlazedChestplate;
import org.screnex.blazedcore.BlazedCore;
import org.screnex.blazedcore.BlazedGenerator;
import org.screnex.blazedcore.BlazedHelmet;
import org.screnex.blazedcore.BlazedHoe;
import org.screnex.blazedcore.BlazedItem;
import org.screnex.blazedcore.BlazedKatana;
import org.screnex.blazedcore.BlazedLeggings;
import org.screnex.blazedcore.BlazedOre;
import org.screnex.blazedcore.BlazedPickaxe;
import org.screnex.blazedcore.BlazedSpade;
import org.screnex.blazedcore.BlazedSword;
import org.screnex.blazedcore.BlazedTab;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid="VanillaStrappolation", name="VanillaStrappolation", version=VanillaStrappolation.version)
public class VanillaStrappolation {
	protected static final String version = "1.0b1";
	@Mod.Instance(value="VanillaStrappolation")
	public static VanillaStrappolation instance;
	
	/*
	 * public static Block oreCuprite, oreCassiterite, oreCopper, oreTin, oreUranium, orePolonium;
	 * public static Block oreIndium, oreLead, oreIridium, oreOsmium, oreCadmium, oreRenium, oreThorium;
	 * public static Block oreBauxite, oreAluminium, oreTitanium, oreGalena, oreTungstate, orePyrope;
	 * public static Block oreTetrahedrite, oreRuby, oreSapphire, oreNickel, oreCobalt, oreCinnabar;
	 * public static Block orePyrite, oreCeldonite, oreSodalite, oreOlivenite, oreSphalerite;
	 * public static Block oreRedSphalerite, oreRedTetrahedrite, oreRedCinnabar, graniteRed;
	 * public static Block oreBlackTungstate, oreBlackCeldonite, oreBlackIridium, graniteBlack;
	 * public static Block orePhosphorite, oreAndradide, oreAlmandine, oreGrossular, oreCalcite;
	 * public static Block oreSpessartine, oreUvarovite, oreSilver, oreSaltpeter, oreSulfur, oreTopaz;
	 * public static Block orePalladium, oreRuthenium, oreRhodium, orePlatinum, oreCobaltite, oreTantalite;
	*/
	
	public static Item gemFlint, gemRuby, gemSapphire, gemPeridotite, gemTopaz;
	public static Item rodFrost, rodRuby, rodSapphire, rodPeridotite, rodTopaz;
	public static Item powderFrost, powderRuby, powderSapphire, powderPeridotite, powderTopaz;
	public static Item ingotCopper, ingotTin, ingotBronze, ingotNickel, ingotCobalt, ingotTitanium;
	public static Item chunkCopper, chunkTin, chunkNickel, chunkCobalt, chunkTitanium;
	
	public static Block andesite, diorite, endstone_brick, granite, andesite_smooth, diorite_smooth, granite_smooth;
	public static Block dioriteCobalt, dioriteNickel, andesiteTopaz, graniteTin, gravelFlint, gravelTitanium;
	public static Block obsidianTopaz, netherrackTin, netherrackTitanium, netherrackTopaz, netherrackCopper;
	public static Block endstoneRuby, endstonePeridotite, endstoneSapphire, endstoneTin, andesiteCopper;
	public static Block graniteCopper, stoneTin, stonePeridotite, stoneRuby, stoneSapphire;
	
	public static Item pick_flint, pick_copper, pick_bronze, pick_iron, pick_nickel, pick_cobalt, pick_ruby, 
	pick_sapphire, pick_peridotite, pick_topaz, pick_emerald, pick_diamond, pick_obsidian, pick_titanium;
	public static Item axe_flint, axe_copper, axe_bronze, axe_iron, axe_nickel, axe_cobalt, axe_ruby, 
	axe_sapphire, axe_peridotite, axe_topaz, axe_emerald, axe_diamond, axe_obsidian, axe_titanium;
	public static Item sword_flint, sword_copper, sword_bronze, sword_iron, sword_nickel, sword_cobalt, sword_ruby, 
	sword_sapphire, sword_peridotite, sword_topaz, sword_emerald, sword_diamond, sword_obsidian, sword_titanium, sword_blazediamond;
	public static Item hoe_flint, hoe_copper, hoe_bronze, hoe_iron, hoe_nickel, hoe_cobalt, hoe_ruby, 
	hoe_sapphire, hoe_peridotite, hoe_topaz, hoe_emerald, hoe_diamond, hoe_obsidian, hoe_titanium;
	public static Item shovel_flint, shovel_copper, shovel_bronze, shovel_iron, shovel_nickel, shovel_cobalt, shovel_ruby, 
	shovel_sapphire, shovel_peridotite, shovel_topaz, shovel_emerald, shovel_diamond, shovel_obsidian, shovel_titanium;
	
	public static Item helmet_tin, helmet_bronze, helmet_iron, helmet_emerald, helmet_diamond, helmet_obsidian, helmet_titanium;
	public static Item chestplate_tin, chestplate_bronze, chestplate_iron, chestplate_emerald, chestplate_diamond, chestplate_obsidian, chestplate_titanium;
	public static Item leggings_tin, leggings_bronze, leggings_iron, leggings_emerald, leggings_diamond, leggings_obsidian, leggings_titanium;
	public static Item boots_tin, boots_bronze, boots_iron, boots_emerald, boots_diamond, boots_obsidian, boots_titanium;
	
	public static BlazedTab tabVanillastrappTools, tabVanillastrappMaterials, tabVanillastrappBlocks, tabVanillastrappCombat;
	public static BlazedGenerator endIslands, dioriteVeins, andesiteVeins, graniteVeins, endObsidianIslands,
	dioriteCoGen, dioriteNiGen, andesiteTopazGen, graniteSnGen, gravelFlintGen, gravelTiGen, obsidianTopazGen, netherSnGen,
	netherTiGen, netherTopazGen, netherCuGen, endRubyGen, endPeridotiteGen, endSapphireGen, endSnGen, andesiteCuGen,
	graniteCuGen, stoneSnGen, stonePeridotiteGen, stoneRubyGen, stoneSapphireGen, islandTopazGen;
	
	public static final ToolMaterial flintTools = EnumHelper.addToolMaterial("VSFLINT", 1, 105, 4.5F, 1.5F, 8);
	public static final ToolMaterial copperTools = EnumHelper.addToolMaterial("COPPER", 1, 190, 5F, 1.75F, 12);
	public static final ToolMaterial bronzeTools = EnumHelper.addToolMaterial("BRONZE", 2, 230, 5.5F, 2F, 14);
	public static final ToolMaterial ironTools = EnumHelper.addToolMaterial("VSIRON", 2, 270, 6F, 2F, 13);
	public static final ToolMaterial nickelTools = EnumHelper.addToolMaterial("NICKEL", 2, 460, 8F, 2.5F, 16);
	public static final ToolMaterial cobaltTools = EnumHelper.addToolMaterial("COBALT", 2, 510, 7F, 2.5F, 16);
	public static final ToolMaterial rubyTools = EnumHelper.addToolMaterial("RUBY", 2, 550, 8F, 3F, 11);
	public static final ToolMaterial sapphireTools = EnumHelper.addToolMaterial("SAPPHIRE", 2, 650, 8.5F, 3F, 10);
	public static final ToolMaterial peridotiteTools = EnumHelper.addToolMaterial("PERIDOTITE", 2, 660, 8F, 2.75F, 13);
	public static final ToolMaterial topazTools = EnumHelper.addToolMaterial("TOPAZ", 3, 720, 7.5F, 3F, 9);
	public static final ToolMaterial emeraldTools = EnumHelper.addToolMaterial("VSEMERALD", 3, 1000, 11F, 3.5F, 17);
	public static final ToolMaterial diamondTools = EnumHelper.addToolMaterial("VSDIAMOND", 4, 1450, 9F, 4F, 10);
	public static final ToolMaterial obsidianTools = EnumHelper.addToolMaterial("VSOBSIDIAN", 5, 1780, 6F, 5F, 6);
	public static final ToolMaterial titaniumTools = EnumHelper.addToolMaterial("TITANIUM", 6, 2200, 13.5F, 6F, 21);
	public static final ToolMaterial blazediamondSwordMaterial = EnumHelper.addToolMaterial("BLAZEDIAMONDSWORD", 4, 3750, 9F, 8F, 0);
	
	public static final ArmorMaterial tinArmor = EnumHelper.addArmorMaterial("TIN", 7, new int[]{2,4,3,1}, 13);
	public static final ArmorMaterial bronzeArmor = EnumHelper.addArmorMaterial("BRONZE", 11, new int[]{2,5,4,2}, 10);
	public static final ArmorMaterial ironArmor = EnumHelper.addArmorMaterial("IRON", 15, new int[]{2,6,5,2}, 9);
	public static final ArmorMaterial emeraldArmor = EnumHelper.addArmorMaterial("EMERALD", 21, new int[]{3,7,5,3}, 19);
	public static final ArmorMaterial diamondArmor = EnumHelper.addArmorMaterial("DIAMOND", 31, new int[]{4,7,6,3}, 10);
	public static final ArmorMaterial obsidianArmor = EnumHelper.addArmorMaterial("OBSIDIAN", 46, new int[]{4,9,7,4}, 5);
	public static final ArmorMaterial titaniumArmor = EnumHelper.addArmorMaterial("TITANIUM", 54, new int[]{5,10,8,5}, 22);
	
	@Mod.EventHandler
	public void preLoad(FMLPreInitializationEvent event) {
		Blocks.obsidian.setHardness(22F);
		Blocks.obsidian.setHarvestLevel("pickaxe", 4);
		Blocks.diamond_ore.setHarvestLevel("pickaxe", 3);
		Blocks.diamond_block.setHarvestLevel("pickaxe", 3);
		
		tabVanillastrappTools = new BlazedTab("vanillastrapp_tools");
		tabVanillastrappMaterials = new BlazedTab("vanillastrapp_materials");
		tabVanillastrappBlocks = new BlazedTab("vanillastrapp_blocks");
		tabVanillastrappCombat = new BlazedTab("vanillastrapp_combat");
		
		gemFlint = new BlazedItem("flint_gem", "vanillastrapp:gem_flint", tabVanillastrappMaterials, "flint_gem");
		gemRuby = new BlazedItem("ruby_gem", "vanillastrapp:gem_ruby", tabVanillastrappMaterials, "ruby_gem");
		gemSapphire = new BlazedItem("sapphire_gem", "vanillastrapp:gem_sapphire", tabVanillastrappMaterials, "sapphire_gem");
		gemPeridotite = new BlazedItem("peridotite_gem", "vanillastrapp:gem_peridotite", tabVanillastrappMaterials, "peridotite_gem");
		gemTopaz = new BlazedItem("topaz_gem", "vanillastrapp:gem_topaz", tabVanillastrappMaterials, "topaz_gem");
		ingotCopper = new BlazedItem("copper_ingot", "vanillastrapp:ingot_copper", tabVanillastrappMaterials, "copper_ingot");
		ingotTin = new BlazedItem("tin_ingot", "vanillastrapp:ingot_tin", tabVanillastrappMaterials, "tin_ingot");
		ingotBronze = new BlazedItem("bronze_ingot", "vanillastrapp:ingot_bronze", tabVanillastrappMaterials, "bronze_ingot");
		ingotTitanium = new BlazedItem("titanium_ingot", "vanillastrapp:ingot_titanium", tabVanillastrappMaterials, EnumRarity.uncommon, "titanium_ingot");
		ingotCobalt = new BlazedItem("cobalt_ingot", "vanillastrapp:ingot_cobalt", tabVanillastrappMaterials, "cobalt_ingot");
		ingotNickel = new BlazedItem("nickel_ingot", "vanillastrapp:ingot_nickel", tabVanillastrappMaterials, "nickel_ingot");
		
		chunkCopper = new BlazedItem("copper_chunk", "vanillastrapp:chunk_copper", tabVanillastrappMaterials, "copper_chunk");
		chunkTin = new BlazedItem("tin_chunk", "vanillastrapp:chunk_tin", tabVanillastrappMaterials, "tin_chunk");
		chunkTitanium = new BlazedItem("titanium_chunk", "vanillastrapp:chunk_titanium", tabVanillastrappMaterials, EnumRarity.uncommon, "titanium_chunk");
		chunkCobalt = new BlazedItem("cobalt_chunk", "vanillastrapp:chunk_cobalt", tabVanillastrappMaterials, "cobalt_chunk");
		chunkNickel = new BlazedItem("nickel_chunk", "vanillastrapp:chunk_nickel", tabVanillastrappMaterials, "nickel_chunk");
		
		powderFrost = new BlazedItem("frost_powder", "vanillastrapp:powder_frost", tabVanillastrappMaterials, EnumRarity.uncommon, "frost_powder");
		powderRuby = new BlazedItem("ruby_powder", "vanillastrapp:powder_ruby", tabVanillastrappMaterials, "ruby_powder");
		powderTopaz = new BlazedItem("topaz_powder", "vanillastrapp:powder_topaz", tabVanillastrappMaterials, "topaz_powder");
		powderSapphire = new BlazedItem("sapphire_powder", "vanillastrapp:powder_sapphire", tabVanillastrappMaterials, "sapphire_powder");
		powderPeridotite = new BlazedItem("peridotite_powder", "vanillastrapp:powder_peridotite", tabVanillastrappMaterials, "peridotite_powder");
		
		rodFrost = new BlazedItem("frost_rod", "vanillastrapp:rod_frost", tabVanillastrappMaterials, EnumRarity.uncommon, "frost_rod");
		rodRuby = new BlazedItem("ruby_rod", "vanillastrapp:rod_ruby", tabVanillastrappMaterials, "ruby_rod");
		rodTopaz = new BlazedItem("topaz_rod", "vanillastrapp:rod_topaz", tabVanillastrappMaterials, "topaz_rod");
		rodSapphire = new BlazedItem("sapphire_rod", "vanillastrapp:rod_sapphire", tabVanillastrappMaterials, "sapphire_rod");
		rodPeridotite = new BlazedItem("peridotite_rod", "vanillastrapp:rod_peridotite", tabVanillastrappMaterials, "peridotite_rod");
		
		andesite = new BlazedBlock(Material.rock, "andesite", "vanillastrapp:andesite", 3F, 12F, 0F, "pickaxe", 1, tabVanillastrappBlocks, "andesite");
		diorite = new BlazedBlock(Material.rock, "diorite", "vanillastrapp:diorite", 3F, 12F, 0F, "pickaxe", 1, tabVanillastrappBlocks, "diorite");
		granite = new BlazedBlock(Material.rock, "granite", "vanillastrapp:granite", 3F, 12F, 0F, "pickaxe", 1, tabVanillastrappBlocks, "granite");
		andesite_smooth = new BlazedBlock(Material.rock, "andesite_smooth", "vanillastrapp:andesite_smooth", 3.5F, 14F, 0F, "pickaxe", 1, tabVanillastrappBlocks, "andesite_smooth");
		diorite_smooth = new BlazedBlock(Material.rock, "diorite_smooth", "vanillastrapp:diorite_smooth", 3.5F, 14F, 0F, "pickaxe", 1, tabVanillastrappBlocks, "diorite_smooth");
		granite_smooth = new BlazedBlock(Material.rock, "granite_smooth", "vanillastrapp:granite_smooth", 3.5F, 14F, 0F, "pickaxe", 1, tabVanillastrappBlocks, "granite_smooth");
		endstone_brick = new BlazedBlock(Material.rock, "endstone_brick", "vanillastrapp:endstone_bricks", 12F, 20F, 0F, "pickaxe", 2, tabVanillastrappBlocks, "endstone_brick");
		
		dioriteCobalt = new BlazedOre(Material.rock, "cobalt_ore", "vanillastrapp:cobalt_diorite", tabVanillastrappBlocks, "pickaxe", 2, 6F, chunkCobalt, "cobalt_diorite");
		dioriteNickel = new BlazedOre(Material.rock, "nickel_ore", "vanillastrapp:nickel_diorite", tabVanillastrappBlocks, "pickaxe", 2, 6F, chunkNickel, "nickel_diorite");
		andesiteTopaz = new BlazedOre(Material.rock, "topaz_ore", "vanillastrapp:topaz_andesite", tabVanillastrappBlocks, "pickaxe", 2, 5.75F, gemTopaz, "topaz_andesite");
		graniteCopper = new BlazedOre(Material.rock, "copper_ore", "vanillastrapp:copper_granite", tabVanillastrappBlocks, "pickaxe", 1, 2.8F, chunkCopper, "copper_granite");
		andesiteCopper = new BlazedOre(Material.rock, "copper_ore", "vanillastrapp:copper_andesite", tabVanillastrappBlocks, "pickaxe", 1, 2.8F, chunkCopper, "copper_andesite");
		graniteTin = new BlazedOre(Material.rock, "tin_ore", "vanillastrapp:tin_granite", tabVanillastrappBlocks, "pickaxe", 1, 3F, chunkTin, 2, "tin_granite");
		obsidianTopaz = new BlazedOre(Material.rock, "topaz_ore", "vanillastrapp:topaz_obsidian", tabVanillastrappBlocks, "pickaxe", 3, 24F, gemTopaz, 3, "topaz_obsidian");
		gravelTitanium = new BlazedOre(Material.iron, "titanium_ore", "vanillastrapp:titanium_gravel", tabVanillastrappBlocks, "shovel", 5, 13F, chunkTitanium, 2, "gravel_titanium");
		gravelFlint = new BlazedOre(Material.sand, "flint_ore", "vanillastrapp:flint_gravel", tabVanillastrappBlocks, "shovel", 0, 2F, gemFlint, "gravel_flint");
		stoneTin = new BlazedOre(Material.rock, "tin_ore", "vanillastrapp:tin_stone", tabVanillastrappBlocks, "pickaxe", 0, 1.6F, chunkTin, "stone_tin");
		stoneRuby = new BlazedOre(Material.rock, "ruby_ore", "vanillastrapp:ruby_stone", tabVanillastrappBlocks, "pickaxe", 2, 5.75F, gemRuby, "stone_ruby");
		stoneSapphire = new BlazedOre(Material.rock, "sapphire_ore", "vanillastrapp:sapphire_stone", tabVanillastrappBlocks, "pickaxe", 2, 5.75F, gemSapphire, "stone_sapphire");
		stonePeridotite = new BlazedOre(Material.rock, "peridotite_ore", "vanillastrapp:peridotite_stone", tabVanillastrappBlocks, "pickaxe", 2, 5.75F, gemPeridotite, "stone_peridotite");
		netherrackCopper = new BlazedOre(Material.rock, "copper_ore", "vanillastrapp:copper_netherrack", tabVanillastrappBlocks, "pickaxe", 1, 2.5F, chunkCopper, 3, "netherrack_copper");
		netherrackTin = new BlazedOre(Material.rock, "tin_ore", "vanillastrapp:tin_netherrack", tabVanillastrappBlocks, "pickaxe", 1, 1.8F, chunkTin, 3, "netherrack_tin");
		netherrackTitanium = new BlazedOre(Material.rock, "titanium_ore", "vanillastrapp:titanium_netherrack", tabVanillastrappBlocks, "pickaxe", 5, 11F, chunkTitanium, "netherrack_titanium");
		netherrackTopaz = new BlazedOre(Material.rock, "topaz_ore", "vanillastrapp:topaz_netherrack", tabVanillastrappBlocks, "pickaxe", 2, 5.75F, gemTopaz, 2, "netherrack_topaz");
		endstoneTin = new BlazedOre(Material.rock, "tin_ore", "vanillastrapp:tin_endstone", tabVanillastrappBlocks, "pickaxe", 2, 3F, chunkTin, 4, "endstone_tin");
		endstoneRuby = new BlazedOre(Material.rock, "ruby_ore", "vanillastrapp:ruby_endstone", tabVanillastrappBlocks, "pickaxe", 2, 5.75F, gemRuby, 3, "endstone_ruby");
		endstoneSapphire = new BlazedOre(Material.rock, "sapphire_ore", "vanillastrapp:sapphire_endstone", tabVanillastrappBlocks, "pickaxe", 2, 5.75F, gemSapphire, 3, "endstone_sapphire");
		endstonePeridotite = new BlazedOre(Material.rock, "peridotite_ore", "vanillastrapp:peridotite_endstone", tabVanillastrappBlocks, "pickaxe", 2, 5.75F, gemPeridotite, 3, "endstone_peridotite");
		
		pick_flint = new BlazedPickaxe(flintTools, "flint_pickaxe", "vanillastrapp:flint_pickaxe", tabVanillastrappTools, "flint_pickaxe");
		pick_copper = new BlazedPickaxe(copperTools, "copper_pickaxe", "vanillastrapp:copper_pickaxe", tabVanillastrappTools, "copper_pickaxe");
		pick_bronze = new BlazedPickaxe(bronzeTools, "bronze_pickaxe", "vanillastrapp:bronze_pickaxe", tabVanillastrappTools, "bronze_pickaxe");
		pick_iron = new BlazedPickaxe(ironTools, "iron_pickaxe", "vanillastrapp:iron_pickaxe", tabVanillastrappTools, "iron_pickaxe");
		pick_nickel = new BlazedPickaxe(nickelTools, "nickel_pickaxe", "vanillastrapp:nickel_pickaxe", tabVanillastrappTools, "nickel_pickaxe");
		pick_cobalt = new BlazedPickaxe(cobaltTools, "cobalt_pickaxe", "vanillastrapp:cobalt_pickaxe", tabVanillastrappTools, "cobalt_pickaxe");
		pick_ruby = new BlazedPickaxe(rubyTools, "ruby_pickaxe", "vanillastrapp:ruby_pickaxe", tabVanillastrappTools, "ruby_pickaxe");
		pick_sapphire = new BlazedPickaxe(sapphireTools, "sapphire_pickaxe", "vanillastrapp:sapphire_pickaxe", tabVanillastrappTools, "sapphire_pickaxe");
		pick_peridotite = new BlazedPickaxe(peridotiteTools, "peridotite_pickaxe", "vanillastrapp:peridotite_pickaxe", tabVanillastrappTools, "peridotite_pickaxe");
		pick_topaz = new BlazedPickaxe(topazTools, "topaz_pickaxe", "vanillastrapp:topaz_pickaxe", tabVanillastrappTools, "topaz_pickaxe");
		pick_emerald = new BlazedPickaxe(emeraldTools, "emerald_pickaxe", "vanillastrapp:emerald_pickaxe", tabVanillastrappTools, "emerald_pickaxe");
		pick_diamond = new BlazedPickaxe(diamondTools, "diamond_pickaxe", "vanillastrapp:diamond_pickaxe", tabVanillastrappTools, "diamond_pickaxe");
		pick_obsidian = new BlazedPickaxe(obsidianTools, "obsidian_pickaxe", "vanillastrapp:obsidian_pickaxe", tabVanillastrappTools, "obsidian_pickaxe");
		pick_titanium = new BlazedPickaxe(titaniumTools, "titanium_pickaxe", "vanillastrapp:titanium_pickaxe", tabVanillastrappTools, "titanium_pickaxe");
		axe_flint = new BlazedAxe(flintTools, "flint_axe", "vanillastrapp:flint_axe", tabVanillastrappTools, "flint_axe");
		axe_copper = new BlazedAxe(copperTools, "copper_axe", "vanillastrapp:copper_axe", tabVanillastrappTools, "copper_axe");
		axe_bronze = new BlazedAxe(bronzeTools, "bronze_axe", "vanillastrapp:bronze_axe", tabVanillastrappTools, "bronze_axe");
		axe_iron = new BlazedAxe(ironTools, "iron_axe", "vanillastrapp:iron_axe", tabVanillastrappTools, "iron_axe");
		axe_nickel = new BlazedAxe(nickelTools, "nickel_axe", "vanillastrapp:nickel_axe", tabVanillastrappTools, "nickel_axe");
		axe_cobalt = new BlazedAxe(cobaltTools, "cobalt_axe", "vanillastrapp:cobalt_axe", tabVanillastrappTools, "cobalt_axe");
		axe_ruby = new BlazedAxe(rubyTools, "ruby_axe", "vanillastrapp:ruby_axe", tabVanillastrappTools, "ruby_axe");
		axe_sapphire = new BlazedAxe(sapphireTools, "sapphire_axe", "vanillastrapp:sapphire_axe", tabVanillastrappTools, "sapphire_axe");
		axe_peridotite = new BlazedAxe(peridotiteTools, "peridotite_axe", "vanillastrapp:peridotite_axe", tabVanillastrappTools, "peridotite_axe");
		axe_topaz = new BlazedAxe(topazTools, "topaz_axe", "vanillastrapp:topaz_axe", tabVanillastrappTools, "topaz_axe");
		axe_emerald = new BlazedAxe(emeraldTools, "emerald_axe", "vanillastrapp:emerald_axe", tabVanillastrappTools, "emerald_axe");
		axe_diamond = new BlazedAxe(diamondTools, "diamond_axe", "vanillastrapp:diamond_axe", tabVanillastrappTools, "diamond_axe");
		axe_obsidian = new BlazedAxe(obsidianTools, "obsidian_axe", "vanillastrapp:obsidian_axe", tabVanillastrappTools, "obsidian_axe");
		axe_titanium = new BlazedAxe(titaniumTools, "titanium_axe", "vanillastrapp:titanium_axe", tabVanillastrappTools, "titanium_axe");
		sword_flint = new BlazedSword(flintTools, "flint_sword", "vanillastrapp:flint_sword", tabVanillastrappCombat, "flint_sword");
		sword_copper = new BlazedSword(copperTools, "copper_sword", "vanillastrapp:copper_sword", tabVanillastrappCombat, "copper_sword");
		sword_bronze = new BlazedSword(bronzeTools, "bronze_sword", "vanillastrapp:bronze_sword", tabVanillastrappCombat, "bronze_sword");
		sword_iron = new BlazedSword(ironTools, "iron_sword", "vanillastrapp:iron_sword", tabVanillastrappCombat, "iron_sword");
		sword_nickel = new BlazedSword(nickelTools, "nickel_sword", "vanillastrapp:nickel_sword", tabVanillastrappCombat, "nickel_sword");
		sword_cobalt = new BlazedSword(cobaltTools, "cobalt_sword", "vanillastrapp:cobalt_sword", tabVanillastrappCombat, "cobalt_sword");
		sword_ruby = new BlazedSword(rubyTools, "ruby_sword", "vanillastrapp:ruby_sword", tabVanillastrappCombat, "ruby_sword");
		sword_sapphire = new BlazedSword(sapphireTools, "sapphire_sword", "vanillastrapp:sapphire_sword", tabVanillastrappCombat, "sapphire_sword");
		sword_peridotite = new BlazedSword(peridotiteTools, "peridotite_sword", "vanillastrapp:peridotite_sword", tabVanillastrappCombat, "peridotite_sword");
		sword_topaz = new BlazedSword(topazTools, "topaz_sword", "vanillastrapp:topaz_sword", tabVanillastrappCombat, "topaz_sword");
		sword_emerald = new BlazedSword(emeraldTools, "emerald_sword", "vanillastrapp:emerald_sword", tabVanillastrappCombat, "emerald_sword");
		sword_diamond = new BlazedSword(diamondTools, "diamond_sword", "vanillastrapp:diamond_sword", tabVanillastrappCombat, "diamond_sword");
		sword_obsidian = new BlazedSword(obsidianTools, "obsidian_sword", "vanillastrapp:obsidian_sword", tabVanillastrappCombat, "obsidian_sword");
		sword_titanium = new BlazedSword(titaniumTools, "titanium_sword", "vanillastrapp:titanium_sword", tabVanillastrappCombat, "titanium_sword");
		sword_blazediamond = new BlazeDiamondSword();
		shovel_flint = new BlazedSpade(flintTools, "flint_shovel", "vanillastrapp:flint_shovel", tabVanillastrappTools, "flint_shovel");
		shovel_copper = new BlazedSpade(copperTools, "copper_shovel", "vanillastrapp:copper_shovel", tabVanillastrappTools, "copper_shovel");
		shovel_bronze = new BlazedSpade(bronzeTools, "bronze_shovel", "vanillastrapp:bronze_shovel", tabVanillastrappTools, "bronze_shovel");
		shovel_iron = new BlazedSpade(ironTools, "iron_shovel", "vanillastrapp:iron_shovel", tabVanillastrappTools, "iron_shovel");
		shovel_nickel = new BlazedSpade(nickelTools, "nickel_shovel", "vanillastrapp:nickel_shovel", tabVanillastrappTools, "nickel_shovel");
		shovel_cobalt = new BlazedSpade(cobaltTools, "cobalt_shovel", "vanillastrapp:cobalt_shovel", tabVanillastrappTools, "cobalt_shovel");
		shovel_ruby = new BlazedSpade(rubyTools, "ruby_shovel", "vanillastrapp:ruby_shovel", tabVanillastrappTools, "ruby_shovel");
		shovel_sapphire = new BlazedSpade(sapphireTools, "sapphire_shovel", "vanillastrapp:sapphire_shovel", tabVanillastrappTools, "sapphire_shovel");
		shovel_peridotite = new BlazedSpade(peridotiteTools, "peridotite_shovel", "vanillastrapp:peridotite_shovel", tabVanillastrappTools, "peridotite_shovel");
		shovel_topaz = new BlazedSpade(topazTools, "topaz_shovel", "vanillastrapp:topaz_shovel", tabVanillastrappTools, "topaz_shovel");
		shovel_emerald = new BlazedSpade(emeraldTools, "emerald_shovel", "vanillastrapp:emerald_shovel", tabVanillastrappTools, "emerald_shovel");
		shovel_diamond = new BlazedSpade(diamondTools, "diamond_shovel", "vanillastrapp:diamond_shovel", tabVanillastrappTools, "diamond_shovel");
		shovel_obsidian = new BlazedSpade(obsidianTools, "obsidian_shovel", "vanillastrapp:obsidian_shovel", tabVanillastrappTools, "obsidian_shovel");
		shovel_titanium = new BlazedSpade(titaniumTools, "titanium_shovel", "vanillastrapp:titanium_shovel", tabVanillastrappTools, "titanium_shovel");
		hoe_flint = new BlazedHoe(flintTools, "flint_hoe", "vanillastrapp:flint_hoe", tabVanillastrappTools, "flint_hoe");
		hoe_copper = new BlazedHoe(copperTools, "copper_hoe", "vanillastrapp:copper_hoe", tabVanillastrappTools, "copper_hoe");
		hoe_bronze = new BlazedHoe(bronzeTools, "bronze_hoe", "vanillastrapp:bronze_hoe", tabVanillastrappTools, "bronze_hoe");
		hoe_iron = new BlazedHoe(ironTools, "iron_hoe", "vanillastrapp:iron_hoe", tabVanillastrappTools, "iron_hoe");
		hoe_nickel = new BlazedHoe(nickelTools, "nickel_hoe", "vanillastrapp:nickel_hoe", tabVanillastrappTools, "nickel_hoe");
		hoe_cobalt = new BlazedHoe(cobaltTools, "cobalt_hoe", "vanillastrapp:cobalt_hoe", tabVanillastrappTools, "cobalt_hoe");
		hoe_ruby = new BlazedHoe(rubyTools, "ruby_hoe", "vanillastrapp:ruby_hoe", tabVanillastrappTools, "ruby_hoe");
		hoe_sapphire = new BlazedHoe(sapphireTools, "sapphire_hoe", "vanillastrapp:sapphire_hoe", tabVanillastrappTools, "sapphire_hoe");
		hoe_peridotite = new BlazedHoe(peridotiteTools, "peridotite_hoe", "vanillastrapp:peridotite_hoe", tabVanillastrappTools, "peridotite_hoe");
		hoe_topaz = new BlazedHoe(topazTools, "topaz_hoe", "vanillastrapp:topaz_hoe", tabVanillastrappTools, "topaz_hoe");
		hoe_emerald = new BlazedHoe(emeraldTools, "emerald_hoe", "vanillastrapp:emerald_hoe", tabVanillastrappTools, "emerald_hoe");
		hoe_diamond = new BlazedHoe(diamondTools, "diamond_hoe", "vanillastrapp:diamond_hoe", tabVanillastrappTools, "diamond_hoe");
		hoe_obsidian = new BlazedHoe(obsidianTools, "obsidian_hoe", "vanillastrapp:obsidian_hoe", tabVanillastrappTools, "obsidian_hoe");
		hoe_titanium = new BlazedHoe(titaniumTools, "titanium_hoe", "vanillastrapp:titanium_hoe", tabVanillastrappTools, "titanium_hoe");
		
		helmet_tin = new BlazedHelmet(tinArmor, "tin_helmet", "vanillastrapp:tin_helmet", "vanillastrapp:textures/armor/tin_layer_1.png", tabVanillastrappCombat, "tin_helmet");
		helmet_bronze = new BlazedHelmet(bronzeArmor, "bronze_helmet", "vanillastrapp:bronze_helmet", "vanillastrapp:textures/armor/bronze_layer_1.png", tabVanillastrappCombat, "bronze_helmet");
		helmet_iron = new BlazedHelmet(ironArmor, "iron_helmet", "vanillastrapp:iron_helmet", "vanillastrapp:textures/armor/iron_layer_1.png", tabVanillastrappCombat, "iron_helmet");
		helmet_emerald = new BlazedHelmet(emeraldArmor, "emerald_helmet", "vanillastrapp:emerald_helmet", "vanillastrapp:textures/armor/emerald_layer_1.png", tabVanillastrappCombat, "emerald_helmet");
		helmet_diamond = new BlazedHelmet(diamondArmor, "diamond_helmet", "vanillastrapp:diamond_helmet", "vanillastrapp:textures/armor/diamond_layer_1.png", tabVanillastrappCombat, "diamond_helmet");
		helmet_obsidian = new BlazedHelmet(obsidianArmor, "obsidian_helmet", "vanillastrapp:obsidian_helmet", "vanillastrapp:textures/armor/obsidian_layer_1.png", tabVanillastrappCombat, "obsidian_helmet");
		helmet_titanium = new BlazedHelmet(titaniumArmor, "titanium_helmet", "vanillastrapp:titanium_helmet", "vanillastrapp:textures/armor/titanium_layer_1.png", tabVanillastrappCombat, "titanium_helmet");
		chestplate_tin = new BlazedChestplate(tinArmor, "tin_chestplate", "vanillastrapp:tin_chestplate", "vanillastrapp:textures/armor/tin_layer_1.png", tabVanillastrappCombat, "tin_chestplate");
		chestplate_bronze = new BlazedChestplate(bronzeArmor, "bronze_chestplate", "vanillastrapp:bronze_chestplate", "vanillastrapp:textures/armor/bronze_layer_1.png", tabVanillastrappCombat, "bronze_chestplate");
		chestplate_iron = new BlazedChestplate(ironArmor, "iron_chestplate", "vanillastrapp:iron_chestplate", "vanillastrapp:textures/armor/iron_layer_1.png", tabVanillastrappCombat, "iron_chestplate");
		chestplate_emerald = new BlazedChestplate(emeraldArmor, "emerald_chestplate", "vanillastrapp:emerald_chestplate", "vanillastrapp:textures/armor/emerald_layer_1.png", tabVanillastrappCombat, "emerald_chestplate");
		chestplate_diamond = new BlazedChestplate(diamondArmor, "diamond_chestplate", "vanillastrapp:diamond_chestplate", "vanillastrapp:textures/armor/diamond_layer_1.png", tabVanillastrappCombat, "diamond_chestplate");
		chestplate_obsidian = new BlazedChestplate(obsidianArmor, "obsidian_chestplate", "vanillastrapp:obsidian_chestplate", "vanillastrapp:textures/armor/obsidian_layer_1.png",tabVanillastrappCombat,"obsidian_chestplate");
		chestplate_titanium = new BlazedChestplate(titaniumArmor, "titanium_chestplate", "vanillastrapp:titanium_chestplate", "vanillastrapp:textures/armor/titanium_layer_1.png",tabVanillastrappCombat,"titanium_chestplate");
		leggings_tin = new BlazedLeggings(tinArmor, "tin_leggings", "vanillastrapp:tin_leggings", "vanillastrapp:textures/armor/tin_layer_2.png", tabVanillastrappCombat, "tin_leggings");
		leggings_bronze = new BlazedLeggings(bronzeArmor, "bronze_leggings", "vanillastrapp:bronze_leggings", "vanillastrapp:textures/armor/bronze_layer_2.png", tabVanillastrappCombat, "bronze_leggings");
		leggings_iron = new BlazedLeggings(ironArmor, "iron_leggings", "vanillastrapp:iron_leggings", "vanillastrapp:textures/armor/iron_layer_2.png", tabVanillastrappCombat, "iron_leggings");
		leggings_emerald = new BlazedLeggings(emeraldArmor, "emerald_leggings", "vanillastrapp:emerald_leggings", "vanillastrapp:textures/armor/emerald_layer_2.png", tabVanillastrappCombat, "emerald_leggings");
		leggings_diamond = new BlazedLeggings(diamondArmor, "diamond_leggings", "vanillastrapp:diamond_leggings", "vanillastrapp:textures/armor/diamond_layer_2.png", tabVanillastrappCombat, "diamond_leggings");
		leggings_obsidian = new BlazedLeggings(obsidianArmor, "obsidian_leggings", "vanillastrapp:obsidian_leggings", "vanillastrapp:textures/armor/obsidian_layer_2.png", tabVanillastrappCombat, "obsidian_leggings");
		leggings_titanium = new BlazedLeggings(titaniumArmor, "titanium_leggings", "vanillastrapp:titanium_leggings", "vanillastrapp:textures/armor/titanium_layer_2.png", tabVanillastrappCombat, "titanium_leggings");
		boots_tin = new BlazedBoots(tinArmor, "tin_boots", "vanillastrapp:tin_boots", "vanillastrapp:textures/armor/tin_layer_1.png", tabVanillastrappCombat, "tin_boots");
		boots_bronze = new BlazedBoots(bronzeArmor, "bronze_boots", "vanillastrapp:bronze_boots", "vanillastrapp:textures/armor/bronze_layer_1.png", tabVanillastrappCombat, "bronze_boots");
		boots_iron = new BlazedBoots(ironArmor, "iron_boots", "vanillastrapp:iron_boots", "vanillastrapp:textures/armor/iron_layer_1.png", tabVanillastrappCombat, "iron_boots");
		boots_emerald = new BlazedBoots(emeraldArmor, "emerald_boots", "vanillastrapp:emerald_boots", "vanillastrapp:textures/armor/emerald_layer_1.png", tabVanillastrappCombat, "emerald_boots");
		boots_diamond = new BlazedBoots(diamondArmor, "diamond_boots", "vanillastrapp:diamond_boots", "vanillastrapp:textures/armor/diamond_layer_1.png", tabVanillastrappCombat, "diamond_boots");
		boots_obsidian = new BlazedBoots(obsidianArmor, "obsidian_boots", "vanillastrapp:obsidian_boots", "vanillastrapp:textures/armor/obsidian_layer_1.png", tabVanillastrappCombat, "obsidian_boots");
		boots_titanium = new BlazedBoots(titaniumArmor, "titanium_boots", "vanillastrapp:titanium_boots", "vanillastrapp:textures/armor/titanium_layer_1.png", tabVanillastrappCombat, "titanium_boots");

		tabVanillastrappTools.init(new ItemStack(pick_ruby));
		tabVanillastrappMaterials.init(new ItemStack(gemSapphire));
		tabVanillastrappBlocks.init(new ItemStack(endstone_brick));
		tabVanillastrappCombat.init(new ItemStack(sword_blazediamond));
		
		/*BlazedCore.removeRecipe(new ItemStack(Items.wooden_axe));
		BlazedCore.removeRecipe(new ItemStack(Items.wooden_pickaxe));
		BlazedCore.removeRecipe(new ItemStack(Items.wooden_sword));
		BlazedCore.removeRecipe(new ItemStack(Items.wooden_shovel));
		BlazedCore.removeRecipe(new ItemStack(Items.wooden_hoe));
		BlazedCore.removeRecipe(new ItemStack(Items.stone_axe));
		BlazedCore.removeRecipe(new ItemStack(Items.stone_pickaxe));
		BlazedCore.removeRecipe(new ItemStack(Items.stone_sword));
		BlazedCore.removeRecipe(new ItemStack(Items.stone_shovel));
		BlazedCore.removeRecipe(new ItemStack(Items.stone_hoe));
		BlazedCore.removeRecipe(new ItemStack(Items.iron_axe));
		BlazedCore.removeRecipe(new ItemStack(Items.iron_pickaxe));
		BlazedCore.removeRecipe(new ItemStack(Items.iron_sword));
		BlazedCore.removeRecipe(new ItemStack(Items.iron_shovel));
		BlazedCore.removeRecipe(new ItemStack(Items.iron_hoe));
		BlazedCore.removeRecipe(new ItemStack(Items.diamond_axe));
		BlazedCore.removeRecipe(new ItemStack(Items.diamond_pickaxe));
		BlazedCore.removeRecipe(new ItemStack(Items.diamond_sword));
		BlazedCore.removeRecipe(new ItemStack(Items.diamond_shovel));
		BlazedCore.removeRecipe(new ItemStack(Items.diamond_hoe));
		
		BlazedCore.removeRecipe(new ItemStack(Items.diamond_helmet));
		BlazedCore.removeRecipe(new ItemStack(Items.diamond_boots));
		BlazedCore.removeRecipe(new ItemStack(Items.diamond_chestplate));
		BlazedCore.removeRecipe(new ItemStack(Items.diamond_leggings));
		BlazedCore.removeRecipe(new ItemStack(Items.iron_helmet));
		BlazedCore.removeRecipe(new ItemStack(Items.iron_boots));
		BlazedCore.removeRecipe(new ItemStack(Items.iron_chestplate));
		BlazedCore.removeRecipe(new ItemStack(Items.iron_leggings));*/
		
		GameRegistry.addRecipe(new ItemStack(pick_flint), new Object[]{"MMM"," R "," R ", ('M'), gemFlint, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(pick_copper), new Object[]{"MMM"," R "," R ", ('M'), ingotCopper, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(pick_bronze), new Object[]{"MMM"," R "," R ", ('M'), ingotBronze, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(pick_iron), new Object[]{"MMM"," R "," R ", ('M'), Items.iron_ingot, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(pick_nickel), new Object[]{"MMM"," R "," R ", ('M'), ingotNickel, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(pick_cobalt), new Object[]{"MMM"," R "," R ", ('M'), ingotCobalt, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(pick_ruby), new Object[]{"MMM"," R "," R ", ('M'), gemRuby, ('R'), rodRuby});
		GameRegistry.addRecipe(new ItemStack(pick_sapphire), new Object[]{"MMM"," R "," R ", ('M'), gemSapphire, ('R'), rodSapphire});
		GameRegistry.addRecipe(new ItemStack(pick_peridotite), new Object[]{"MMM"," R "," R ", ('M'), gemPeridotite, ('R'), rodPeridotite});
		GameRegistry.addRecipe(new ItemStack(pick_topaz), new Object[]{"MMM"," R "," R ", ('M'), gemTopaz, ('R'), rodTopaz});
		GameRegistry.addRecipe(new ItemStack(pick_emerald), new Object[]{"MMM"," R "," R ", ('M'), Items.emerald, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(pick_diamond), new Object[]{"MMM"," R "," R ", ('M'), Items.diamond, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(pick_obsidian), new Object[]{"MMM"," R "," R ", ('M'), Blocks.obsidian, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(pick_titanium), new Object[]{"MMM"," R "," R ", ('M'), ingotTitanium, ('R'), Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(axe_flint), new Object[]{"MM","RM","R ", ('M'), gemFlint, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_copper), new Object[]{"MM","RM","R ", ('M'), ingotCopper, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_bronze), new Object[]{"MM","RM","R ", ('M'), ingotBronze, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_iron), new Object[]{"MM","RM","R ", ('M'), Items.iron_ingot, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_nickel), new Object[]{"MM","RM","R ", ('M'), ingotNickel, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_cobalt), new Object[]{"MM","RM","R ", ('M'), ingotCobalt, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_ruby), new Object[]{"MM","RM","R ", ('M'), gemRuby, ('R'), rodRuby});
		GameRegistry.addRecipe(new ItemStack(axe_sapphire), new Object[]{"MM","RM","R ", ('M'), gemSapphire, ('R'), rodSapphire});
		GameRegistry.addRecipe(new ItemStack(axe_peridotite), new Object[]{"MM","RM","R ", ('M'), gemPeridotite, ('R'), rodPeridotite});
		GameRegistry.addRecipe(new ItemStack(axe_topaz), new Object[]{"MM","RM","R ", ('M'), gemTopaz, ('R'), rodTopaz});
		GameRegistry.addRecipe(new ItemStack(axe_emerald), new Object[]{"MM","RM","R ", ('M'), Items.emerald, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_diamond), new Object[]{"MM","RM","R ", ('M'), Items.diamond, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_obsidian), new Object[]{"MM","RM","R ", ('M'), Blocks.obsidian, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_titanium), new Object[]{"MM","RM","R ", ('M'), ingotTitanium, ('R'), Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(axe_flint), new Object[]{"MM","MR"," R", ('M'), gemFlint, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_copper), new Object[]{"MM","MR"," R", ('M'), ingotCopper, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_bronze), new Object[]{"MM","MR"," R", ('M'), ingotBronze, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_iron), new Object[]{"MM","MR"," R", ('M'), Items.iron_ingot, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_nickel), new Object[]{"MM","MR"," R", ('M'), ingotNickel, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_cobalt), new Object[]{"MM","MR"," R", ('M'), ingotCobalt, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_ruby), new Object[]{"MM","MR"," R", ('M'), gemRuby, ('R'), rodRuby});
		GameRegistry.addRecipe(new ItemStack(axe_sapphire), new Object[]{"MM","MR"," R", ('M'), gemSapphire, ('R'), rodSapphire});
		GameRegistry.addRecipe(new ItemStack(axe_peridotite), new Object[]{"MM","MR"," R", ('M'), gemPeridotite, ('R'), rodPeridotite});
		GameRegistry.addRecipe(new ItemStack(axe_topaz), new Object[]{"MM","MR"," R", ('M'), gemTopaz, ('R'), rodTopaz});
		GameRegistry.addRecipe(new ItemStack(axe_emerald), new Object[]{"MM","MR"," R", ('M'), Items.emerald, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_diamond), new Object[]{"MM","MR"," R", ('M'), Items.diamond, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_obsidian), new Object[]{"MM","MR"," R", ('M'), Blocks.obsidian, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(axe_titanium), new Object[]{"MM","MR"," R", ('M'), ingotTitanium, ('R'), Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(sword_flint), new Object[]{"M","M","R", ('M'), gemFlint, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword_copper), new Object[]{"M","M","R", ('M'), ingotCopper, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword_bronze), new Object[]{"M","M","R", ('M'), ingotBronze, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword_iron), new Object[]{"M","M","R", ('M'), Items.iron_ingot, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword_nickel), new Object[]{"M","M","R", ('M'), ingotNickel, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword_cobalt), new Object[]{"M","M","R", ('M'), ingotCobalt, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword_ruby), new Object[]{"M","M","R", ('M'), gemRuby, ('R'), rodRuby});
		GameRegistry.addRecipe(new ItemStack(sword_sapphire), new Object[]{"M","M","R", ('M'), gemSapphire, ('R'), rodSapphire});
		GameRegistry.addRecipe(new ItemStack(sword_peridotite), new Object[]{"M","M","R", ('M'), gemPeridotite, ('R'), rodPeridotite});
		GameRegistry.addRecipe(new ItemStack(sword_topaz), new Object[]{"M","M","R", ('M'), gemTopaz, ('R'), rodTopaz});
		GameRegistry.addRecipe(new ItemStack(sword_emerald), new Object[]{"M","M","R", ('M'), Items.emerald, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword_diamond), new Object[]{"M","M","R", ('M'), Items.diamond, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword_obsidian), new Object[]{"M","M","R", ('M'), Blocks.obsidian, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(sword_titanium), new Object[]{"M","M","R", ('M'), ingotTitanium, ('R'), Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(sword_blazediamond), new Object[]{"  M"," M ","R  ", ('M'), Blocks.diamond_block, ('R'), Items.blaze_rod});
		GameRegistry.addRecipe(new ItemStack(sword_blazediamond), new Object[]{"M  "," M ","  R", ('M'), Blocks.diamond_block, ('R'), Items.blaze_rod});
		
		GameRegistry.addRecipe(new ItemStack(shovel_flint), new Object[]{"M","R","R", ('M'), gemFlint, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel_copper), new Object[]{"M","R","R", ('M'), ingotCopper, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel_bronze), new Object[]{"M","R","R", ('M'), ingotBronze, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel_iron), new Object[]{"M","R","R", ('M'), Items.iron_ingot, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel_nickel), new Object[]{"M","R","R", ('M'), ingotNickel, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel_cobalt), new Object[]{"M","R","R", ('M'), ingotCobalt, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel_ruby), new Object[]{"M","R","R", ('M'), gemRuby, ('R'), rodRuby});
		GameRegistry.addRecipe(new ItemStack(shovel_sapphire), new Object[]{"M","R","R", ('M'), gemSapphire, ('R'), rodSapphire});
		GameRegistry.addRecipe(new ItemStack(shovel_peridotite), new Object[]{"M","R","R", ('M'), gemPeridotite, ('R'), rodPeridotite});
		GameRegistry.addRecipe(new ItemStack(shovel_topaz), new Object[]{"M","R","R", ('M'), gemTopaz, ('R'), rodTopaz});
		GameRegistry.addRecipe(new ItemStack(shovel_emerald), new Object[]{"M","R","R", ('M'), Items.emerald, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel_diamond), new Object[]{"M","R","R", ('M'), Items.diamond, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel_obsidian), new Object[]{"M","R","R", ('M'), Blocks.obsidian, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(shovel_titanium), new Object[]{"M","R","R", ('M'), ingotTitanium, ('R'), Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(hoe_flint), new Object[]{"MM","R ","R ", ('M'), gemFlint, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_copper), new Object[]{"MM","R ","R ", ('M'), ingotCopper, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_bronze), new Object[]{"MM","R ","R ", ('M'), ingotBronze, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_iron), new Object[]{"MM","R ","R ", ('M'), Items.iron_ingot, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_nickel), new Object[]{"MM","R ","R ", ('M'), ingotNickel, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_cobalt), new Object[]{"MM","R ","R ", ('M'), ingotCobalt, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_ruby), new Object[]{"MM","R ","R ", ('M'), gemRuby, ('R'), rodRuby});
		GameRegistry.addRecipe(new ItemStack(hoe_sapphire), new Object[]{"MM","R ","R ", ('M'), gemSapphire, ('R'), rodSapphire});
		GameRegistry.addRecipe(new ItemStack(hoe_peridotite), new Object[]{"MM","R ","R ", ('M'), gemPeridotite, ('R'), rodPeridotite});
		GameRegistry.addRecipe(new ItemStack(hoe_topaz), new Object[]{"MM","R ","R ", ('M'), gemTopaz, ('R'), rodTopaz});
		GameRegistry.addRecipe(new ItemStack(hoe_emerald), new Object[]{"MM","R ","R ", ('M'), Items.emerald, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_diamond), new Object[]{"MM","R ","R ", ('M'), Items.diamond, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_obsidian), new Object[]{"MM","R ","R ", ('M'), Blocks.obsidian, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_titanium), new Object[]{"MM","R ","R ", ('M'), ingotTitanium, ('R'), Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(hoe_flint), new Object[]{"MM"," R"," R", ('M'), gemFlint, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_copper), new Object[]{"MM"," R"," R", ('M'), ingotCopper, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_bronze), new Object[]{"MM"," R"," R", ('M'), ingotBronze, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_iron), new Object[]{"MM"," R"," R", ('M'), Items.iron_ingot, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_nickel), new Object[]{"MM"," R"," R", ('M'), ingotNickel, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_cobalt), new Object[]{"MM"," R"," R", ('M'), ingotCobalt, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_ruby), new Object[]{"MM"," R"," R", ('M'), gemRuby, ('R'), rodRuby});
		GameRegistry.addRecipe(new ItemStack(hoe_sapphire), new Object[]{"MM"," R"," R", ('M'), gemSapphire, ('R'), rodSapphire});
		GameRegistry.addRecipe(new ItemStack(hoe_peridotite), new Object[]{"MM"," R"," R", ('M'), gemPeridotite, ('R'), rodPeridotite});
		GameRegistry.addRecipe(new ItemStack(hoe_topaz), new Object[]{"MM"," R"," R", ('M'), gemTopaz, ('R'), rodTopaz});
		GameRegistry.addRecipe(new ItemStack(hoe_emerald), new Object[]{"MM"," R"," R", ('M'), Items.emerald, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_diamond), new Object[]{"MM"," R"," R", ('M'), Items.diamond, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_obsidian), new Object[]{"MM"," R"," R", ('M'), Blocks.obsidian, ('R'), Items.stick});
		GameRegistry.addRecipe(new ItemStack(hoe_titanium), new Object[]{"MM"," R"," R", ('M'), ingotTitanium, ('R'), Items.stick});
		
		GameRegistry.addRecipe(new ItemStack(helmet_tin), new Object[]{"MMM","M M", ('M'), ingotTin});
		GameRegistry.addRecipe(new ItemStack(helmet_bronze), new Object[]{"MMM","M M", ('M'), ingotBronze});
		GameRegistry.addRecipe(new ItemStack(helmet_iron), new Object[]{"MMM","M M", ('M'), Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(helmet_emerald), new Object[]{"MMM","M M", ('M'), Items.emerald});
		GameRegistry.addRecipe(new ItemStack(helmet_diamond), new Object[]{"MMM","M M", ('M'), Items.diamond});
		GameRegistry.addRecipe(new ItemStack(helmet_obsidian), new Object[]{"MMM","M M", ('M'), Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(helmet_titanium), new Object[]{"MMM","M M", ('M'), ingotTitanium});
		
		GameRegistry.addRecipe(new ItemStack(chestplate_tin), new Object[]{"M M","MMM","MMM", ('M'), ingotTin});
		GameRegistry.addRecipe(new ItemStack(chestplate_bronze), new Object[]{"M M","MMM","MMM", ('M'), ingotBronze});
		GameRegistry.addRecipe(new ItemStack(chestplate_iron), new Object[]{"M M","MMM","MMM", ('M'), Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(chestplate_emerald), new Object[]{"M M","MMM","MMM", ('M'), Items.emerald});
		GameRegistry.addRecipe(new ItemStack(chestplate_diamond), new Object[]{"M M","MMM","MMM", ('M'), Items.diamond});
		GameRegistry.addRecipe(new ItemStack(chestplate_obsidian), new Object[]{"M M","MMM","MMM", ('M'), Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(chestplate_titanium), new Object[]{"M M","MMM","MMM", ('M'), ingotTitanium});
		
		GameRegistry.addRecipe(new ItemStack(leggings_tin), new Object[]{"MMM","M M","M M", ('M'), ingotTin});
		GameRegistry.addRecipe(new ItemStack(leggings_bronze), new Object[]{"MMM","M M","M M", ('M'), ingotBronze});
		GameRegistry.addRecipe(new ItemStack(leggings_iron), new Object[]{"MMM","M M","M M", ('M'), Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(leggings_emerald), new Object[]{"MMM","M M","M M", ('M'), Items.emerald});
		GameRegistry.addRecipe(new ItemStack(leggings_diamond), new Object[]{"MMM","M M","M M", ('M'), Items.diamond});
		GameRegistry.addRecipe(new ItemStack(leggings_obsidian), new Object[]{"MMM","M M","M M", ('M'), Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(leggings_titanium), new Object[]{"MMM","M M","M M", ('M'), ingotTitanium});
		
		GameRegistry.addRecipe(new ItemStack(boots_tin), new Object[]{"M M","M M", ('M'), ingotTin});
		GameRegistry.addRecipe(new ItemStack(boots_bronze), new Object[]{"M M","M M", ('M'), ingotBronze});
		GameRegistry.addRecipe(new ItemStack(boots_iron), new Object[]{"M M","M M", ('M'), Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(boots_emerald), new Object[]{"M M","M M", ('M'), Items.emerald});
		GameRegistry.addRecipe(new ItemStack(boots_diamond), new Object[]{"M M","M M", ('M'), Items.diamond});
		GameRegistry.addRecipe(new ItemStack(boots_obsidian), new Object[]{"M M","M M", ('M'), Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(boots_titanium), new Object[]{"M M","M M", ('M'), ingotTitanium});
		
		GameRegistry.addRecipe(new ItemStack(rodRuby, 6), new Object[]{"M","M",('M'),gemRuby});
		GameRegistry.addRecipe(new ItemStack(rodTopaz, 6), new Object[]{"M","M",('M'),gemTopaz});
		GameRegistry.addRecipe(new ItemStack(rodSapphire, 6), new Object[]{"M","M",('M'),gemSapphire});
		GameRegistry.addRecipe(new ItemStack(rodPeridotite, 6), new Object[]{"M","M",('M'),gemPeridotite});
		GameRegistry.addRecipe(new ItemStack(andesite_smooth, 4), new Object[]{"MM","MM",('M'),andesite});
		GameRegistry.addRecipe(new ItemStack(granite_smooth, 4), new Object[]{"MM","MM",('M'),granite});
		GameRegistry.addRecipe(new ItemStack(diorite_smooth, 4), new Object[]{"MM","MM",('M'),diorite});
		GameRegistry.addRecipe(new ItemStack(endstone_brick, 4), new Object[]{"MM","MM",('M'),Blocks.end_stone});
		GameRegistry.addShapelessRecipe(new ItemStack(ingotBronze, 3), new Object[]{ingotCopper, ingotTin, ingotCopper});
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.torch, 8), new Object[]{Items.flint, Items.stick, Items.flint});
		GameRegistry.addShapelessRecipe(new ItemStack(sword_blazediamond), new Object[]{sword_blazediamond});
		GameRegistry.addShapelessRecipe(new ItemStack(gemFlint), new Object[]{Items.flint});
		
		GameRegistry.addSmelting(new ItemStack(chunkCopper), new ItemStack(ingotCopper), 0.2F);
		GameRegistry.addSmelting(new ItemStack(chunkTin), new ItemStack(ingotTin), 0.2F);
		GameRegistry.addSmelting(new ItemStack(chunkCobalt), new ItemStack(ingotCobalt), 0.35F);
		GameRegistry.addSmelting(new ItemStack(chunkNickel), new ItemStack(ingotNickel), 0.35F);
		GameRegistry.addSmelting(new ItemStack(chunkTitanium), new ItemStack(ingotTitanium), 0.6F);
		
		endIslands = new BlazedGenerator(Blocks.end_stone, Blocks.air, new int[]{1}, 256, 1, 1, 50);
		endObsidianIslands = new BlazedGenerator(Blocks.obsidian, Blocks.air, new int[]{1}, 256, 129, 1, 30);
		dioriteVeins = new BlazedGenerator(diorite, Blocks.stone, new int[]{0,7}, 100, 50, 3, 40);
		andesiteVeins = new BlazedGenerator(andesite, Blocks.stone, new int[]{0,7}, 100, 50, 3, 40);
		graniteVeins = new BlazedGenerator(granite, Blocks.stone, new int[]{0,7}, 100, 50, 3, 40);
		
		dioriteCoGen = new BlazedGenerator(dioriteCobalt, diorite, new int[]{0,7}, 100, 50, 3, 5);
		dioriteNiGen = new BlazedGenerator(dioriteNickel, diorite, new int[]{0,7}, 100, 50, 3, 5);
		andesiteCuGen = new BlazedGenerator(andesiteCopper, andesite, new int[]{0,7}, 100, 50, 4, 7);
		andesiteTopazGen = new BlazedGenerator(andesiteTopaz, andesite, new int[]{0,7}, 100, 50, 4, 4);
		graniteCuGen = new BlazedGenerator(graniteCopper, granite, new int[]{0,7}, 100, 50, 4, 7);
		graniteSnGen = new BlazedGenerator(graniteTin, granite, new int[]{0,7}, 100, 50, 5, 6);
		obsidianTopazGen = new BlazedGenerator(obsidianTopaz, Blocks.obsidian, new int[]{1,7}, 128, 1, 4, 6);
		islandTopazGen = new BlazedGenerator(obsidianTopaz, Blocks.obsidian, new int[]{1,7}, 256, 129, 1, 5);
		gravelFlintGen = new BlazedGenerator(gravelFlint, Blocks.gravel, new int[]{0}, 80, 60, 5, 8);
		gravelTiGen = new BlazedGenerator(gravelTitanium, Blocks.gravel, new int[]{-1,7}, 128, 1, 3, 3);
		stoneSnGen = new BlazedGenerator(stoneTin, Blocks.stone, new int[]{0,7}, 55, 1, 7, 8);
		stoneRubyGen = new BlazedGenerator(stoneRuby, Blocks.stone, new int[]{0,7}, 12, 1, 5, 5);
		stoneSapphireGen = new BlazedGenerator(stoneSapphire, Blocks.stone, new int[]{0,7}, 24, 13, 5, 5);
		stonePeridotiteGen = new BlazedGenerator(stonePeridotite, Blocks.stone, new int[]{0,7}, 36, 25, 5, 5);
		endSnGen = new BlazedGenerator(endstoneTin, Blocks.end_stone, new int[]{1}, 128, 1, 7, 8);
		endRubyGen = new BlazedGenerator(endstoneRuby, Blocks.end_stone, new int[]{1}, 85, 1, 5, 5);
		endSapphireGen = new BlazedGenerator(endstoneSapphire, Blocks.end_stone, new int[]{1}, 170, 86, 5, 5);
		endPeridotiteGen = new BlazedGenerator(endstonePeridotite, Blocks.end_stone, new int[]{1}, 255, 171, 5, 5);
		netherSnGen = new BlazedGenerator(netherrackTin, Blocks.netherrack, new int[]{-1}, 75, 1, 6, 6);
		netherCuGen = new BlazedGenerator(netherrackCopper, Blocks.netherrack, new int[]{-1}, 85, 1, 6, 7);
		netherTiGen = new BlazedGenerator(netherrackTitanium, Blocks.netherrack, new int[]{-1}, 50, 1, 6, 6);
		netherTopazGen = new BlazedGenerator(netherrackTopaz, Blocks.netherrack, new int[]{-1}, 65, 1, 6, 6);
		
		GameRegistry.registerWorldGenerator(endIslands, 0);
		GameRegistry.registerWorldGenerator(dioriteVeins, 0);
		GameRegistry.registerWorldGenerator(andesiteVeins, 0);
		GameRegistry.registerWorldGenerator(graniteVeins, 0);
		GameRegistry.registerWorldGenerator(endObsidianIslands, 0);
		
		GameRegistry.registerWorldGenerator(dioriteCoGen, 1);
		GameRegistry.registerWorldGenerator(dioriteNiGen, 1);
		GameRegistry.registerWorldGenerator(andesiteCuGen, 1);
		GameRegistry.registerWorldGenerator(andesiteTopazGen, 1);
		GameRegistry.registerWorldGenerator(graniteSnGen, 1);
		GameRegistry.registerWorldGenerator(graniteCuGen, 1);
		GameRegistry.registerWorldGenerator(obsidianTopazGen, 1);
		GameRegistry.registerWorldGenerator(islandTopazGen, 1);
		GameRegistry.registerWorldGenerator(gravelTiGen, 1);
		GameRegistry.registerWorldGenerator(gravelFlintGen, 1);
		GameRegistry.registerWorldGenerator(stoneRubyGen, 1);
		GameRegistry.registerWorldGenerator(stoneSapphireGen, 1);
		GameRegistry.registerWorldGenerator(stonePeridotiteGen, 1);
		GameRegistry.registerWorldGenerator(stoneSnGen, 1);
		GameRegistry.registerWorldGenerator(endRubyGen, 1);
		GameRegistry.registerWorldGenerator(endSapphireGen, 1);
		GameRegistry.registerWorldGenerator(endPeridotiteGen, 1);
		GameRegistry.registerWorldGenerator(endSnGen, 1);
		GameRegistry.registerWorldGenerator(netherTiGen, 1);
		GameRegistry.registerWorldGenerator(netherTopazGen, 1);
		GameRegistry.registerWorldGenerator(netherSnGen, 1);
		GameRegistry.registerWorldGenerator(netherCuGen, 1);
	}
}