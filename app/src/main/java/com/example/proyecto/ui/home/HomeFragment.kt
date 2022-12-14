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
import com.example.proyecto.R
import com.example.proyecto.Register
import com.example.proyecto.databinding.FragmentHomeBinding
import com.example.proyecto.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.buttonVer.setOnClickListener {

            findNavController().navigate(R.id.action_navigation_home_to_navigation_search)

        }

        binding.txtBuscar.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_search)

        }



        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}