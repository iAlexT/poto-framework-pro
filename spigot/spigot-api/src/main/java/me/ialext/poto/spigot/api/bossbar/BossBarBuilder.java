package me.ialext.poto.spigot.api.bossbar;

import me.ialext.poto.common.api.builder.Builder;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public interface BossBarBuilder extends Builder<BossBar> {

  BossBarBuilder player(Player player);

  BossBarBuilder location(Location location);

  BossBarBuilder addLine(String line);

  BossBarBuilder updateInterval(int updateInterval);

  BossBarBuilder color(BossBar.Color color);

}
