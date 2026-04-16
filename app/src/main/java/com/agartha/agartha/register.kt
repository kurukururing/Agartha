package com.agartha.agartha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast




class Register : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val username = view.findViewById<EditText>(R.id.username)
        val password = view.findViewById<EditText>(R.id.password)
        val email = view.findViewById<EditText>(R.id.email)
        val buttonDaftar = view.findViewById<Button>(R.id.button2)

        // Penyimpanan sementara
        val listUser = ArrayList<DataUser>()

        buttonDaftar.setOnClickListener {

            val user = username.text.toString()
            val pass = password.text.toString()
            val mail = email.text.toString()

            if (user.isEmpty() || pass.isEmpty() || mail.isEmpty()) {
                Toast.makeText(requireContext(), "Semua field harus diisi!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val dataUser = DataUser(user, pass, mail)
                listUser.add(dataUser)

                Toast.makeText(requireContext(), "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

                // Optional: reset form
                username.text.clear()
                password.text.clear()
                email.text.clear()
            }
        }

        return view
    }

}