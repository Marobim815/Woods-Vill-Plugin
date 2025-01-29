package com.github.io.marobim815.woodsVill.core

import com.github.io.marobim815.woodsVill.village.VillageManager
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.EntityType
import org.bukkit.entity.Interaction
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

    fun spawnCoreEntity(player: Player, location: Location) {
        val world = location.world ?: return  // 월드가 null이면 종료
        if (!VillageManager.isPlayerInVillage(player) && !VillageManager.isLeader(player)) return
        val interaction = world.spawnEntity(location, EntityType.INTERACTION) as Interaction
        val playerVillage = VillageManager.getVillageByPlayer(player)
        // 엔티티 커스터마이징
        interaction.isInvulnerable = true  // 코어 엔티티 무적 상태
        interaction.customName = "${playerVillage?.villageName}마을의 심장"  // 엔티티 이름 설정
        interaction.isCustomNameVisible = true  // 이름이 보이도록 설정

    }

}