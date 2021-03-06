package me.ialext.poto.spigot.api.arena;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.ialext.poto.common.api.model.SavableModel;
import me.ialext.poto.spigot.api.match.Match;
import org.bukkit.Location;

import java.util.List;
import java.util.Optional;

/**
 * An arena is a place where {@link Match}es can be disputed.
 */
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

  /**
   * Holds temporal information of this
   * {@link Arena}.
   */
  class Temporal {

    private boolean occupied;
    private Match match;

    public boolean isOccupied() {
      return occupied;
    }

    public void setOccupied(boolean occupied) {
      this.occupied = occupied;
    }

    public Optional<Match> getMatch() {
      return Optional.ofNullable(match);
    }

    public void setMatch(Match match) {
      this.match = match;
    }

  }

}
