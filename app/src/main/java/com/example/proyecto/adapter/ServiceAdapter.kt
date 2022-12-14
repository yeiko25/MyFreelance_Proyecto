package com.example.proyecto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto.databinding.ServiceRowBinding
import com.example.proyecto.model.Service
import com.example.proyecto.ui.search.SearchFragmentDirections




class ServiceAdapter : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {


    private var listaServicios = emptyList<Service>()


    inner class ServiceViewHolder(private val itemBinding: ServiceRowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(service: Service) {

            itemBinding.tvTitulo.text = service.tituloServicio
            itemBinding.tvPrecio.text = service.precioServicio.toString()



            itemBinding.vistaFila.setOnClickListener {
                val accion = SearchFragmentDirections.actionNavigationSearchToServiceDetail2(service)
                itemView.findNavController().navigate(accion)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val itemBinding =
            ServiceRowBinding.inflate(
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