package me.ialext.spigot.core.nms;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public interface NMSHelper {

  static CraftPlayer getCraftPlayer(Player bukkitPlayer) {
    return (CraftPlayer) bukkitPlayer;
  }

  static EntityPlayer getEntityPlayer(Player bukkitPlayer) {
    return getCraftPlayer(bukkitPlayer).getHandle();
  }

  static PlayerConnection getPlayerConnection(Player bukkitPlayer) {
    return getEntityPlayer(bukkitPlayer).playerConnection;
  }

  static void sendPacket(Player bukkitPlayer,
                         Packet<?> packet) {
    getPlayerConnection(bukkitPlayer).sendPacket(packet);
  }

  static CraftWorld getCraftWorld(World bukkitWorld) {
    return (CraftWorld) bukkitWorld;
  }

  static WorldServer getNMSWorld(World bukkitWorld) {
    return getCraftWorld(bukkitWorld).getHandle();
  }

}
