package com.github.l1an.yuspawnerhologram.internal.command.subcommand

import com.github.l1an.artisan.lang.LanguageType
import com.github.l1an.artisan.lang.sendLang
import com.github.l1an.yuspawnerhologram.api.event.PluginReloadEvent
import com.github.l1an.yuspawnerhologram.internal.config.YuSpawnerHologramConfig
import com.github.l1an.yuspawnerhologram.internal.core.mythichologram.HologramEnter
import com.github.l1an.yuspawnerhologram.internal.manager.ConfigManager
import com.github.l1an.yuspawnerhologram.module.adyeshach.AdyeshachHologram
import com.github.l1an.yuspawnerhologram.module.decentholograms.DecentHologram
import com.github.l1an.yuspawnerhologram.module.holographicdisplays.HolographicHologram
import com.github.l1an.yuspawnerhologram.util.Utils
import org.bukkit.command.CommandSender
import taboolib.common.platform.command.subCommand

val CommandReload = subCommand {
    execute<CommandSender> { sender, _, _ ->
        val keys = Utils.getConfigKeys(YuSpawnerHologramConfig.config, "hologramText")
        for (spawnerName in keys) {
            when {
                HologramEnter.adyeshach != null -> AdyeshachHologram.refreshHologramByADY(spawnerName, sender)
                HologramEnter.decentHolograms != null -> DecentHologram.refreshHologramByDH(spawnerName, sender)
                HologramEnter.holographicDisplays != null -> HolographicHologram.refreshHologramByHD(spawnerName, sender)

                else -> sender.sendLang("dependency-not-found", type = LanguageType.Error)
            }
        }
        sender.sendLang("command-reload", type = LanguageType.Done)
        ConfigManager.reload()
        PluginReloadEvent().call()
    }
}