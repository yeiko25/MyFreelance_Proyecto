package com.example.proyecto.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.proyecto.R
import com.example.proyecto.adapter.ServiceAdapter
import com.example.proyecto.databinding.FragmentSearchBinding
import com.example.proyecto.viewmodel.SearchViewModel
import com.google.android.material.snackbar.Snackbar

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_search_to_addServicioFragment)
        }

        val serviceAdapter = ServiceAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = serviceAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())

        searchViewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        searchViewModel.getServices.observe(viewLifecycleOwner) { services ->
            serviceAdapter.setServices(services)

        }

            return binding.root
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
