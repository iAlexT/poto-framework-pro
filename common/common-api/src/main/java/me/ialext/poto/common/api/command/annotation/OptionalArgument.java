package me.ialext.poto.common.api.command.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Parameter;

/**
 * Indicates that a {@link Parameter}
 * within a {@link Command} method is
 * not required for the execution,
 * and can be omitted.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface OptionalArgument {
}
