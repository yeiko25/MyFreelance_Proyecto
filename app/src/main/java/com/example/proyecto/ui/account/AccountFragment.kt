package com.example.proyecto.ui.account




import android.annotation.SuppressLint
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
import com.example.proyecto.databinding.FragmentAccountBinding
import com.example.proyecto.model.Service
import com.example.proyecto.model.User
import com.example.proyecto.viewmodel.AccountViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase




class AccountFragment : Fragment() {




    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!
    private lateinit var accountViewModel: AccountViewModel

    private val args by navArgs<AccountFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        accountViewModel = ViewModelProvider(this)[AccountViewModel :: class.java]
        _binding = FragmentAccountBinding.inflate(inflater, container, false)





        /*
        binding.nombreUp.setText(args.user.nombre)
        binding.apellidoUp.setText(args.user.apellido)
        binding.telefonoUp.setText(args.user.telefono)
        binding.usuarioUp.setText(args.user.usuario)
        binding.direccionUp.setText(args.user.direccion)
        binding.correoUp.setText(args.user.correo)
        binding.claveUp.setText(args.user.clave)
*/

        binding.btUpdateUser.setOnClickListener { updateUser() }

        binding.btLogoff.setOnClickListener {
          //  Firebase.auth.signOut()
          // findNavController().navigate(R.id.action_navigation_account_to_login)
            FirebaseAuth.getInstance().signOut()
        }

        return binding.root
    }


    @SuppressLint("SuspiciousIndentation")
    private fun updateUser(){
        val nombre = binding.nombreUp.text.toString().trim()
        val apellido = binding.apellidoUp.text.toString().trim()
        val telefono = binding.telefonoUp.text.toString().trim()
        val usuario = binding.usuarioUp.text.toString().trim()
        val direccion = binding.direccionUp.text.toString().trim()
      //  val correo = binding.correoUp.text.toString().trim()
        val clave = binding.claveUp.text.toString().trim()

      val correo = Firebase.auth.currentUser?.email.toString()




        if (nombre.isEmpty() || apellido.isEmpty()
            || direccion.isEmpty() || telefono.isEmpty() || usuario.isEmpty() || clave.isEmpty()) {

            Toast.makeText(requireContext(), "Por favor rellene todo los campos", Toast.LENGTH_LONG)
                .show()

        } else {
            Firebase.auth.currentUser?.updateEmail(correo)
            Firebase.auth.currentUser?.updatePassword(clave)

            val user = User(0,nombre,apellido,correo,telefono,usuario,direccion,clave)
            accountViewModel.saveUser(user)

            Toast.makeText(requireContext(),getString(R.string.msg_user_updated),Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_navigation_account_to_navigation_home)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}