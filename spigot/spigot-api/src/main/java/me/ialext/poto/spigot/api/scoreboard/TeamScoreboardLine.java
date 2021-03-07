package me.ialext.poto.spigot.api.scoreboard;

public class TeamScoreboardLine {

  private final String prefix;
  private final String suffix;

  public TeamScoreboardLine(String prefix,
                            String suffix) {
    this.prefix = prefix;
    this.suffix = suffix;
  }

  public String getPrefix() {
    return prefix;
  }

  public String getSuffix() {
    return suffix;
  }

}
