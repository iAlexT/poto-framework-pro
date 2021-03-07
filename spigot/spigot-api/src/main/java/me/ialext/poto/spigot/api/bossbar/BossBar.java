package me.ialext.poto.spigot.api.bossbar;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * A packet-based BossBar.
 */
public interface BossBar {

  Player getPlayer();

  Location getLocation();

  List<String> getLines();

  int getUpdateInterval();

  Color getColor();

  void setColor(Color color);

  enum Color {

    PINK,
    BLUE,
    RED,
    GREEN,
    YELLOW,
    PURPLE,
    WHITE,
    DEFAULT

  }

}
