package me.ialext.poto.spigot.plugin.listener;

import me.ialext.poto.spigot.api.menu.Menu;
import me.ialext.spigot.core.item.SimpleItemBuilder;
import me.ialext.spigot.core.menu.builder.DefaultMenuBuilder;
import me.ialext.spigot.core.menu.item.ClickableItemBuilderImpl;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event) {
    Player player = event.getPlayer();
    Menu menu = new DefaultMenuBuilder()
        .title("Test menu")
        .rows(3)
        .addItem(
            new ClickableItemBuilderImpl()
                .itemStack(
                    new SimpleItemBuilder()
                        .material(Material.ANVIL)
                        .name("pot")
                        .lore("Ola", "I", "io")
                        .amount(1)
                        .build()
                )
            .clickAction(event1 -> true)
            .build()
        )
        .openAction(inventoryOpenEvent -> {
          player.sendMessage("ola");

          return true;
        })
        .build();
    player.openInventory(menu.getInventory());
  }
}
