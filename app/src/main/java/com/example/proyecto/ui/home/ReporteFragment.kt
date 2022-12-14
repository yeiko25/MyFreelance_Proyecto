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
import com.example.proyecto.databinding.FragmentReporteBinding


class ReporteFragment : Fragment() {
    private var _binding: FragmentReporteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReporteBinding.inflate(inflater, container, false)

        binding.btBackReporte.setOnClickListener {  findNavController()
            .navigate(R.id.action_reporteFragment_to_serviceDetail) }

        binding.buttonReporte.setOnClickListener {

            Toast.makeText(requireContext(),"El reporte a sido enviado correctamente", Toast.LENGTH_LONG).show()

            binding.etMotivo.setText("")

            binding.etDetalles.setText("")

        }

        return binding.root

    }

}