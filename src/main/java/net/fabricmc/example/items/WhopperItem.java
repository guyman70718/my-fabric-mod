package net.fabricmc.example.items;

import net.fabricmc.example.ExampleMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.network.chat.Component;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WhopperItem extends Item {
    public WhopperItem(Item.Settings settings){
        //super((new Item.Settings().itemGroup(ItemGroup.MISC)).food((new FoodItemSetting.Builder()).hunger(20).saturationModifier(.5F).wolfFood().alwaysEdible().build()));
        super(new Item.Settings().food((new FoodItemSetting.Builder()).hunger(20).saturationModifier(.5f).alwaysEdible().wolfFood().build()));
    }
    @Override
    public ItemStack onItemFinishedUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1) {
        livingEntity_1.addPotionEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 6000));
        livingEntity_1.playSound(ExampleMod.OH_YEAH_SOUND, 1.0F, 1.0F);
        return this.isFood() ? livingEntity_1.eatFood(world_1, itemStack_1) : itemStack_1;
    }
    /*@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.setVelocity(2,2,2);
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }*/

}