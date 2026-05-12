package com.ryubyee.joseoncraft.event;

import com.ryubyee.joseoncraft.Joseoncraft;
import com.ryubyee.joseoncraft.item.JoseoncraftItems;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Joseoncraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler 
{
    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event)
    {
    	event.enqueueWork(() -> 
    	{
            ItemProperties.register(JoseoncraftItems.GUKGUNG.get(), ResourceLocation.parse("pull"), (stack, world, entity, seed) -> 
            {
            	if(entity == null)
            	{
            		return 0.0F;
            	}
            	return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
            });

            ItemProperties.register(JoseoncraftItems.GUKGUNG.get(), ResourceLocation.parse("pulling"), (stack, world, entity, seed) -> 
            {
            	return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
            });
    	});
    }
}
