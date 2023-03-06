
package io.github.ojngstudios.avaritiacookies.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import io.github.ojngstudios.avaritiacookies.ElementsAvaritiacookiesMod;

@ElementsAvaritiacookiesMod.ModElement.Tag
public class ItemAvaritiacookies extends ElementsAvaritiacookiesMod.ModElement {
	@GameRegistry.ObjectHolder("avaritiacookies:avaritiacookies")
	public static final Item block = null;
	public ItemAvaritiacookies(ElementsAvaritiacookiesMod instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("avaritiacookies:avaritiacookies", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(999, 999f, false);
			setUnlocalizedName("avaritiacookies");
			setRegistryName("avaritiacookies");
			setAlwaysEdible();
			setCreativeTab(CreativeTabs.FOOD);
			setMaxStackSize(64);
		}

		@Override
		@SideOnly(Side.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}
