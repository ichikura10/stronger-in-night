package me.ichikura1010.stronger_in_night.datagen;

import me.ichikura1010.stronger_in_night.StrongerInNightMod;
import me.ichikura1010.stronger_in_night.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StrongerInNightMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // TODO アイテムを追加した時、ここに追加
        basicItem(ModItems.RAW_SHADOW_STONE.get());
        basicItem(ModItems.SHADOW_STONE_INGOT.get());
        basicItem(ModItems.SHADOW_HELMET.get());
        basicItem(ModItems.SHADOW_CHESTPLATE.get());
        basicItem(ModItems.SHADOW_LEGGINGS.get());
        basicItem(ModItems.SHADOW_BOOTS.get());
    }
}
