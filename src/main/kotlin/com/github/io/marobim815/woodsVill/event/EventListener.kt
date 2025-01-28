package com.github.io.marobim815.woodsVill.event

import com.github.io.marobim815.woodsVill.core.CoreManager
import com.github.io.marobim815.woodsVill.village.VillageManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

object EventListener: Listener {
    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        val player = event.player
        val block = event.block

        if (CoreManager.upgradeCoreBlock(player) != null) {
            if (VillageManager.isPlayerInVillage(player) && VillageManager.isLeader(player)) return // TODO
        }
    }
}