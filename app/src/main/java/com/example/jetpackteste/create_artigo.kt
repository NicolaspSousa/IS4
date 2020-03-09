package com.example.jetpackteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_create_artigo.*
import kotlinx.android.synthetic.main.activity_menu__clientes.toolbar_activity

class create_artigo : AppCompatActivity() {







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)







        //COMANDO FULLSCREEN




        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create_artigo)



        //FAZ APARECER O BOTÃO DE RETORNO

        setSupportActionBar(toolbar_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }




        }


