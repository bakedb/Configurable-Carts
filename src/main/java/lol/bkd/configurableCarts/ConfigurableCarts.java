package lol.bkd.configurableCarts;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.entity.Explosive;
import org.bukkit.entity.minecart.ExplosiveMinecart;

public final class ConfigurableCarts extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new MinecartListener(), this);
    }

    public class MinecartListener implements Listener {
        @EventHandler
        public void onExplosionPrime(ExplosionPrimeEvent event) {
            double yield = ConfigurableCarts.this.getConfig().getDouble("explosion-yield");
            if (event.getEntityType() == EntityType.TNT_MINECART) {
                event.setRadius((float) yield);
            }
        }
    }
}