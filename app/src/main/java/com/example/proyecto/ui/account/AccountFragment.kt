package com.example.proyecto.ui.account


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.proyecto.Login
import com.example.proyecto.R
import com.example.proyecto.Register
import com.example.proyecto.databinding.FragmentAccountBinding
import com.example.proyecto.viewmodel.AccountViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        val root: View = binding.root


        setup()


        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setup(){
        binding.btLogoff.setOnClickListener{
            logout()
        }

    }

    private fun logout(){
        FirebaseAuth.getInstance().signOut()
        findNavController().navigate(R.id.action_navigation_account_to_login)
    }
}