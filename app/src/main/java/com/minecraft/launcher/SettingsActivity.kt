package com.minecraft.launcher

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class SettingsActivity : AppCompatActivity() {

    private val prefs by lazy { LauncherPreferences(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val playerName = findViewById<TextInputEditText>(R.id.playerNameInput)
        val javaPath = findViewById<TextInputEditText>(R.id.javaPathInput)
        val javaArgs = findViewById<TextInputEditText>(R.id.javaArgsInput)
        val serverIp = findViewById<TextInputEditText>(R.id.serverIpInput)
        val serverPort = findViewById<TextInputEditText>(R.id.serverPortInput)
        val memoryMb = findViewById<TextInputEditText>(R.id.memoryInput)
        val saveButton = findViewById<android.widget.Button>(R.id.saveButton)

        playerName.setText(prefs.getPlayerName())
        javaPath.setText(prefs.getJavaPath())
        javaArgs.setText(prefs.getJavaArgs())
        serverIp.setText(prefs.getServerIp())
        serverPort.setText(prefs.getServerPort().toString())
        memoryMb.setText(prefs.getMemoryMb().toString())

        saveButton.setOnClickListener {
            val port = serverPort.text.toString().toIntOrNull() ?: 25565
            val mem = memoryMb.text.toString().toIntOrNull() ?: 2048

            prefs.save(
                playerName = playerName.text.toString().ifBlank { "Steve" },
                javaPath = javaPath.text.toString().ifBlank { "/system/bin/java" },
                javaArgs = javaArgs.text.toString().ifBlank { "-Xmx2048M" },
                serverIp = serverIp.text.toString().ifBlank { "mc.sunucum.com" },
                serverPort = port,
                memoryMb = mem
            )

            Toast.makeText(this, getString(R.string.saved_successfully), Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
