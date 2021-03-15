package me.ialext.poto.common.api.command.meta;

import me.ialext.poto.common.api.command.annotation.Command;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * Holds information about the
 * {@link Parameter} within a
 * {@link Command}.
 */
public interface ParameterMeta {

  /**
   * Gets the name of the {@link Parameter}.
   *
   * @return The {@link Parameter}'s name.
   */
  String getName();

  /**
   * Gets if the {@link Parameter}
   * is required for the execution.
   *
   * @return If the {@link Parameter} is optional.
   */
  boolean isOptional();

  /**
   * Gets the {@link Parameter} type.
   *
   * @return The {@link Parameter}'s type.
   */
  Class<?> getType();

  /**
   * Gets the modifier list of
   * the {@link Parameter}.
   *
   * @return The {@link Parameter} modifiers.
   */
  List<? extends Annotation> getModifiers();

}
