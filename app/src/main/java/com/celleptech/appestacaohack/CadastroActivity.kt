package com.celleptech.appestacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Preencher o spinner

        // 1 - Criar uma lista de opções para o Spinner
        val listaGenero = arrayListOf("Selecione o Gênero", "Feminino", "Masculino", "Não binário")

        // 2 - Criar um adaptador para o Spinner
        val generoAdapter = ArrayAdapter(
            this, // contexto
                    android.R.layout.simple_spinner_dropdown_item, //layout
                    listaGenero
        )

        // 3 - Plugar o adaptador no Spinner
        spnCadastroGenero.adapter = generoAdapter

        // Escutar o clique do botão cadastrar
        btnCadastroCadastrar.setOnClickListener {

            // Obter os dados digitados
            val nome = edtCadastroNome.text.toString().trim()
            val sobrenome = edtCadastroSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim().toLowerCase()
            val senha = edtCadastroSenha.text.toString().trim()
            val genero = spnCadastroGenero.selectedItem.toString()

            // Validação dos Campos

            if(nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() ||
                senha.isEmpty() || genero == listaGenero[0]){

                Toast.makeText(this,"Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else {

                // Criar ou acessar o arquivo de preferëncias compartilhadas
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                // Editar o arquivo de preferências compartilhadas
                val editPrefs = sharedPrefs.edit()

                // Preparando os dados a serem salvos
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)

                // Salvar os dados no arquivo de preferências
                editPrefs.apply()

                // Abrir a Main Activity
                val mIntent = Intent(this, MainActivity::class.java)

                // Passando informações através da Intent
                mIntent.putExtra("INTENT_EMAIL",email)
                startActivity(mIntent)

                // tirar todas as telas


            }


        }


    }

}