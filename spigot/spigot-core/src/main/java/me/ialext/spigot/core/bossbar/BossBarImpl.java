package me.ialext.spigot.core.bossbar;

import me.ialext.poto.spigot.api.bossbar.BossBar;
import me.ialext.spigot.core.nms.NMSHelper;
import net.minecraft.server.v1_8_R3.EntityWither;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class BossBarImpl implements BossBar {

  private final Player player;
  private final Location location;
  private final List<String> lines;
  private final int updateInterval;
  private Color color;

  public BossBarImpl(Player player,
                     Location location,
                     List<String> lines,
                     int updateInterval,
                     Color color) {
    this.player = player;
    this.location = location;
    this.lines = lines;
    this.updateInterval = updateInterval;
    this.color = color;
    initialize();
  }

  @Override
  public Player getPlayer() {
    return player;
  }

  @Override
  public Location getLocation() {
    return location;
  }

  @Override
  public List<String> getLines() {
    return lines;
  }

  @Override
  public int getUpdateInterval() {
    return updateInterval;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  private void initialize() {
    EntityWither entityWither = new EntityWither(NMSHelper.getNMSWorld(location.getWorld()));
    entityWither.setCustomName(lines.get(1));
    entityWither.setInvisible(true);
    entityWither.k(true);
    entityWither.teleportTo(location, false);

    Packet<?> packet = new PacketPlayOutSpawnEntityLiving(entityWither);
    NMSHelper.sendPacket(player, packet);
  }
}
