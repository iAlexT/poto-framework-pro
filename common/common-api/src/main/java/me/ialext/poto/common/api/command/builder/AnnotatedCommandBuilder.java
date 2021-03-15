package me.ialext.poto.common.api.command.builder;

import me.ialext.poto.common.api.command.CommandClass;
import me.ialext.poto.common.api.command.meta.CommandMeta;
import me.ialext.poto.common.api.command.meta.ParameterMeta;

import java.util.List;

public interface AnnotatedCommandBuilder {

  CommandMeta build(
      List<String> names,
      String permission,
      String description,
      String usage,
      List<ParameterMeta> parametersMeta
  );

  List<CommandMeta> fromClass(CommandClass commandClass);

}
