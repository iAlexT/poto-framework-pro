package me.ialext.poto.spigot.api.arena;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.ialext.poto.cache.model.SavableModel;
import org.bukkit.Location;

import java.util.List;

public interface Arena extends SavableModel {

  /**
   * Gets the display name of this
   * {@link Arena}, that will be used,
   * for example, in a menu.
   *
   * @return The display name.
   */
  @JsonProperty("displayName")
  String getDisplayName();

  /**
   * Gets the maximum capacity of this
   * {@link Arena}, which defines the
   * amount of players that be holden.
   *
   * @return The capacity.
   */
  @JsonProperty("capacity")
  int getCapacity();

  /**
   * Gets all the spawn points
   * of this {@link Arena}.
   *
   * @return The all spawn points.
   */
  @JsonProperty("spawnPoints")
  List<Location> getSpawnPoints();

  /**
   * Gets the temporal information
   * of this {@link Arena}.
   *
   * @return The temporal information.
   */
  @JsonIgnore
  Temporal getTemporal();

  void load();

  void unload();

  enum Phase {

    IDLE,
    STARTING,
    PLAYING,
    RESTARTING,
    UNAVAILABLE

  }

  /**
   * Holds temporal information of this
   * {@link Arena}.
   */
  class Temporal {

    private boolean occupied;
    private Phase phase;

    public boolean isOccupied() {
      return occupied;
    }

    public void setOccupied(boolean occupied) {
      this.occupied = occupied;
    }

    public Phase getPhase() {
      return phase;
    }

    public void setPhase(Phase phase) {
      this.phase = phase;
    }

  }

}
