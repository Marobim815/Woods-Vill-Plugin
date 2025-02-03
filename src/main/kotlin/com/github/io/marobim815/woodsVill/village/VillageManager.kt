package com.github.io.marobim815.woodsVill.village

import org.bukkit.Location
import org.bukkit.entity.Player

object VillageManager {
    val villages = mutableListOf<Village>()

    fun addVillage(leader: Player, villageName: String): Boolean {

        if (villages.any { it.leader == leader || it.villageName == villageName }) return false

        villages.add(Village(leader = leader, villageName = villageName))
        return true
    }

    fun deleteVillage(village: Village?) {
        if (village == null) return
        if (!villages.contains(village)) return
        villages.remove(village)
    }


    fun combineVillage(village1: Village?, village2: Village?) {

    }

    fun isPlayerInVillage(player: Player): Boolean =
        getVillageByPlayer(player) != null

    fun getVillageByLeader(leader: Player): Village? =
        villages.find { it.leader == leader }

    fun getVillageByPlayer(player: Player): Village? =
        villages.find { it.members.contains(player) }

    fun isLeader(player: Player): Boolean =
        villages.any { it.leader == player }

    fun addVillageLocation(leader: Player, location: Location): Boolean {
        if (!isLeader(leader)) return false
        val village = getVillageByLeader(leader)
        village?.coreLocation?.add(location)
        return true
    }
}