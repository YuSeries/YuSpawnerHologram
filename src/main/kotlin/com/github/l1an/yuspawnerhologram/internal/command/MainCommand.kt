package com.github.l1an.yuspawnerhologram.internal.command

import com.github.l1an.yuspawnerhologram.internal.command.subcommand.CommandRefresh
import com.github.l1an.yuspawnerhologram.internal.command.subcommand.CommandReload
import taboolib.common.platform.ProxyCommandSender
import taboolib.common.platform.command.CommandBody
import taboolib.common.platform.command.CommandHeader
import taboolib.common.platform.command.mainCommand
import taboolib.expansion.createHelper

@CommandHeader(name = "yuspawnerhologram", aliases = ["spawnerholo", "mmholo"])
object MainCommand {
    @CommandBody
    val main = mainCommand {
        createHelper()
    }

    @CommandBody
    val reload = CommandReload

    @CommandBody
    val refresh = CommandRefresh
}