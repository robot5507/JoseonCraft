/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.ryubyee.joseoncraft.init;

import com.ryubyee.joseoncraft.ProjectJoseonCraftMod;
import com.ryubyee.joseoncraft.item.BongItem;
import com.ryubyee.joseoncraft.item.DangpaItem;
import com.ryubyee.joseoncraft.item.GukgungItem;
import com.ryubyee.joseoncraft.item.HwaldaeItem;
import com.ryubyee.joseoncraft.item.HyapdoItem;
import com.ryubyee.joseoncraft.item.Jangchang2Item;
import com.ryubyee.joseoncraft.item.JangchangItem;
import com.ryubyee.joseoncraft.item.Jukjangchang2Item;
import com.ryubyee.joseoncraft.item.JukjangchangItem;
import com.ryubyee.joseoncraft.item.PyeonjeonItem;
import com.ryubyee.joseoncraft.item.SsangsudoItem;
import com.ryubyee.joseoncraft.item.TongaItem;
import com.ryubyee.joseoncraft.item.Waldo2Item;
import com.ryubyee.joseoncraft.item.WaldoItem;
import com.ryubyee.joseoncraft.item.WhandoItem;
import com.ryubyee.joseoncraft.item.WhandodadoItem;
import com.ryubyee.joseoncraft.item.YukmoclubItem;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ProjectJoseonCraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ProjectJoseonCraftMod.MODID);
	public static final RegistryObject<Item> DANGPA;
	public static final RegistryObject<Item> WHANDODADO;
	public static final RegistryObject<Item> WHANDO;
	public static final RegistryObject<Item> JANGCHANG;
	public static final RegistryObject<Item> HYAPDO;
	public static final RegistryObject<Item> YUKMOCLUB;
	public static final RegistryObject<Item> GUKGUNG;
	public static final RegistryObject<Item> JUKJANGCHANG;
	public static final RegistryObject<Item> BONG;
	public static final RegistryObject<Item> HWALDAE;
	public static final RegistryObject<Item> SSANGSUDO;
	public static final RegistryObject<Item> WALDO;
	public static final RegistryObject<Item> PYEONJEON;
	public static final RegistryObject<Item> TONGA;
	public static final RegistryObject<Item> JANGCHANG_2;
	public static final RegistryObject<Item> JUKJANGCHANG_2;
	public static final RegistryObject<Item> WALDO_2;
	static {
		DANGPA = REGISTRY.register("dangpa", DangpaItem::new);
		WHANDODADO = REGISTRY.register("whandodado", WhandodadoItem::new);
		WHANDO = REGISTRY.register("whando", WhandoItem::new);
		JANGCHANG = REGISTRY.register("jangchang", JangchangItem::new);
		HYAPDO = REGISTRY.register("hyapdo", HyapdoItem::new);
		YUKMOCLUB = REGISTRY.register("yukmoclub", YukmoclubItem::new);
		GUKGUNG = REGISTRY.register("gukgung", GukgungItem::new);
		JUKJANGCHANG = REGISTRY.register("jukjangchang", JukjangchangItem::new);
		BONG = REGISTRY.register("bong", BongItem::new);
		HWALDAE = REGISTRY.register("hwaldae", HwaldaeItem::new);
		SSANGSUDO = REGISTRY.register("ssangsudo", SsangsudoItem::new);
		WALDO = REGISTRY.register("waldo", WaldoItem::new);
		PYEONJEON = REGISTRY.register("pyeonjeon", PyeonjeonItem::new);
		TONGA = REGISTRY.register("tonga", TongaItem::new);
		JANGCHANG_2 = REGISTRY.register("jangchang_2", Jangchang2Item::new);
		JUKJANGCHANG_2 = REGISTRY.register("jukjangchang_2", Jukjangchang2Item::new);
		WALDO_2 = REGISTRY.register("waldo_2", Waldo2Item::new);
	}
	// Start of user code block custom items
	// End of user code block custom items
}