package at.helpch.chatchat.command;

import at.helpch.chatchat.ChatChatPlugin;
import dev.triumphteam.cmd.core.BaseCommand;
import dev.triumphteam.cmd.core.annotation.Command;
import dev.triumphteam.cmd.core.annotation.SubCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class ReloadCommand extends ChatChatCommand {

    private final ChatChatPlugin plugin;

    public ReloadCommand(@NotNull final ChatChatPlugin plugin) {
        this.plugin = plugin;
    }

    @SubCommand("reload")
    public void reloadCommand(final CommandSender sender) {
        plugin.configManager().reload();

        var formatsConfig = plugin.configManager().formats();

        int formats = formatsConfig.formats().size();
        plugin.audiences().sender(sender)
                .sendMessage(Component.text(formats + " " + (formats == 1 ? "format" : "formats") + " loaded!", NamedTextColor.GREEN));
    }
}
