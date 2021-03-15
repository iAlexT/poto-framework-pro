package me.ialext.poto.spigot.api.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import me.ialext.poto.common.api.model.SavableModel;
import me.ialext.poto.spigot.api.match.Match;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

public interface User extends SavableModel {

  @JsonProperty("coins")
  int getCoins();

  @JsonProperty("kills")
  int getKills();

  @JsonProperty("deaths")
  int getDeaths();

  @JsonProperty("time")
  Calendar getTime();

  @JsonIgnore
  Temporal getTemporal();

  @JsonIgnore
  default Player getPlayer() {
    return Bukkit.getPlayer(UUID.fromString(getId()));
  }

  class Temporal {

    private boolean playing;
    private Match match;

    public Optional<Match> getMatch() {
      return Optional.ofNullable(match);
    }

    public void setMatch(Match match) {
      this.match = match;
    }

    public boolean isPlaying() {
      return playing;
    }

    public void setPlaying(boolean playing) {
      this.playing = playing;
    }

  }
}
