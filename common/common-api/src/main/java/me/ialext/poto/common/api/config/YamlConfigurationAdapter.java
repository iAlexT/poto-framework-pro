package me.ialext.poto.cache.config;

import java.util.List;

/**
 * This interface holds common methods between
 * Spigot and BungeeCord's YAML configuration to make
 * it more common.
 *
 * @param <P> The plugin type.
 */
public interface YamlConfigurationAdapter<P> {

  P getPluginType();

  String getString(String path, String def);

  boolean getBoolean(String path, boolean def);

  int getInt(String path, int def);

  double getDouble(String path, double def);

  float getFloat(String path, float def);

  long getLong(String path, long def);

  List<String> getStringList(String path, List<String> def);

}
