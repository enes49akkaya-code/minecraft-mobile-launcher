package com.minecraft.launcher

import android.util.Log
import java.io.File

object MinecraftLauncher {

    data class LaunchResult(val isSuccess: Boolean, val message: String)

    fun startGame(
        javaPath: String,
        javaArgs: String,
        playerName: String,
        serverIp: String,
        serverPort: Int,
        memoryMb: Int
    ): LaunchResult {
        val resolvedJava = javaPath.ifBlank { "/system/bin/java" }

        val minecraftJar = File("/storage/emulated/0/.minecraft/versions/latest/minecraft.jar")
        if (!minecraftJar.exists()) {
            return LaunchResult(false, "Minecraft JAR bulunamadı. Java yolu ve oyun klasörü kontrol edilmeli.")
        }

        val command = buildList {
            add(resolvedJava)
            add("-Xmx${memoryMb}M")
            add("-Xms256M")
            addAll(javaArgs.split(Regex("\\s+")))
            add("-cp")
            add(minecraftJar.absolutePath)
            add("net.minecraft.client.main.Main")
            add("--username")
            add(playerName)
            add("--server")
            add(serverIp)
            add("--port")
            add(serverPort.toString())
        }

        return try {
            val process = ProcessBuilder(command)
                .redirectErrorStream(true)
                .start()

            Log.d("MinecraftLauncher", "Launcher start command: ${command.joinToString(" ")}")
            Thread.sleep(400)
            val running = process.isAlive

            if (running) {
                LaunchResult(true, "Başlatma komutu çalıştırıldı.")
            } else {
                LaunchResult(false, "Minecraft başlatılamadı. Java/Yükleme sorun olabilir.")
            }
        } catch (e: Exception) {
            LaunchResult(false, "Başlatma hatası: ${e.localizedMessage}")
        }
    }
}
