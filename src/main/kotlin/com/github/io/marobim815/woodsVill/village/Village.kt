package com.github.io.marobim815.woodsVill.village

import com.sun.jdi.Location
import org.bukkit.entity.Player

data class Village(
    val villageName: String,
    val leader: Player,
    val coreLocation: MutableList<Location?> = mutableListOf(),
    val members: MutableList<Player> = mutableListOf(leader),
    val numberOfCoreBreak: Int = 0
)