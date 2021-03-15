package me.ialext.poto.common.api.command.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * If present in a {@link Method},
 * indicates is intended to handle the
 * execution of a {@link Command},
 * otherwise, means that will act
 * as parent of the subcommand methods.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Command {

  String[] names();

  String permission() default "";

  String description();

  String usage() default "[internal]";

}
