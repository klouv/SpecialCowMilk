package klouvCowMilk.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import de.tr7zw.changeme.nbtapi.NBTEntity;
import de.tr7zw.changeme.nbtapi.NBTItem;

import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;


public class CowMilkListener implements Listener {
    @EventHandler
    public void onClikEntity(PlayerInteractAtEntityEvent event) {

        if (!(event.getRightClicked().getType() == EntityType.COW)) return;
        Entity  inek = event.getRightClicked();
        if (inek == null) return;
        NBTEntity inekEntity = new NBTEntity(inek);

        if (!(inekEntity.hasKey("entityId"))) return;
        ItemStack sut = new ItemStack(Material.MILK_BUCKET);
        NBTItem nbtsut = new NBTItem(sut);
        nbtsut.setString("entityId", inekEntity.getString("entityId"));

        ItemStack item = nbtsut.getItem();
        Player player = event.getPlayer();
        player.getWorld().dropItem(player.getLocation(), item);
        player.sendMessage("item verildi");
    }
    @EventHandler
    public void onDrinkMilk(PlayerItemConsumeEvent event) {
        if (!(event.getItem().getItemMeta().getDisplayName() == Material.MILK_BUCKET.getData().getName())) return;
        NBTItem nbticilen = new NBTItem(event.getItem());

        if (!(nbticilen.hasKey("entityId"))) return;
        event.getPlayer().getInventory().addItem(new ItemStack(Material.GOLD_INGOT));

    }



}
