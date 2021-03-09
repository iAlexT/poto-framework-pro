package me.ialext.poto.spigot.plugin.service.initializer;

import me.ialext.poto.common.api.service.Service;
import me.ialext.poto.spigot.plugin.PotoTest;
import me.ialext.poto.spigot.plugin.listener.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class ListenerInitializer implements Service {

  private final PotoTest potoTest;

  public ListenerInitializer(PotoTest potoTest) {
    this.potoTest = potoTest;
  }

  @Override
  public void setup() {
    Bukkit.getLogger().info("Registering listeners...");
    registerListeners(
        new PlayerJoinListener()
    );
  }

  private void registerListeners(Listener... listeners) {
    for (Listener listener : listeners) {
      potoTest.getServer().getPluginManager().registerEvents(listener, potoTest);
    }
  }
}
