package me.ichikura1010.stronger_in_night.datagen;

import me.ichikura1010.stronger_in_night.StrongerInNightMod;
import me.ichikura1010.stronger_in_night.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, StrongerInNightMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        // TODO 日本語翻訳をここでする。
        addItem(ModItems.RAW_SHADOW_STONE, "影の原石");
        addItem(ModItems.SHADOW_STONE_INGOT, "影のインゴット");

        add("creativetab.test_tab", "てすと");
    }
}
