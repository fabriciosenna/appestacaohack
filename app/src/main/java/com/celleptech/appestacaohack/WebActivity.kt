package com.celleptech.appestacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        // Habilitar a execução de códigos javascript
        wbvWeb.settings.javaScriptEnabled = true

        // carregar um endereco web
        wbvWeb.loadUrl("http://br.cellep.com/estacaohack")

        // Definir um cliente web padrão
        wbvWeb.webViewClient = WebViewClient()

    }
}