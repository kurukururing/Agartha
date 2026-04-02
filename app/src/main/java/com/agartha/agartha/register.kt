package com.agartha.agartha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class register : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val fragment_next_page = view.findViewById<Button>(R.id.button2)

        fragment_next_page.setOnClickListener {
            Navigation.findNavController(view).navigate (R.id.action_register3_to_welcome2)
        }

        return view
    }



}