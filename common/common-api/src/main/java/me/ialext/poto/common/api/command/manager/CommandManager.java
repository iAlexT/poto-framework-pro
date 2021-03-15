package me.ialext.poto.common.api.command.manager;

import me.ialext.poto.common.api.command.CommandClass;
import me.ialext.poto.common.api.command.meta.CommandMeta;

import java.util.List;

public interface CommandManager {

  void registerCommand(CommandClass commandClass);

  default void registerCommands(CommandClass... commandClasses) {
    for (CommandClass commandClass : commandClasses) {
      registerCommand(commandClass);
    }
  }

  void unregisterCommand(String name);

  default void unregisterCommands(String... names) {
    for (String name : names) {
      unregisterCommand(name);
    }
  }

  boolean isRegistered(String name);

  List<CommandMeta> getRegisteredCommands();

}
