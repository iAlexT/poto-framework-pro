package me.ialext.poto.common.core.command.meta;

import me.ialext.poto.common.api.command.meta.ParameterMeta;

import java.lang.annotation.Annotation;
import java.util.List;

public class ParameterMetaImpl implements ParameterMeta {

  private final String name;
  private final boolean optional;
  private final Class<?> type;
  private final List<? extends Annotation> modifiers;

  public ParameterMetaImpl(
      String name,
      boolean optional,
      Class<?> type,
      List<? extends Annotation> modifiers
  ) {
    this.name = name;
    this.optional = optional;
    this.type = type;
    this.modifiers = modifiers;
  }

  @Override public String getName() {
    return name;
  }

  @Override public boolean isOptional() {
    return optional;
  }

  @Override public Class<?> getType() {
    return type;
  }

  @Override public List<? extends Annotation> getModifiers() {
    return modifiers;
  }
}
