package com.minecraft.launcher

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class LauncherPreferences(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("launcher_prefs", Context.MODE_PRIVATE)

    fun save(
        playerName: String,
        javaPath: String,
        javaArgs: String,
        serverIp: String,
        serverPort: Int,
        memoryMb: Int
    ) {
        prefs.edit {
            putString("player_name", playerName)
            putString("java_path", javaPath)
            putString("java_args", javaArgs)
            putString("server_ip", serverIp)
            putInt("server_port", serverPort)
            putInt("memory_mb", memoryMb)
        }
    }

    fun getPlayerName(): String = prefs.getString("player_name", "Steve") ?: "Steve"
    fun getJavaPath(): String = prefs.getString("java_path", "/system/bin/java") ?: "/system/bin/java"
    fun getJavaArgs(): String = prefs.getString("java_args", "-Xmx2048M") ?: "-Xmx2048M"
    fun getServerIp(): String = prefs.getString("server_ip", "mc.sunucum.com") ?: "mc.sunucum.com"
    fun getServerPort(): Int = prefs.getInt("server_port", 25565)
    fun getMemoryMb(): Int = prefs.getInt("memory_mb", 2048)
}
