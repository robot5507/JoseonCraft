package com.ryubyee.joseoncraft.client;

import com.ryubyee.joseoncraft.init.ProjectJoseonCraftModItems;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientReloadListenersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void registerItemProperties(RegisterClientReloadListenersEvent event) {
        ItemProperties.register(
            ProjectJoseonCraftModItems.GUKGUNG.get(),
            new ResourceLocation("pull"),
            (ItemStack stack, net.minecraft.client.multiplayer.ClientLevel world, LivingEntity entity, int seed) -> {
                if (entity == null) return 0.0F;
                return entity.getUseItem() != stack ? 0.0F :
                        (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
            }
        );

        ItemProperties.register(
            ProjectJoseonCraftModItems.GUKGUNG.get(),
            new ResourceLocation("pulling"),
            (ItemStack stack, net.minecraft.client.multiplayer.ClientLevel world, LivingEntity entity, int seed) -> {
                return entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F;
            }
        );
    }
}