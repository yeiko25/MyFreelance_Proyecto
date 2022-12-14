package com.example.proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.proyecto.databinding.FragmentAddServicioBinding
import com.example.proyecto.databinding.FragmentContactarBinding
import com.example.proyecto.databinding.FragmentServiceDetailBinding
import com.example.proyecto.viewmodel.SearchViewModel

class ServiceDetail : Fragment() {
    private var _binding: FragmentServiceDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchViewModel: SearchViewModel


    private val args by navArgs<ServiceDetailArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        _binding = FragmentServiceDetailBinding.inflate(inflater, container, false)

         binding.tvTituloDetail.setText(args.service.tituloServicio)
         binding.tvDescDetail.setText(args.service.descServicio)
         binding.tvPrecioDetail.setText(args.service.precioServicio.toString())

        binding.btBack.setOnClickListener {
            findNavController().navigate(R.id.action_serviceDetail_to_navigation_search) }

        binding.btContactar2.setOnClickListener {
            findNavController().navigate(R.id.action_serviceDetail_to_contactarFragment) }

        binding.btReport.setOnClickListener {
            findNavController().navigate(R.id.action_serviceDetail_to_reporteFragment) }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}