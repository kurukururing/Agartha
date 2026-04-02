package com.agartha.agartha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class welcome : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val fragment_next_login = view.findViewById<Button>(R.id.login)

        fragment_next_login.setOnClickListener {
            Navigation.findNavController(view).navigate (R.id.action_welcome2_to_login3)
        }

        val fragment_next_SignUp = view.findViewById<Button>(R.id.signUp)

        fragment_next_SignUp.setOnClickListener {
            Navigation.findNavController(view).navigate (R.id.action_welcome2_to_register3)
        }

        return view
    }

}