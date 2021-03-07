package me.ialext.spigot.core.scoreboard;

import me.ialext.poto.spigot.api.scoreboard.AbstractScoreboardPart;
import me.ialext.poto.spigot.api.scoreboard.TeamScoreboardLine;
import me.ialext.spigot.core.nms.NMSHelper;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import org.bukkit.entity.Player;

import java.util.List;

public class TitleScoreboardPart extends AbstractScoreboardPart<ScoreboardObjective> {

  private ScoreboardObjective scoreboardObjective;

  public TitleScoreboardPart(List<TeamScoreboardLine> lines, int updateInterval) {
    super(lines, updateInterval);
  }

  @Override
  public void set(ScoreboardObjective scoreboardObjective) {
    this.scoreboardObjective = scoreboardObjective;
  }

  @Override
  public void send(Player player) {
    String line = getCurrentLine().getPrefix() + getCurrentLine().getSuffix();

    if (line.equalsIgnoreCase(scoreboardObjective.getDisplayName())) {
      return;
    }

    scoreboardObjective.setDisplayName(line);
    NMSHelper.sendPacket(player, new PacketPlayOutScoreboardObjective(scoreboardObjective, 2));
  }
}
