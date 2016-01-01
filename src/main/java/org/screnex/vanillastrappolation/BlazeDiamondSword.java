package org.screnex.vanillastrappolation;

import org.screnex.blazedcore.BlazedSword;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlazeDiamondSword extends BlazedSword {
	public BlazeDiamondSword() {
		super(VanillaStrappolation.blazediamondSwordMaterial, "blazediamond_sword", "vanillastrapp:blazediamond_sword", VanillaStrappolation.tabVanillastrappCombat, "blazediamond_sword");
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		super.onCreated(stack, world, player);
		stack.addEnchantment(Enchantment.unbreaking, 2);
		stack.addEnchantment(Enchantment.fireAspect, 3);
    }
}
