package klouvCowMilk;

import klouvCowMilk.Listener.CowMilkListener;
import klouvCowMilk.file.ConfigFile;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CowMilk extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new CowMilkListener(), this);
        getCommand("spawnCow").setExecutor(new SpawnCow());


    }


    @Override
    public void onDisable() {


    }
}
