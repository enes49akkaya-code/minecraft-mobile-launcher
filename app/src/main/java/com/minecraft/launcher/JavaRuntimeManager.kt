package com.minecraft.launcher

import android.content.Context
import android.util.Log
import java.io.File

class JavaRuntimeManager(private val context: Context) {

    companion object {
        private const val TAG = "JavaRuntimeManager"
    }

    fun findJavaRuntime(): String? {
        val javaLocations = listOf(
            "/data/data/com.minecraft.launcher/java",
            "/system/bin/java",
            "/system/xbin/java",
            "/usr/bin/java",
            context.getExternalFilesDir(null)?.absolutePath + "/java",
            "/storage/emulated/0/java/bin/java"
        )

        for (path in javaLocations) {
            val javaFile = File(path)
            if (javaFile.exists() && javaFile.canExecute()) {
                Log.d(TAG, "Java found at: $path")
                return path
            }
        }

        Log.w(TAG, "No Java runtime found in standard locations")
        return null
    }

    fun verifyJavaInstallation(javaPath: String): Boolean {
        return try {
            val process = ProcessBuilder(javaPath, "-version")
                .redirectErrorStream(true)
                .start()

            val result = process.waitFor()
            Log.d(TAG, "Java verification result: $result")
            result == 0
        } catch (e: Exception) {
            Log.e(TAG, "Java verification failed: ${e.message}")
            false
        }
    }

    fun getJavaVersion(javaPath: String): String? {
        return try {
            val process = ProcessBuilder(javaPath, "-version")
                .redirectErrorStream(true)
                .start()

            val output = process.inputStream.bufferedReader().use { it.readText() }
            process.waitFor()
            output.trim()
        } catch (e: Exception) {
            Log.e(TAG, "Failed to get Java version: ${e.message}")
            null
        }
    }
}
