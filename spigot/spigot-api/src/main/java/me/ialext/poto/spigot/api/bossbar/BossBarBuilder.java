package me.ialext.poto.spigot.api.bossbar;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface BossBarBuilder {

  BossBarBuilder player(Player player);

  BossBarBuilder location(Location location);

  BossBarBuilder addLine(String line);

  BossBarBuilder updateInterval(int updateInterval);

  BossBarBuilder color(BossBar.Color color);

  BossBar build();

}
