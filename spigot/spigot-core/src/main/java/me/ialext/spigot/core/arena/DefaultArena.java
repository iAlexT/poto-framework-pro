package me.ialext.spigot.core.arena;

import me.ialext.poto.spigot.api.arena.Arena;
import org.bukkit.Location;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

// TODO: 6/3/21 Create load and unload logic.

/**
 * The default implementation of {@link Arena},
 * that may be used for mini-games that do not need
 * extra things like chests, and so on.
 */
public class DefaultArena implements Arena {

  private final String id;
  private final String displayName;
  private final int capacity;
  private final List<Location> spawnPoints = new ArrayList<>();
  private final Temporal temporal = new Temporal();

  @ConstructorProperties({
      "id",
      "displayName",
      "capacity"
  })
  public DefaultArena(String id,
                      String displayName,
                      int capacity) {
    this.id = id;
    this.displayName = displayName;
    this.capacity = capacity;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public int getCapacity() {
    return capacity;
  }

  @Override
  public List<Location> getSpawnPoints() {
    return spawnPoints;
  }

  @Override
  public Temporal getTemporal() {
    return temporal;
  }

  @Override
  public void load() {

  }

  @Override
  public void unload() {

  }
}
