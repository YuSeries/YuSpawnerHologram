package com.github.l1an.yuspawnerhologram.internal.util

import com.github.l1an.yuspawnerhologram.internal.compat.hook.HookMythicMobs.getSpawnerManager
import com.github.l1an.yuspawnerhologram.internal.config.YuSpawnerHologramConfig.config
import com.github.l1an.yuspawnerhologram.util.TimeUtils.secondToFormat
import ink.ptms.um.Mythic

object MythicHologramUtils {
    /**
     * 从 MythicMobs 的配置文件中获取怪物的显示名
     * @param id 怪物的索引名
     * @return 怪物的显示名
     * @author L1An
     * @since 2023/10/23
     */
    fun getDisplayNameFromConfigs(id : String) : String? {
        val mob = Mythic.API.getMobType(id) ?: return null
        return mob.displayName
    }

    fun getSpawnerWarmupTextForPAPI(name : String) : String? {
        val spawnerManager = getSpawnerManager(name) ?: return null
        val warmup = spawnerManager.remainingWarmupSeconds
        val second = secondToFormat(config, warmup, "durationFormat")

        val activeMsg : String = config.getString("papiText.${name}.running")!!.replace("&", "§")
        val secondMsg : String = config.getString("papiText.${name}.waiting")!!
            .replace("&", "§")
            .replace("%warmup%", second)

        return if (!spawnerManager.isOnWarmup) {
            activeMsg
        } else {
            secondMsg
        }
    }
}