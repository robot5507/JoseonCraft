/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryubyee.joseoncraft.init;

import com.ryubyee.joseoncraft.ProjectJoseonCraftMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ProjectJoseonCraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectJoseonCraftMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(ProjectJoseonCraftModItems.DANGPA.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(ProjectJoseonCraftModItems.DANGPA.get());
			tabData.accept(ProjectJoseonCraftModItems.WHANDODADO.get());
			tabData.accept(ProjectJoseonCraftModItems.WHANDO.get());
			tabData.accept(ProjectJoseonCraftModItems.JANGCHANG.get());
			tabData.accept(ProjectJoseonCraftModItems.HYAPDO.get());
			tabData.accept(ProjectJoseonCraftModItems.YUKMOCLUB.get());
			tabData.accept(ProjectJoseonCraftModItems.GUKGUNG.get());
			tabData.accept(ProjectJoseonCraftModItems.JUKJANGCHANG.get());
			tabData.accept(ProjectJoseonCraftModItems.BONG.get());
			tabData.accept(ProjectJoseonCraftModItems.SSANGSUDO.get());
			tabData.accept(ProjectJoseonCraftModItems.WALDO.get());
			tabData.accept(ProjectJoseonCraftModItems.PYEONJEON.get());
			tabData.accept(ProjectJoseonCraftModItems.TONGA.get());
			tabData.accept(ProjectJoseonCraftModItems.JANGCHANG_2.get());
			tabData.accept(ProjectJoseonCraftModItems.JUKJANGCHANG_2.get());
			tabData.accept(ProjectJoseonCraftModItems.WALDO_2.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(ProjectJoseonCraftModItems.HWALDAE.get());
		}
	}
}