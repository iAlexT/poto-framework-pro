package me.ialext.poto.spigot.plugin;

import me.ialext.poto.common.api.service.Service;
import me.ialext.poto.spigot.plugin.service.PotoTestService;
import org.bukkit.plugin.java.JavaPlugin;

public class PotoTest extends JavaPlugin {

  private final Service service = new PotoTestService(this);

  @Override
  public void onEnable() {
    service.setup();
  }

}
