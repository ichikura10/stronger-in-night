package me.ichikura1010.stronger_in_night.item.custom;

import com.google.common.collect.ImmutableMap;
import me.ichikura1010.stronger_in_night.item.ModArmorMaterials;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    public record ArmorEffect(
            MobEffect effect,
            int duration,
            int amplifier,
            boolean ambient,
            boolean visible,
            boolean showIcon
    ) {}

    private static final Map<ArmorMaterial, List<ArmorEffect>> MATERIAL_TO_EFFECT_MAP =
            ImmutableMap.of(
                    ModArmorMaterials.SHADOW_STONE,
                    List.of(
                            new ArmorEffect(
                                    MobEffects.NIGHT_VISION,
                                    500,
                                    0,
                                    false,
                                    false,
                                    true
                            ),
                            new ArmorEffect(
                                    MobEffects.MOVEMENT_SPEED,
                                    500,
                                    0,
                                    false,
                                    false,
                                    true
                            )
                    )
            );

    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, List<ArmorEffect>> entry
                : MATERIAL_TO_EFFECT_MAP.entrySet()) {

            ArmorMaterial material = entry.getKey();
            List<ArmorEffect> effects = entry.getValue();

            if (hasCorrectArmorOn(material, player)) {
                applyArmorEffects(player, effects);
            }
        }
    }

    private boolean isNight(Level level) {
        long time = level.getDayTime() % 24000;
        return time >= 13000 && time <= 23000;
    }

    private void applyArmorEffects(Player player, List<ArmorEffect> effects) {
        if (!isNight(player.level())) return;

        for (ArmorEffect e : effects) {
            MobEffectInstance current = player.getEffect(e.effect());

            // 効果がない or 残り15秒以下
            if (current == null || current.getDuration() <= 300) {
                player.addEffect(new MobEffectInstance(
                        e.effect(),
                        e.duration(),
                        e.amplifier(),
                        e.ambient(),
                        e.visible(),
                        e.showIcon()
                ));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material &&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}