package com.robertx22.mine_and_slash.commands.dev;

import com.mojang.brigadier.CommandDispatcher;
import com.robertx22.mine_and_slash.commands.CommandRefs;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import net.minecraft.command.CommandSource;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.PlayerEntity;

import javax.annotation.Nullable;

import static net.minecraft.command.Commands.argument;
import static net.minecraft.command.Commands.literal;

public class TpOut {
    public static void register(CommandDispatcher<CommandSource> commandDispatcher) {
        commandDispatcher.register(
            literal(CommandRefs.ID)
                .then(literal("dev").requires(e -> e.hasPermissionLevel(2))
                    .then(literal("tp")
                        .requires(e -> e.hasPermissionLevel(2))
                        .then(literal("out")
                            .then(argument("target", EntityArgument.player())
                                .executes(ctx -> run(EntityArgument.getPlayer(ctx, "target"))))))));
    }

    private static int run(@Nullable PlayerEntity player) {

        try {
            Load.playerMapData(player)
                .teleportPlayerBack(player);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }
}
