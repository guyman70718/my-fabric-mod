package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.items.WhopperItem;
import net.fabricmc.fabric.api.registry.CommandRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.server.command.CommandManager;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GameMode;

public class ExampleMod implements ModInitializer {
	//public static final FoodItemSetting WHOPPER_ITEM = (new FoodItemSetting.Builder()).hunger(20).saturationModifier(.5F).wolfFood().alwaysEdible().build();
	public static final WhopperItem WHOPPER_ITEM = new WhopperItem(new Item.Settings().itemGroup(ItemGroup.MISC));
	public static final SoundEvent OH_YEAH_SOUND = (SoundEvent)Registry.register(Registry.SOUND_EVENT, "wikitut.sounds.ohyeah", new SoundEvent(new Identifier("wikitut.sounds.ohyeah")));
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registry.ITEM, new Identifier("wikitut", "whopper"), WHOPPER_ITEM);
		CommandRegistry.INSTANCE.register(false, dispatcher ->
				dispatcher.register(
						CommandManager.literal("gmc")
								.executes(command ->
								{
									MinecraftClient.getInstance().player.setGameMode(GameMode.CREATIVE);
									return 1;
								})
				));
		CommandRegistry.INSTANCE.register(false, dispatcher ->
				dispatcher.register(
						CommandManager.literal("gms")
								.executes(command ->
								{
									MinecraftClient.getInstance().player.setGameMode(GameMode.SURVIVAL);
									return 1;
								})
				));
		CommandRegistry.INSTANCE.register(false, dispatcher ->
				dispatcher.register(
						CommandManager.literal("gmsp")
								.executes(command ->
								{
									MinecraftClient.getInstance().player.setGameMode(GameMode.SPECTATOR);
									return 1;
								})
				));
		CommandRegistry.INSTANCE.register(false, dispatcher ->
				dispatcher.register(
						CommandManager.literal("gma")
								.executes(command ->
								{
									MinecraftClient.getInstance().player.setGameMode(GameMode.ADVENTURE);
									return 1;
								})
				));
		System.out.println("Hello Fabric world!");
	}
}
