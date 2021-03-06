package me.ialext.poto.spigot.api.match;

import me.ialext.poto.spigot.api.arena.Arena;

import java.util.List;
import java.util.UUID;

public interface Match {

  String getId();

  Arena getArena();

  // TODO: 6/3/21 Change this from UUID to User.
  List<UUID> getPlayers();

  // TODO: 6/3/21 Change this from UUID to User.
  List<UUID> getSpectators();

  Phase getCurrentPhase();

  enum Phase {

    IDLE,
    STARTING,
    PLAYING,
    RESTARTING,
    UNAVAILABLE

  }

}
