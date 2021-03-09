package me.ialext.poto.spigot.plugin.service;

import me.ialext.poto.common.api.service.Service;
import me.ialext.poto.spigot.plugin.PotoTest;
import me.ialext.poto.spigot.plugin.service.initializer.CommandInitializer;
import me.ialext.poto.spigot.plugin.service.initializer.ListenerInitializer;
import org.bukkit.Bukkit;

public class PotoTestService implements Service {

  private final Service commandInitializer;
  private final Service listenerInitializer;

  public PotoTestService(PotoTest potoTest) {
     commandInitializer = new CommandInitializer(potoTest);
     listenerInitializer  = new CommandInitializer(potoTest);
  }

  @Override
  public void setup() {
    Bukkit.getLogger().info("[PotoFrameworkPro] Starting main service...");
    commandInitializer.setup();
    listenerInitializer.setup();
  }
}
