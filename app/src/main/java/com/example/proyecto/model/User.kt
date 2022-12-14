package com.example.proyecto.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="Usuarios")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id_usuario: Int,
    @ColumnInfo(name="nombre")
    val nombre: String,
    @ColumnInfo(name="apellido")
    val apellido: String,
    @ColumnInfo(name="correo")
    val correo: String,
    @ColumnInfo(name="telefono")
    val telefono: String,
    @ColumnInfo(name="usuario")
    val usuario: String,
    @ColumnInfo(name="direccion")
    val direccion: String,
    @ColumnInfo(name="clave")
    val clave: String
) : Parcelable





