package me.ialext.spigot.core.user;

import me.ialext.poto.spigot.api.user.User;

import java.beans.ConstructorProperties;
import java.util.Calendar;

public class UserImpl implements User {

  private final String id;
  private int coins;
  private int kills;
  private int deaths;
  private final Calendar time;
  private final Temporal temporal = new Temporal();

  @ConstructorProperties({"id", "time"})
  public UserImpl(String id,
                  Calendar time) {
    this.id = id;
    this.time = time;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public int getCoins() {
    return coins;
  }

  @Override
  public int getKills() {
    return kills;
  }

  @Override
  public int getDeaths() {
    return deaths;
  }

  @Override
  public Calendar getTime() {
    return time;
  }

  @Override
  public Temporal getTemporal() {
    return temporal;
  }
}
