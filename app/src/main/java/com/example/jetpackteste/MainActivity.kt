package com.example.jetpackteste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.menu_frontal.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        // COMANDO FULLSCREEN

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)





        ///--Permite a ligação da atividade (Pagina principal para menu 1 -> comidas -----------------///

        menu1.setOnClickListener{
            val intent = Intent(this,Menu_comida::class.java)
            startActivity(intent)

        }





        ///--Permite a ligação da atividade (Pagina principal para menu 2 -> clientes -----------------///


        menu2.setOnClickListener{
            val intent = Intent(this,Menu_Clientes::class.java)
            startActivity(intent)

        }







        ///--Permite a ligação da atividade (Pagina principal para menu 3 -> Opções -----------------///


        menu3.setOnClickListener{
            val intent = Intent(this,Menu_Opcoes::class.java)
            startActivity(intent)
        }


    }



    }




