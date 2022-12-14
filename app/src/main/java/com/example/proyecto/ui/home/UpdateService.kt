package com.example.proyecto.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.proyecto.R
import com.example.proyecto.databinding.FragmentUpdateServiceeBinding
import com.example.proyecto.model.Service
import com.example.proyecto.viewmodel.SearchViewModel

class UpdateService : Fragment() {
    private var _binding: FragmentUpdateServiceeBinding? = null
    private val binding get() = _binding!!
    private lateinit var serviceViewModel: SearchViewModel


    private val args by navArgs<UpdateServiceArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        serviceViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        _binding = FragmentUpdateServiceeBinding.inflate(inflater, container, false)

        binding.etTituloUp.setText(args.service.tituloServicio)
        binding.etDescripcionUp.setText(args.service.descServicio)
        binding.etPrecioUp.setText(args.service.precioServicio.toString())
        binding.etCategoriaUp.setText(args.service.categoriaServicio)



        binding.btActualizarServicio.setOnClickListener { updateService() }

        binding.btEliminarPublicacion.setOnClickListener { deleteService() }

        binding.btBackUp.setOnClickListener { findNavController().navigate(R.id.action_updateServicee_to_navigation_home) }


        return binding.root
    }





    private fun updateService() {

        val titulo =binding.etTituloUp.text.toString()

        if (titulo.isNotEmpty()) {

            val desc=binding.etDescripcionUp.text.toString()
            val precio=binding.etPrecioUp.text.toString().toDouble()
            val cat = binding.etCategoriaUp.text.toString()



            val service = Service(args.service.id_servicio,titulo,desc,precio,cat)

            serviceViewModel.saveService(service)
            Toast.makeText(requireContext(),getString(R.string.msg_servicio_updated),
                Toast.LENGTH_SHORT).show()
         findNavController().navigate(R.id.action_updateServicee_to_navigation_home)
        } else {
            Toast.makeText(requireContext(),getString(R.string.msg_data),
                Toast.LENGTH_LONG).show()
        }
    }

    private fun deleteService() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Eliminar publicación")
        builder.setMessage("¿Esta seguro que desea eliminar esta publicación?")
        builder.setNegativeButton("No") {_,_ -> }
        builder.setPositiveButton("SI") {_,_ ->
            serviceViewModel.deleteService(args.service)
            Toast.makeText(requireContext(),
                "Publicación eliminada",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateServicee_to_navigation_home)
        }

        builder.create().show()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}