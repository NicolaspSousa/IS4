package com.example.jetpackteste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_menu__opcoes.*

class Menu_Opcoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // COMANDO FULLSCREEN

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_menu__opcoes)


        setSupportActionBar(toolbar_ferramentas)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // ao clicar vai para o layout  create client

        novo_utilizador.setOnClickListener {
            val intent = Intent(this, create_clients::class.java)
            startActivity(intent)
        }


        // ao clicar vai para o layout create artigo

        nova_comida.setOnClickListener {
            val intent = Intent(this, create_artigo::class.java)
            startActivity(intent)


        }

    }


}
