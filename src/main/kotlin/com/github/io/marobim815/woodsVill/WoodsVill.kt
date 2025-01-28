package com.github.io.marobim815.woodsVill

import com.github.io.marobim815.woodsVill.event.EventListener
import org.bukkit.plugin.java.JavaPlugin

class WoodsVill : JavaPlugin() {

    override fun onEnable() {
        logger.info("우즈빌 플러그인 활성화")
        server.pluginManager.registerEvents(EventListener, this)
    }

    override fun onDisable() {
        logger.info("우즈빌 플러그인 비활성화")
    }
}
