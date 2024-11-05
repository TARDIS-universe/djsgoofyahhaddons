package com.dj.commands;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.GameMode;
import java.util.concurrent.TimeUnit;


public class jail {
}

@Override
public void onInitialize() {
    LOGGER.info("Hello Fabric world!");

    // Register the `/jail` command
    CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
        dispatcher.register(CommandManager.literal("jail")
                .then(CommandManager.argument("player", StringArgumentType.word()) // Player name argument
                        .then(CommandManager.argument("jailid", IntegerArgumentType.integer()) // Jail ID argument
                                .then(CommandManager.argument("cellid", IntegerArgumentType.integer()) // Cell ID argument
                                        .then(CommandManager.argument("duration", IntegerArgumentType.integer()) // Duration argument
                                                .then(CommandManager.argument("duration_time", StringArgumentType.word()) // Duration time (days, months, etc.)
                                                        .executes(this::executeJailCommand))))));
    });
}

