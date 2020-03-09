package com.example.jetpackteste.Dados

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class clientes (
    var codigo_cliente: Int = 0,
    var nome_cliente: String? = "",
    var morada_cliente: String? = "",
    var localidade_cliente: String? = "",
    var postal_cliente: String? = "",
    var contribuinte_cliente: String? = "",
    var telefone_cliente: String? = "",
    var pais_cliente: String? = ""): Parcelable

