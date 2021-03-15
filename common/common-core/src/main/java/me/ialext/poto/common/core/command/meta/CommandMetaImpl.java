package me.ialext.poto.common.core.command.meta;

import me.ialext.poto.common.api.command.meta.CommandMeta;
import me.ialext.poto.common.api.command.meta.ParameterMeta;

import java.util.List;

public class CommandMetaImpl implements CommandMeta {

  private final List<String> names;
  private final String permission;
  private final String description;
  private final String usage;
  private final List<ParameterMeta> parametersMeta;

  public CommandMetaImpl(
      List<String> names,
      String permission,
      String description,
      String usage,
      List<ParameterMeta> parameterMetas
  ) {
    this.names = names;
    this.permission = permission;
    this.description = description;
    this.usage = usage;
    this.parametersMeta = parameterMetas;
  }

  @Override public List<String> getNames() {
    return names;
  }

  @Override public String getDescription() {
    return description;
  }

  @Override public String getUsage() {
    return usage;
  }

  @Override public List<ParameterMeta> getParametersMeta() {
    return parametersMeta;
  }

  @Override public String getPermission() {
    return permission;
  }
}
