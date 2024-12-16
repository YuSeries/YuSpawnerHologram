package com.github.l1an.yuspawnerhologram

import com.github.l1an.artisan.feature.setInfoPrefix
import com.github.l1an.artisan.feature.update.SpigotUpdateChecker
import com.github.l1an.artisan.utils.sendEnableInfo
import io.lumine.mythic.bukkit.MythicBukkit
import org.bukkit.Bukkit
import taboolib.common.platform.Platform
import taboolib.common.platform.Plugin
import taboolib.module.metrics.Metrics
import taboolib.platform.BukkitPlugin

object YuSpawnerHologram : Plugin() {

    val mythicBukkit: MythicBukkit by lazy {
        val mythicMobsPlugin = Bukkit.getPluginManager().getPlugin("MythicMobs")
        mythicMobsPlugin as MythicBukkit
    }

    val messagePrefix = "&f[ &5YuSpawnerHologram &f]"

    override fun onEnable() {
        setInfoPrefix(messagePrefix)
        Metrics(20123, BukkitPlugin.getInstance().description.version, Platform.BUKKIT)

        sendEnableInfo()

        // 检查更新
        SpigotUpdateChecker(113207).check()
    }
}