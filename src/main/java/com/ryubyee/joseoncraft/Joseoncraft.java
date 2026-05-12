package com.ryubyee.joseoncraft;

import com.ryubyee.joseoncraft.item.JoseoncraftItems;
import com.ryubyee.joseoncraft.misc.JoseoncraftCreativeTabs;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Joseoncraft.MODID)
public class Joseoncraft 
{
	public static final String MODID = "joseoncraft";

	public Joseoncraft(FMLJavaModLoadingContext ctx) 
	{
		IEventBus bus = ctx.getModEventBus();
		JoseoncraftItems.ITEMS.register(bus);
		JoseoncraftCreativeTabs.CREATIVE_MODE_TAB.register(bus);
	}
}