package com.example.jetpackteste.Dados

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast
import androidx.core.database.getIntOrNull
import java.lang.Exception

class IS4(context: Context, name : String?, factory:SQLiteDatabase.CursorFactory?, version : Int) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION){


    companion object {
        private val DATABASE_NAME = "IS4.db"
        private val DATABASE_VERSION = 3


        private val CLIENTES_TABLE_NAME = "Cliente"
        private val DB_Cliente_Codigo = "Codigo"
        private val DB_Cliente_Nome = "Nome"
        private val DB_Cliente_Morada = "Morada"
        private val DB_Cliente_Localidade = "Localidade"
        private val DB_Cliente_Postal = "Codigo_postal"
        private val DB_Cliente_Contribuinte = "Contribuinte"
        private val DB_Cliente_Telefone = "Telefone"
        private val DB_Cliente_Pais = "Pais"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CLIENTES_TABLE = ("CREATE TABLE  $CLIENTES_TABLE_NAME (" +
                "$DB_Cliente_Codigo  INTEGER UNIQUE PRIMARY KEY," +
                "$DB_Cliente_Nome VARCHAR(40)," +
                "$DB_Cliente_Morada VARCHAR(40)," +
                "$DB_Cliente_Localidade VARCHAR(30)," +
                "$DB_Cliente_Postal VARCHAR(8)," +
                "$DB_Cliente_Contribuinte VARCHAR(15)," +
                "$DB_Cliente_Telefone VARCHAR(15)," +
                "$DB_Cliente_Pais VARCHAR(3))")
        db?.execSQL(CREATE_CLIENTES_TABLE)







    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }





    fun getClient (mCtx : Context) : ArrayList<clientes>{
        val qry = "Select * From $CLIENTES_TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(qry,null)
        val clientex = ArrayList<clientes>()





        if (cursor.count == 0 )
            Toast.makeText(mCtx, "Sem Clientes adicionados", Toast.LENGTH_SHORT).show() else {
            while (cursor.moveToNext()) {
                val clientes = clientes()
                clientes.codigo_cliente = cursor.getInt(cursor.getColumnIndex(DB_Cliente_Codigo))
                clientes.nome_cliente = cursor.getString(cursor.getColumnIndex(DB_Cliente_Nome))
                clientes.morada_cliente = cursor.getString(cursor.getColumnIndex(DB_Cliente_Morada))
                clientes.localidade_cliente = cursor.getString(cursor.getColumnIndex(DB_Cliente_Localidade))
                clientes.postal_cliente = cursor.getString(cursor.getColumnIndex(DB_Cliente_Postal))
                clientes.contribuinte_cliente = cursor.getString(cursor.getColumnIndex(DB_Cliente_Contribuinte))
                clientes.telefone_cliente = cursor.getString(cursor.getColumnIndex(DB_Cliente_Telefone))
                clientes.pais_cliente = cursor.getString(cursor.getColumnIndex(DB_Cliente_Pais))
                clientex.add(clientes)
            }

        }
        cursor.close()
        db.close()
        return clientex
    }


    //Adiciona o cliente associando a variavel a sua respetiva coluna


    fun addClient(mCtx: Context, clientes: clientes){
        val values = ContentValues()
        values.put(DB_Cliente_Codigo,clientes.codigo_cliente)
        values.put(DB_Cliente_Nome,clientes.nome_cliente)
        values.put(DB_Cliente_Morada,clientes.morada_cliente)
        values.put(DB_Cliente_Localidade,clientes.localidade_cliente)
        values.put(DB_Cliente_Postal,clientes.postal_cliente)
        values.put(DB_Cliente_Contribuinte,clientes.contribuinte_cliente)
        values.put(DB_Cliente_Telefone,clientes.telefone_cliente)
        values.put(DB_Cliente_Pais,clientes.pais_cliente)
        val db = this.writableDatabase



        try {
            db.insert(CLIENTES_TABLE_NAME,null,values)
            Toast.makeText(mCtx,"Cliente Adicionado", Toast.LENGTH_SHORT).show()
        } catch (e : Exception){
            Toast.makeText(mCtx,e.message,Toast.LENGTH_SHORT).show()

        }
        db.close()
    }






    // FUNÇÃO PARA ELIMINAR A COLUNA DOS CLIENTES

    fun delete_cliente(codigo_cliente: Int) : Boolean{
        val qry = "Delete From $CLIENTES_TABLE_NAME where $DB_Cliente_Codigo = $codigo_cliente"
        val db = this.writableDatabase
        var result : Boolean = false
        try {
            val cursor = db.execSQL(qry)
            result = true
        } catch (e : Exception){
            Log.e(ContentValues.TAG,"Erro ao apagar")
        }
        db.close()
        return result
    }

    // FUNÇÃO PARA ATUALIZAR OS DADOS DAS COLUNAS


    fun update_cliente(id: String, codigo_cliente: Int, nome_cliente: String, morada_cliente: String, localidade_cliente: String, postal_cliente: String, contribuinte_cliente: String, telefone_cliente: String, pais_cliente: String) : Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        var result = false
        contentValues.put(DB_Cliente_Codigo,codigo_cliente)
        contentValues.put(DB_Cliente_Nome,nome_cliente)
        contentValues.put(DB_Cliente_Morada,morada_cliente)
        contentValues.put(DB_Cliente_Localidade,localidade_cliente)
        contentValues.put(DB_Cliente_Postal,postal_cliente)
        contentValues.put(DB_Cliente_Contribuinte,contribuinte_cliente)
        contentValues.put(DB_Cliente_Telefone,telefone_cliente)
        contentValues.put(DB_Cliente_Pais,pais_cliente)

        try {
            db.update(CLIENTES_TABLE_NAME, contentValues, "$DB_Cliente_Codigo = ?", arrayOf(id))
            result = true
        } catch (e : Exception){
            Log.e(ContentValues.TAG, "Erro ao atualizar")
            result = false

        }
        return result


    }
}


















