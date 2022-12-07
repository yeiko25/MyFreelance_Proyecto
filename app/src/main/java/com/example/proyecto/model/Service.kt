package com.example.proyecto.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Service(
    var id: String,
    val nombreServicio: String,
    val descriServicio: String?,
    val precioServicio: String?,
    val categoriaServicio: String?,

) : Parcelable{
    constructor():
            this("","","","","")
}