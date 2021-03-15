package me.ialext.poto.common.api.command.meta;

import java.util.List;

public interface CommandMeta {

  /**
   * Gets the name and aliases of
   * this command.
   *
   * @return All the names.
   */
  List<String> getNames();

  /**
   * Gets the description of
   * this command.
   *
   * @return The description.
   */
  String getDescription();

  /**
   * Gets the usage of this command.
   *
   * @return The usage.
   */
  String getUsage();

  List<ParameterMeta> getParametersMeta();

  String getPermission();
}
