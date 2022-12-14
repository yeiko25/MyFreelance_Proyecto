package com.example.proyecto.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.proyecto.R
import com.example.proyecto.databinding.FragmentAddServicioBinding
import com.example.proyecto.model.Service
import com.example.proyecto.viewmodel.SearchViewModel

class AddServicioFragment : Fragment() {
    private var _binding: FragmentAddServicioBinding? = null
    private val binding get() = _binding!!

    private lateinit var serviceViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        serviceViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        _binding = FragmentAddServicioBinding.inflate(inflater, container, false)

        binding.btPublicarServicio.setOnClickListener { publicarServicio() }

        binding.btBackAdd.setOnClickListener { findNavController().navigate(R.id.action_addServicioFragment_to_navigation_search) }

        return binding.root



    }
    private fun publicarServicio(){

        val titulo = binding.etTitulo.text.toString().trim()
        val descripcion = binding.etDescripcion.text.toString().trim()
        val precio = binding.etPrecio.text.toString().trim().toDouble()
        val categoria = binding.etCategoria.text.toString().trim()

        if(titulo.isNotEmpty()){
            val service = Service(0, titulo, descripcion, precio, categoria)
            serviceViewModel.saveService(service)
            Toast.makeText(requireContext(), getString(R.string.msg_agregaServicio), Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addServicioFragment_to_navigation_search)
        }
        else{
            Toast.makeText(requireContext(), getString(R.string.msg_error), Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
