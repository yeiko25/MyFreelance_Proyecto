package com.example.proyecto.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Parcelize
@Entity(tableName="Servicios")
data class Service(
    @PrimaryKey(autoGenerate = true)
    val id_servicio: Int,
    @ColumnInfo(name="tituloServicio")
    val tituloServicio: String,
    @ColumnInfo(name="descServicio")
    val descServicio: String,
    @ColumnInfo(name="precioServicio")
    val precioServicio: Double,
    @ColumnInfo(name="categoriaServicio")
    val categoriaServicio: String
) : Parcelable

