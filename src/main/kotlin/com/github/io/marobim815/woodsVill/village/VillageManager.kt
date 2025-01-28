package com.github.io.marobim815.woodsVill.village

import com.sun.jdi.Location
import org.bukkit.entity.Player

object VillageManager {
    val villages = mutableListOf<Village?>()

    fun addVillage(leader: Player, villageName: String): Boolean {
        if (villages.any { it?.leader == leader } && villages.any { it?.villageName == villageName }) return false
        villages.add(Village(leader = leader, villageName = villageName))
        return true
    }

    fun isPlayerInVillage(player: Player): Boolean = villages.any { it?.members?.contains(player)!! }

    fun getVillageByLeader(leader: Player): Village? = villages.find { it?.leader == leader }

    fun getVillageByPlayer(player: Player): Village? = villages.find { it?.members?.contains(player)!! }

    fun isLeader(player: Player): Boolean = villages.any { it?.leader == player }

    fun addVillageLocation(leader: Player, location: Location) {
        val village = getVillageByLeader(leader)
        village?.coreLocation?.add(location)
    }

}