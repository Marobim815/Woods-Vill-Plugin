package com.github.io.marobim815.woodsVill.core

import com.github.io.marobim815.woodsVill.village.VillageManager
import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.BlockDisplay
import org.bukkit.entity.Interaction
import org.bukkit.entity.Player

object CoreManager {
    fun setCoreBlock(player: Player): Material? {
        val coreLevel = VillageManager.getVillageByPlayer(player)?.numberOfCoreBreak
        return when (coreLevel) {
            0 -> Material.DIAMOND_BLOCK
            1 -> Material.NETHERITE_BLOCK
            2 -> Material.WITHER_SKELETON_WALL_SKULL
            else -> null
        }
    }

    fun spawnCoreEntity(player: Player, location: Location) {
        val world = location.world ?: return
        if (!VillageManager.isPlayerInVillage(player) && !VillageManager.isLeader(player)) return
        val playerVillage = VillageManager.getVillageByPlayer(player) ?: return
        val coreBlock = setCoreBlock(player) ?: return

        world.spawn(location, Interaction::class.java) {
            it.customName(Component.text("${playerVillage.villageName}마을의 심장"))
            it.isCustomNameVisible = true
        }

        world.spawn(location, BlockDisplay::class.java) {
            it.block = coreBlock.createBlockData()
        }
    }

}