package me.ialext.poto.spigot.api.scoreboard;

import org.bukkit.entity.Player;

import java.util.List;

public abstract class AbstractScoreboardPart<T> {

  private final List<TeamScoreboardLine> lines;
  private final int updateInterval;
  private int currentTick = 0;
  private int index = 0;

  public AbstractScoreboardPart(List<TeamScoreboardLine> lines,
                                int updateInterval) {
    this.lines = lines;
    this.updateInterval = updateInterval;
  }

  public TeamScoreboardLine getCurrentLine() {
    return (lines.size() == 0) ? new TeamScoreboardLine("", "") : lines.get(index++ % lines.size());
  }

  public abstract void set(T t);

  public void onTick(Player player) {
    if (++currentTick < updateInterval) {
      return;
    }

    currentTick = 0;
    send(player);
  }

  public abstract void send(Player player);

}
