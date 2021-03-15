package me.ialext.poto.common.core.command.builder;

import me.ialext.poto.common.api.command.CommandClass;
import me.ialext.poto.common.api.command.annotation.Command;
import me.ialext.poto.common.api.command.annotation.OptionalArgument;
import me.ialext.poto.common.api.command.builder.AnnotatedCommandBuilder;
import me.ialext.poto.common.api.command.meta.CommandMeta;
import me.ialext.poto.common.api.command.meta.ParameterMeta;
import me.ialext.poto.common.core.command.meta.CommandMetaImpl;
import me.ialext.poto.common.core.command.meta.ParameterMetaImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnotatedCommandBuilderImpl implements AnnotatedCommandBuilder {

  @Override public CommandMeta build(
      List<String> names,
      String permission,
      String description,
      String usage,
      List<ParameterMeta> parametersMeta
  ) {
    return new CommandMetaImpl(
        names,
        permission,
        description,
        usage,
        parametersMeta
    );
  }

  @Override public List<CommandMeta> fromClass(CommandClass commandClass) {
    Class<? extends CommandClass> clazz = commandClass.getClass();

    List<CommandMeta> foundCommands = new ArrayList<>();

    for (Method method : clazz.getDeclaredMethods()) {
      List<ParameterMeta> parametersMeta = new ArrayList<>();
      if (method.isAnnotationPresent(Command.class)) {
        for (Parameter parameter : method.getParameters()) {
          parametersMeta.add(
              new ParameterMetaImpl(
                  parameter.getName(),
                  parameter.isAnnotationPresent(OptionalArgument.class),
                  parameter.getType(),
                  Arrays.asList(parameter.getAnnotations())
              )
          );
        }
        Command command = method.getAnnotation(Command.class);

        CommandMeta commandMeta = new CommandMetaImpl(
            Arrays.asList(command.names()),
            command.permission(),
            command.description(),
            command.usage(),
            parametersMeta
        );
        foundCommands.add(commandMeta);
      }
    }

    return foundCommands;
  }
}
