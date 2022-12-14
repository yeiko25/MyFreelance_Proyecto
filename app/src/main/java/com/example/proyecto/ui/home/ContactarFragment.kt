package com.example.proyecto.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.proyecto.R
import com.example.proyecto.databinding.FragmentContactarBinding

class ContactarFragment : Fragment() {
    private var _binding: FragmentContactarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactarBinding.inflate(inflater, container, false)

        binding.btBackContactar.setOnClickListener {  findNavController()
            .navigate(R.id.action_contactarFragment_to_serviceDetail) }


        binding.buttonContacto.setOnClickListener {

        Toast.makeText(requireContext(),"Se a contactado con el anunciante!", Toast.LENGTH_LONG).show()

            binding.etMensaje.setText("")

        }

        return binding.root

    }

}