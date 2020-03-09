package com.example.jetpackteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.SearchManager;
import android.content.Context
import android.content.Intent
import android.view.*
import android.widget.*
import android.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackteste.Dados.IS4
import com.example.jetpackteste.Dados.clientes
import com.example.jetpackteste.Dados.clientesAdapter
import kotlinx.android.synthetic.main.activity_menu__clientes.*
import kotlinx.android.synthetic.main.activity_menu__opcoes.*
import kotlinx.android.synthetic.main.menu_frontal.*

class Menu_Clientes : AppCompatActivity() {



    companion object {

        lateinit var IS4: IS4
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // COMANDO FULLSCREEN
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu__clientes)
















        //permite ver o botão voltar na toolbar

        setSupportActionBar(toolbar_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)




        // ao clicar vai para o layout  create client botão do fundo lado direito

        confirmar.setOnClickListener {
            val intent = Intent(this, create_clients::class.java)
            startActivity(intent)

        }



        IS4 = IS4 (this, null,null,1)

        verClientes()



 //É possivel a visualização da lista


    }
    private fun  verClientes(){
        val clienteslista = IS4.getClient(this)
        val adapter = clientesAdapter(this, clienteslista) { cliente ->
            val intent = Intent(this, create_cliente_upd::class.java)
            intent.putExtra("codigo_cliente", cliente)
            startActivity(intent)
        }
        val rv : RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false) as RecyclerView.LayoutManager
        rv.adapter = adapter
    }

    override fun onResume() {

        verClientes()
        super.onResume()
    }


    // Criado para a barra de ferramentas ( search view 'lupa' )


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_view,menu)
        val searchItem = menu.findItem(R.id.clienteID)
        if (searchItem != null){
            val searchView = searchItem.actionView as SearchView

        }

        return super.onCreateOptionsMenu(menu)
    }

}












