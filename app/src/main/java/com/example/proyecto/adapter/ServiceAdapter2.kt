package com.example.proyecto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto.databinding.ServiceRow2Binding
import com.example.proyecto.databinding.ServiceRowBinding
import com.example.proyecto.model.Service
import com.example.proyecto.model.User
import com.example.proyecto.ui.home.HomeFragmentDirections




class ServiceAdapter2 : RecyclerView.Adapter<ServiceAdapter2.ServiceViewHolder>() {


    private var listaServicios = emptyList<Service>()


    inner class ServiceViewHolder(private val itemBinding: ServiceRow2Binding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(service: Service) {

            itemBinding.tvTitulo.text = service.tituloServicio
            itemBinding.tvCategoria.text = service.categoriaServicio

            itemBinding.vistaFila.setOnClickListener {
                val accion = HomeFragmentDirections.actionNavigationHomeToUpdateServicee(service)
                itemView.findNavController().navigate(accion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val itemBinding =
            ServiceRow2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)

        return ServiceViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {

        val ServicioActual = listaServicios[position]

        holder.bind(ServicioActual)
    }

    override fun getItemCount(): Int {
        return listaServicios.size
    }

    fun setData(servicios: List<Service>) {
        this.listaServicios=servicios
        notifyDataSetChanged()
    }


}

