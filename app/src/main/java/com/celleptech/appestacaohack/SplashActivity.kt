package com.celleptech.appestacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Abrir a LoginActivity após 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({

            // Intent (Intenção)
            val mIntent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(mIntent)

            // Elimina ou encerra a tela
            finish()

        }, 3000)

    }

}