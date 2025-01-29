package com.github.io.marobim815.woodsVill.village

import org.bukkit.Location
import org.bukkit.entity.Player

data class Village(
    val villageName: String,
    val leader: Player,
    var numberOfCoreBreak: Int = 0,
    val coreLocation: MutableList<Location?> = mutableListOf(),
    val members: MutableList<Player> = mutableListOf(leader)
)