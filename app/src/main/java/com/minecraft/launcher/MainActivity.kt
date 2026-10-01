package com.minecraft.launcher

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val prefs by lazy { LauncherPreferences(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton = findViewById<Button>(R.id.playButton)
        val settingsButton = findViewById<Button>(R.id.settingsButton)
        val customButton = findViewById<Button>(R.id.customButton)
        val loadingBar = findViewById<ProgressBar>(R.id.loadingBar)

        playButton.setOnClickListener {
            loadingBar.visibility = View.VISIBLE
            playButton.isEnabled = false

            val javaPath = prefs.getJavaPath()
            val javaArgs = prefs.getJavaArgs()
            val serverIp = prefs.getServerIp()
            val serverPort = prefs.getServerPort()
            val memoryMb = prefs.getMemoryMb()
            val playerName = prefs.getPlayerName()

            val launchResult = MinecraftLauncher.startGame(
                javaPath = javaPath,
                javaArgs = javaArgs,
                playerName = playerName,
                serverIp = serverIp,
                serverPort = serverPort,
                memoryMb = memoryMb
            )

            loadingBar.visibility = View.GONE
            playButton.isEnabled = true

            if (launchResult.isSuccess) {
                Toast.makeText(this, getString(R.string.launching), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, launchResult.message, Toast.LENGTH_LONG).show()
            }
        }

        settingsButton.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        customButton.setOnClickListener {
            Toast.makeText(this, "Sunucu: ${prefs.getServerIp()}", Toast.LENGTH_SHORT).show()
        }
    }
}
