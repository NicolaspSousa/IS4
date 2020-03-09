package com.example.jetpackteste.Dados
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpackteste.R
import kotlinx.android.synthetic.main.menu_client_app.view.*


class clientesAdapter(mCtx: Context, val clientes: ArrayList<clientes>, val onItemClick: (Pair<Int, Int>) -> Unit) :
    RecyclerView.Adapter<clientesAdapter.ViewHolder>() {
    val mCtx = mCtx

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): clientesAdapter.ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.menu_client_app, p0, false)
        return ViewHolder(v, onItemClick)

    }

    // cria linhas consoante a criação dos dados
    override fun getItemCount(): Int {
        return clientes.size
    }



    ///apresenta a informação no recyclerview , para alem disso faz a ligação do setonClicker

    override fun onBindViewHolder(p0: clientesAdapter.ViewHolder, p1: Int) {
        val client: clientes = clientes[p1]
        p0.IDcliente_view.text = client.codigo_cliente.toString()
        p0.Name_view.text = client.nome_cliente
        p0.itemView.setOnClickListener {
            val position = p0.adapterPosition
            val codigo = client.codigo_cliente
            p0.onItemClick(Pair(position, codigo))
        }
    }

    class ViewHolder(itemView: View, val onItemClick: (Pair<Int, Int>) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val IDcliente_view = itemView.IDcliente_view
        val Name_view = itemView.Name_view
        //val delete_button = itemView.delete_button
        val info_view = itemView.info_view
    }
}




        // para ativar o botao de delete com mensagem de erro ao apresentar

       /** p0.delete_button.setOnClickListener{
            val codigo_cliente = client.codigo_cliente

            var alertDialog = AlertDialog.Builder(mCtx)
                .setTitle("Aviso: ")
                .setMessage("Tem certeza que deseja eliminar : $codigo_cliente")
                .setPositiveButton("Sim", DialogInterface.OnClickListener { dialog, which ->
                    if (Menu_Clientes.IS4.delete_cliente(client.codigo_cliente))
                    {

                        // Elimina a linha e notifica o recycler view que um dado saiu e deve ser eliminado

                        clientes.removeAt(p1)
                        notifyItemRemoved(p1)
                        notifyItemRangeChanged(p1,clientes.size)
                        Toast.makeText(mCtx,"Cliente $codigo_cliente Removido", Toast.LENGTH_SHORT).show()
                    } else
                        Toast.makeText(mCtx,"Erro ao remover!", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->  })
                .setIcon(R.drawable.ic_warning)
                .show()
        } */



        //AO CLICAR ELE APRESENTARA O LAYOUT CREATE_CLIENTS COM OS RESPETIVOS DADOS ATRIBUIDOS





