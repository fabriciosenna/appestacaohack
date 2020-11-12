package com.celleptech.appestacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Escutar o clique do botão entrar
        btnLoginEntrar.setOnClickListener {

            // Capturar os dados digitados
            // atributo text guarda texto crú RawText (String "...")
            // conversão de tipo (Casting)
            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val senha = edtLoginSenha.text.toString().trim()

            // Validação dos campos
            if (email.isEmpty()) {
                edtLoginEmail.error = "Campo obrigatório"
                edtLoginEmail.requestFocus()

            } else if (senha.isEmpty()) {
                edtLoginSenha.error = "Campo obrigatório"
                edtLoginSenha.requestFocus()

            } else {

                // Acessar o arquivo de preferências compartilhadas

                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                // Recuperar os dados do cadastro (SharedPreferences)
                val emailPres = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA","")


                // Simulando o acesso aos dados persistidos
                // Viricar o email e senha
                if (email == emailPres && senha == senhaPrefs) {

                    // Exibir uma mensagem ao usuário
                    // contexto
                    // mensagem
                    // duração do Toast
                    Toast.makeText(this, "Usuário logado", Toast.LENGTH_LONG).show()

                    // Abrir a MainActivity
                    val mIntent = Intent(this, MainActivity::class.java)

                    // Passando dados através da Intent
                    mIntent.putExtra("INTENT_EMAIL",email)

                    startActivity(mIntent)
                    finish()

                } else {

                    // Apresentar mensagem de erro ao usuário
                    Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_LONG).show()
                }

            }

        }

        // Escutar o clique do botão cadastrar
        btnLoginCadastrar.setOnClickListener {
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
        }

    }
}