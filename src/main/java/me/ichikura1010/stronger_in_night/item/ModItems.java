package me.ichikura1010.stronger_in_night.item;

import me.ichikura1010.stronger_in_night.StrongerInNightMod;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // レジストリを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StrongerInNightMod.MOD_ID);

    // レジストリにアイテムを登録
    public static final RegistryObject<Item> RAW_SHADOW_STONE  = ITEMS.register("raw_shadow_stone",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SHADOW_STONE_INGOT = ITEMS.register("shadow_stone_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SHADOW_HELMET = ITEMS.register("shadow_helmet",
            () -> new ArmorItem(ModArmorMaterials.SHADOW_STONE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SHADOW_CHESTPLATE = ITEMS.register("shadow_chestplate",
            () -> new ArmorItem(ModArmorMaterials.SHADOW_STONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SHADOW_LEGGINGS = ITEMS.register("shadow_leggings",
            () -> new ArmorItem(ModArmorMaterials.SHADOW_STONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SHADOW_BOOTS = ITEMS.register("shadow_boots",
            () -> new ArmorItem(ModArmorMaterials.SHADOW_STONE, ArmorItem.Type.BOOTS, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
