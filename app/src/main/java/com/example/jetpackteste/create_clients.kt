package com.example.jetpackteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.example.jetpackteste.Dados.clientes
import kotlinx.android.synthetic.main.activity_create_clients.*
import kotlinx.android.synthetic.main.activity_menu__clientes.*
import kotlinx.android.synthetic.main.activity_menu__clientes.toolbar_activity

class create_clients : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // COMANDO FULLSCREEN

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_create_clients)

        //FAZ APARECER O BOTÃO DE RETORNO

        setSupportActionBar(toolbar_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        /// BOTAO CONFIRMAR

        confirm.setOnClickListener {

            //CICLO IF PARA O CASO ALGUM CAMPO NÃO ESTEJA PREENCHIDO, SE preenchido ele passa para o Else que guarda o valor da variavel na coluna da BD


            if (IDinput.text.isEmpty()) {
                Toast.makeText(this, "Código necessário", Toast.LENGTH_SHORT).show()
                IDinput.requestFocus()
            } else {
                val clientes = clientes()
                clientes.codigo_cliente = IDinput.text.toString().toInt()


                if (Nomeinput.text.isEmpty()) {
                    Toast.makeText(this, "Precisa de inserir um nome", Toast.LENGTH_LONG).show()
                    Nomeinput.requestFocus()
                } else {
                    clientes.nome_cliente = Nomeinput.text.toString()
                }

                if (Moradainput.text.isEmpty()) {

                    clientes.morada_cliente = Moradainput.text.toString()
                }


                if (Localidadeinput.text.isEmpty()) {

                    clientes.localidade_cliente = Localidadeinput.text.toString()
                }


                if (cod1.text.isEmpty()) {

                    clientes.postal_cliente = cod1.text.toString()
                }


                if (Contribuinteinput.text.isEmpty()) {
                    Toast.makeText(this, "Precisa de inserir o contribuinte", Toast.LENGTH_LONG)
                        .show()
                    Contribuinteinput.requestFocus()
                } else {
                    clientes.contribuinte_cliente = Contribuinteinput.text.toString()
                }

                if (Telefoneinput.text.isEmpty()) {

                    clientes.telefone_cliente = Telefoneinput.text.toString()
                }


                if (Zonainput.text.isEmpty()) {
                    Toast.makeText(this, "Precisa de inserir o pais", Toast.LENGTH_LONG)
                        .show()
                    Zonainput.requestFocus()
                } else {
                    clientes.pais_cliente = Zonainput.text.toString()

                    Menu_Clientes.IS4.addClient(this, clientes)
                    IDinput.requestFocus()
                    Nomeinput.requestFocus()
                    Contribuinteinput.requestFocus()
                    Zonainput.requestFocus()

                }


            }


        }
    }
}



