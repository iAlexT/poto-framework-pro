package me.ialext.spigot.core.bossbar;

import me.ialext.poto.spigot.api.bossbar.BossBar;
import me.ialext.poto.spigot.api.bossbar.BossBarBuilder;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SimpleBossBarBuilder implements BossBarBuilder {

  private Player player;
  private Location location;
  private final List<String> lines = new ArrayList<>();
  private int updateInterval;
  private BossBar.Color color;

  @Override
  public BossBarBuilder player(Player player) {
    this.player = player;

    return this;
  }

  @Override
  public BossBarBuilder location(Location location) {
    this.location = location;

    return this;
  }

  @Override
  public BossBarBuilder addLine(String line) {
    lines.add(line);

    return this;
  }

  @Override
  public BossBarBuilder updateInterval(int updateInterval) {
    this.updateInterval = updateInterval;

    return this;
  }

  @Override
  public BossBarBuilder color(BossBar.Color color) {
    this.color = color;

    return this;
  }

  @Override
  public BossBar build() {
    return new BossBarImpl(
        player,
        location,
        lines,
        updateInterval,
        color
    );
  }
}
