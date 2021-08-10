package klouvCowMilk;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import de.tr7zw.changeme.nbtapi.NBTEntity;


public class SpawnCow implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        if (args.length != 1) {
            sender.sendMessage("1 tane arg gir");
            return true;
        }
        String name = args[0];

        Player player = (Player) sender;

        Entity entity = player.getWorld().spawnEntity(player.getEyeLocation(), EntityType.COW);
        entity.setCustomName("Baba İnek");
        if (entity == null) return true;
        NBTEntity nbtInek = new NBTEntity(entity);
        nbtInek.setString("entityId", name);
        player.sendMessage("ineğin id si: " + name);
        return true;
    }
}
