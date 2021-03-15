package me.ialext.poto.common.core.command.manager;

import me.ialext.poto.common.api.command.CommandClass;
import me.ialext.poto.common.api.command.builder.AnnotatedCommandBuilder;
import me.ialext.poto.common.api.command.manager.CommandManager;
import me.ialext.poto.common.api.command.meta.CommandMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleCommandManager implements CommandManager {

  private final Map<String, CommandMeta> commands = new ConcurrentHashMap<>();
  private final AnnotatedCommandBuilder commandBuilder;

  public SimpleCommandManager(
      AnnotatedCommandBuilder commandBuilder
  ) {
    this.commandBuilder = commandBuilder;
  }

  @Override public void registerCommand(CommandClass commandClass) {
    for (CommandMeta commandMeta : commandBuilder.fromClass(commandClass)) {
      commands.put(commandMeta.getNames().get(1), commandMeta);
    }
  }

  @Override public void unregisterCommand(String name) {
    commands.remove(name);
  }

  @Override public boolean isRegistered(String name) {
    return commands.containsKey(name);
  }

  @Override public List<CommandMeta> getRegisteredCommands() {
    return new ArrayList<>(commands.values());
  }
}
