package com.example.proyecto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyecto.databinding.ServiceRowBinding
import com.example.proyecto.model.Service
import com.example.proyecto.ui.search.SearchFragmentDirections




class ServiceAdapter: RecyclerView.Adapter<ServiceAdapter.ServicioViewHolder>() {
    private var listaServicios = emptyList<Service>()
    inner class ServicioViewHolder(private  val itemBinding: ServiceRowBinding) : RecyclerView.ViewHolder(itemBinding.root){

        fun dibujar(service:Service){
            itemBinding.tvTitulo.text = service.nombreServicio
            itemBinding.tvPrecio.text = service.precioServicio

           /* if(lugar.rutaImagen?.isNotEmpty() ==true){
                Glide.with(itemBinding.root.context)
                    .load(lugar.rutaImagen)
                    .into(itemBinding.imagen)
            }
*/
            itemBinding.vistaFila.setOnClickListener{
               val accion = SearchFragmentDirections.actionNavigationSearchToServiceDetail2()
                itemView.findNavController().navigate(accion)
            }
        }
    }
    fun setServices(services: List<Service>){
        this.listaServicios = services
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicioViewHolder {
        val itemBinding = ServiceRowBinding
            .inflate(LayoutInflater.from(parent.context)
                ,parent,false)
        return ServicioViewHolder(itemBinding)
    }
    override fun onBindViewHolder(holder: ServicioViewHolder, position: Int) {
        val service = listaServicios[position]
        holder.dibujar(service)
    }
    override fun getItemCount(): Int {
        return listaServicios.size
    }
}