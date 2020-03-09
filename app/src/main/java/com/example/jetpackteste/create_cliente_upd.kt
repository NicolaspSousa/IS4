package com.example.jetpackteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.example.jetpackteste.Dados.clientes
import kotlinx.android.synthetic.main.activity_menu__clientes.*

class create_cliente_upd : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val clientes = intent.extras?.getParcelable<clientes>("cliente_key")



        //comando fullscreen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_create_cliente_upd)


            //apresenta na imagem a toolbar para voltar atras


        setSupportActionBar(toolbar_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
