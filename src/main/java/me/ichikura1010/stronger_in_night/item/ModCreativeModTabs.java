package me.ichikura1010.stronger_in_night.item;

import me.ichikura1010.stronger_in_night.StrongerInNightMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StrongerInNightMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STRONGE_IN_NIGHT = CREATIVE_MODE_TABS.register("stronger_in_night",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_SHADOW_STONE.get()))
                    .title(Component.translatable("creativetab.STRONGER_IN_NIGHT"))
                    .displayItems((pParameters, pOutput) -> {
                        // TODO ここにクリエタブに追加したいアイテムを追加。
                        pOutput.accept(ModItems.RAW_SHADOW_STONE.get());
                        pOutput.accept(ModItems.SHADOW_STONE_INGOT.get());
                        pOutput.accept(ModItems.SHADOW_HELMET.get());
                        pOutput.accept(ModItems.SHADOW_CHESTPLATE.get());
                        pOutput.accept(ModItems.SHADOW_LEGGINGS.get());
                        pOutput.accept(ModItems.SHADOW_BOOTS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
