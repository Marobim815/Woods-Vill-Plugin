package com.github.io.marobim815.woodsVill.event

import com.github.io.marobim815.woodsVill.core.CoreManager
import com.github.io.marobim815.woodsVill.village.VillageManager
import net.kyori.adventure.text.Component.text
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent

object EventListener: Listener {
    @EventHandler
    fun onBlockPlace(event: BlockPlaceEvent) {
        val player = event.player
        val block = event.block
        val blockLocation = block.location
        val coreBlock = CoreManager.setCoreBlock(player) ?: return

        if (player.inventory.itemInMainHand.type == coreBlock) {
            if (VillageManager.isPlayerInVillage(player)) {
                if (player.name == "MaRoBim815") { //todo: 마을 범위 체크
                    if (VillageManager.addVillageLocation(player, blockLocation)) {
                        VillageManager.addVillageLocation(player, blockLocation)
                        CoreManager.spawnCoreEntity(player, blockLocation)
                    } else {
                        player.sendMessage(text("여기에 마을을 생성할 수 없습니다!"))
                        event.isCancelled = true
                    }
                }
            }
        }
    }
}