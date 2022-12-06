package com.example.proyecto.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var id: String,
    val nombre: String,
    val apellido: String?,
    val correo: String?,
    val telefono: String?,
    val usuario: String?,
    val direccion: String?,
    val clave: String?
) : Parcelable{
    constructor():
            this("","","","","","","","")
}


