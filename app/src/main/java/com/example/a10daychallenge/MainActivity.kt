package com.example.a10daychallenge

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private lateinit var btnAdrian: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Verificar si Spotify está instalado en el dispositivo
        if (isSpotifyInstalled()) {
            // Abrir Spotify
            openSpotify()
        } else {
            // Si Spotify no está instalado, puedes mostrar un mensaje o tomar otra acción
            // según tus necesidades.
        }
    }

    fun goToAdrian(view: View) {
        val intent = Intent(this, Normal::class.java)
        startActivity(intent)
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
        // Crear un Intent con la acción ACTION_VIEW y la URI de Spotify
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("spotify:"))

        // Iniciar la actividad con el Intent
        startActivity(intent)
    }
}