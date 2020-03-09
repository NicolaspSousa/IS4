package com.example.jetpackteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import org.w3c.dom.Text

class create_artigo2 : AppCompatActivity() {



    // as  variaveis do spinner

    lateinit var option : Spinner
    lateinit var result : TextView

    val options = arrayOf("Preço","Quantidade","Tudo","Não Para","Balança","Balança+Etiqueta","Pack/Supermercado","Peso/Supermercado","Valor Combustivel","Almoços Compostos")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_artigo2)





        //apresenta o valor escolhido e o resultado

        option = findViewById(R.id.spinner) as Spinner
        result = findViewById(R.id.spinner_text) as TextView

        option.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)



        //Caso esteja vazio == passa para esta mensagem de aviso


        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                result.text = "Escolha uma das opções"


            }


            //apresenta a lista de escolha

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                result.text = options.get(position)

            }
        }


    }









}
