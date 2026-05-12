package com.ryubyee.joseoncraft.item;

import com.ryubyee.joseoncraft.Joseoncraft;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class JoseoncraftItems 
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Joseoncraft.MODID);
	
	public static final RegistryObject<Item> ICON = ITEMS.register("icon", () -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> DANGPA = ITEMS.register("dangpa", () -> new DangpaItem());
	public static final RegistryObject<Item> WHANDODADO = ITEMS.register("whandodado", () -> new WhandodadoItem());
	public static final RegistryObject<Item> WHANDO = ITEMS.register("whando", () -> new WhandoItem());
	public static final RegistryObject<Item> JANGCHANG = ITEMS.register("jangchang", () -> new JangchangItem());
	public static final RegistryObject<Item> HYAPDO = ITEMS.register("hyapdo", () -> new HyapdoItem());
	public static final RegistryObject<Item> YUKMOCLUB = ITEMS.register("yukmoclub", () -> new YukmoclubItem());
	public static final RegistryObject<Item> GUKGUNG = ITEMS.register("gukgung", () -> new GukgungItem());
	public static final RegistryObject<Item> JUKJANGCHANG = ITEMS.register("jukjangchang", () -> new JukjangchangItem());
	public static final RegistryObject<Item> BONG = ITEMS.register("bong", () -> new BongItem());
	public static final RegistryObject<Item> HWALDAE = ITEMS.register("hwaldae", () -> new HwaldaeItem());
	public static final RegistryObject<Item> SSANGSUDO = ITEMS.register("ssangsudo", () -> new SsangsudoItem());
	public static final RegistryObject<Item> WALDO = ITEMS.register("waldo", () -> new WaldoItem());
	public static final RegistryObject<Item> PYEONJEON = ITEMS.register("pyeonjeon", () -> new PyeonjeonItem());
	public static final RegistryObject<Item> TONGA = ITEMS.register("tonga", () -> new TongaItem());
	public static final RegistryObject<Item> JANGCHANG_2 = ITEMS.register("jangchang_2", () -> new Jangchang2Item());
	public static final RegistryObject<Item> JUKJANGCHANG_2 = ITEMS.register("jukjangchang_2", () -> new Jukjangchang2Item());
	public static final RegistryObject<Item> WALDO_2 = ITEMS.register("waldo_2", () -> new Waldo2Item());
}