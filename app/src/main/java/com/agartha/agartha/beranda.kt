package com.agartha.agartha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation



class beranda : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)

        val btnProfile = view.findViewById<ImageView>(R.id.btn_profile)
        btnProfile.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_beranda_to_fragment_profil)
        }



        return view
    }
}
