package com.github.io.marobim815.woodsVill.core

import com.github.io.marobim815.woodsVill.village.VillageManager
import org.bukkit.Material
import org.bukkit.entity.Player

object CoreManager {
    fun upgradeCoreBlock(player: Player): Material? {
        val coreLevel = VillageManager.getVillageByPlayer(player)?.numberOfCoreBreak
        return when (coreLevel) {
            0 -> Material.DIAMOND_BLOCK
            1 -> Material.NETHERITE_BLOCK
            2 -> Material.WITHER_SKELETON_WALL_SKULL
            else -> null
        }
    }
}