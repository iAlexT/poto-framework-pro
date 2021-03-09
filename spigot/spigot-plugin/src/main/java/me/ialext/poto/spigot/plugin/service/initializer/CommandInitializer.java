package me.ialext.poto.spigot.plugin.service.initializer;

import me.ialext.poto.common.api.service.Service;
import me.ialext.poto.spigot.plugin.PotoTest;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;

import java.util.List;

public class CommandInitializer implements Service {

  private final PotoTest potoTest;

  public CommandInitializer(PotoTest potoTest) {
    this.potoTest = potoTest;
  }

  @Override
  public void setup() {
    Bukkit.getLogger().info("Registering commands...");
  }

  private void registerCommands(List<String> names,
                                List<CommandExecutor> commandExecutors) {
    for (String name : names) {
      for (CommandExecutor commandExecutor : commandExecutors) {
        potoTest.getCommand(name).setExecutor(commandExecutor);
      }
    }
  }
}
