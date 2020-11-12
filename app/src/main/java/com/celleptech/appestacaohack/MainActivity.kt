package com.celleptech.appestacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar o email passado através da Intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        // Acessar o arquivo de preferencias compartilhadas
        val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

        // Recuperar os dados no arquivo de preferencias compartilhadas
        val nome = sharedPrefs.getString("NOME","")
        val sobrenome = sharedPrefs.getString("SOBRENOME","")
        val genero = sharedPrefs.getString("GENERO","")

        // Exibir o dado recuperado
        txvMainEmail.text = email
        txvMainNome.text = "$nome $sobrenome"
        txvMainGenero.text = genero

        //Botão site Cel.Lep
        btnMainSite.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }

        // Botao Sair
        val alert = AlertDialog.Builder(this)

        // Defini título
        alert.setTitle("Atenção")

        // Definir a mensadgem
        alert.setMessage("Deseja mesmo sair?")

        // Definir o rótuolo e as ações do botão positivo
        alert.setPositiveButton("Sair"){
            // estrutura de uma função Lambda
            dialog, which ->

            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finishAffinity()
        }

        // Definir o rotulo e acoes do botao neutro
        alert.setNeutralButton("Não"){  dialog, which-> }

        // Definir se a caixa é cancelavel
        alert.setCancelable(false)

        // Exibir a caixa de dialogo
        alert.show()


    }

}