package com.github.io.marobim815.woodsVill.village

import org.bukkit.Location
import org.bukkit.entity.Player

object VillageManager {
    val villages = mutableListOf<Village>()

    fun addVillage(leader: Player, villageName: String): Boolean {
        // 중복 검사
        if (villages.any { it.leader == leader || it.villageName == villageName }) return false

        villages.add(Village(leader = leader, villageName = villageName))
        return true
    }

    fun isPlayerInVillage(player: Player): Boolean =
        getVillageByPlayer(player) != null  // 중복 로직 제거

    fun getVillageByLeader(leader: Player): Village? =
        villages.find { it.leader == leader }

    fun getVillageByPlayer(player: Player): Village? =
        villages.find { it.members.contains(player) }

    fun isLeader(player: Player): Boolean =
        villages.any { it.leader == player }

    fun addVillageLocation(leader: Player, location: Location) {
        val village = getVillageByLeader(leader)
        village?.coreLocation?.add(location)
    }
}