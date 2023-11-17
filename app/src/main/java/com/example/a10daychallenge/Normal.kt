package com.example.a10daychallenge

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Normal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal)

        val btnOpenSpotify: Button = findViewById(R.id.btnOpenSpotify)

        // Configurar el clic del botón
        btnOpenSpotify.setOnClickListener {
            // Verificar si Spotify está instalado
            if (isSpotifyInstalled()) {
                // Abrir Spotify
                openSpotify()
            } else {
                // Manejar el caso en el que Spotify no está instalado
                // Puedes mostrar un mensaje o tomar otra acción según tus necesidades.
            }
        }
    }

    private fun isSpotifyInstalled(): Boolean {
        val pm = packageManager
        return try {
            pm.getPackageInfo("com.spotify.music", PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    private fun openSpotify() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("spotify:"))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            // Spotify no está instalado, abrir la tienda de Google Play
            val playStoreIntent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.spotify.music"))
            startActivity(playStoreIntent)
        }
    }
}