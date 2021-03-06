package me.ialext.spigot.core.match;

import me.ialext.poto.spigot.api.arena.Arena;
import me.ialext.poto.spigot.api.match.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MatchImpl implements Match {

  private final String id;
  private final Arena arena;
  private final List<UUID> players = new ArrayList<>();
  private final List<UUID> spectators = new ArrayList<>();
  private Phase currentPhase;

  public MatchImpl(String id,
                   Arena arena) {
    this.id = id;
    this.arena = arena;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public Arena getArena() {
    return arena;
  }

  @Override
  public List<UUID> getPlayers() {
    return players;
  }

  @Override
  public List<UUID> getSpectators() {
    return spectators;
  }

  @Override
  public Phase getCurrentPhase() {
    return currentPhase;
  }
}
