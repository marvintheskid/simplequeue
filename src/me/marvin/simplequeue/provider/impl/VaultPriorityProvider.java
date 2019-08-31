package me.marvin.simplequeue.provider.impl;

import me.marvin.simplequeue.provider.QueuePriorityProvider;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class VaultPriorityProvider implements QueuePriorityProvider<Player> {
    @Override
    public String getProviderName() {
        return "Vault";
    }

    @Override
    public int getEntryPriority(Player player) {
        return 0;
    }
}
