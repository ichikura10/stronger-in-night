package me.ichikura1010.stronger_in_night.datagen;

import me.ichikura1010.stronger_in_night.StrongerInNightMod;
import me.ichikura1010.stronger_in_night.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, StrongerInNightMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        // TODO 英語翻訳をここでする。
        addItem(ModItems.RAW_SHADOW_STONE, "Raw Shadow Stone");
        addItem(ModItems.SHADOW_STONE_INGOT, "Shadow Stone Ingot");

        addItem(ModItems.SHADOW_HELMET,"Shadow Helmet");
        addItem(ModItems.SHADOW_CHESTPLATE,"Shadow Chestplate");
        addItem(ModItems.SHADOW_LEGGINGS,"Shadow Leggings");
        addItem(ModItems.SHADOW_BOOTS,"Shadow Boots");

        add("creativetab.STRONGER_IN_NIGHT", "Stronger In Night");
    }
}
