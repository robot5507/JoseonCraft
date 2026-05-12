package com.ryubyee.joseoncraft.misc;

import com.ryubyee.joseoncraft.Joseoncraft;
import com.ryubyee.joseoncraft.item.JoseoncraftItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class JoseoncraftCreativeTabs 
{
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Joseoncraft.MODID);

    public static final RegistryObject<CreativeModeTab> JOSEONCRAFT = CREATIVE_MODE_TAB.register(Joseoncraft.MODID, () -> CreativeModeTab.builder()
    		.title(Component.translatable("itemGroup.joseoncraft"))
    		.icon(() -> new ItemStack(JoseoncraftItems.ICON.get()))
    		.displayItems((enabledFeatures, output) -> 
    		{
    			for(RegistryObject<Item> item : JoseoncraftItems.ITEMS.getEntries())
    			{
    				if(item == JoseoncraftItems.ICON)
    				{
    					continue;
    				}
    				output.accept(item.get());
    			}
    		}).build());
}