package me.ialext.spigot.core.scoreboard;

import me.ialext.poto.spigot.api.scoreboard.AbstractScoreboardPart;
import me.ialext.poto.spigot.api.scoreboard.TeamScoreboardLine;
import me.ialext.spigot.core.nms.NMSHelper;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;
import net.minecraft.server.v1_8_R3.ScoreboardTeam;
import org.bukkit.entity.Player;

import java.util.List;

public class LineScoreboardPart extends AbstractScoreboardPart<ScoreboardTeam> {

  private ScoreboardTeam scoreboardTeam;

  public LineScoreboardPart(List<TeamScoreboardLine> lines, int updateInterval) {
    super(lines, updateInterval);
  }

  @Override
  public void set(ScoreboardTeam scoreboardTeam) {
    this.scoreboardTeam = scoreboardTeam;
  }

  @Override
  public void send(Player player) {
    TeamScoreboardLine scoreboardLine = getCurrentLine();

    if (
        scoreboardLine.getPrefix().equalsIgnoreCase(scoreboardTeam.getPrefix())
        || scoreboardLine.getSuffix().equalsIgnoreCase(scoreboardTeam.getSuffix())
    ) {
      return;
    }

    scoreboardTeam.setPrefix(scoreboardLine.getPrefix());
    scoreboardTeam.setSuffix(scoreboardLine.getSuffix());
    NMSHelper.sendPacket(player, new PacketPlayOutScoreboardTeam(scoreboardTeam, 2));
  }
}
