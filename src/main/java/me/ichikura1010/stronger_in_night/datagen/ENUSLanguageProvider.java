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

        add("creativetab.test_tab", "test");
    }
}
