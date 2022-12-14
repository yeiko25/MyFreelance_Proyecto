package com.example.proyecto.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto.R
import com.example.proyecto.Register
import com.example.proyecto.adapter.ServiceAdapter
import com.example.proyecto.adapter.ServiceAdapter2
import com.example.proyecto.databinding.FragmentHomeBinding
import com.example.proyecto.viewmodel.HomeViewModel
import com.example.proyecto.viewmodel.SearchViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var searchViewModel: SearchViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)



        binding.buttonVer.setOnClickListener {

            findNavController().navigate(R.id.action_navigation_home_to_navigation_search)

        }

        binding.txtBuscar.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_search)

        }


        val serviceAdapter = ServiceAdapter2()
        val reciclador = binding.Reciclador2
        reciclador.adapter = serviceAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        searchViewModel.getService.observe(viewLifecycleOwner) { services ->
            serviceAdapter.setData(services)

        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}