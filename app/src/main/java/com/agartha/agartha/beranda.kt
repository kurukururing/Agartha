package com.agartha.agartha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class beranda : Fragment() {

    private lateinit var rvPerusahaan: RecyclerView
    private val list = ArrayList<Perusahaan>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)

        val btnProfile = view.findViewById<ImageView>(R.id.btn_profile)
        btnProfile.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_beranda_to_fragment_profil)
        }

        // rv_new adalah ID RecyclerView di fragment_beranda.xml
        rvPerusahaan = view.findViewById(R.id.rv_new)
        rvPerusahaan.setHasFixedSize(true)

        if (list.isEmpty()) {
            list.addAll(getListPerusahaan())
        }
        showRecyclerList()

        return view
    }

    private fun getListPerusahaan(): ArrayList<Perusahaan> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_deskripsi)
        val dataPhoto = resources.obtainTypedArray(R.array.data_foto)
        val listPerusahaan = ArrayList<Perusahaan>()
        for (i in dataName.indices) {
            val perusahaan = Perusahaan(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPerusahaan.add(perusahaan)
        }
        dataPhoto.recycle()
        return listPerusahaan
    }

    private fun showRecyclerList() {
        rvPerusahaan.layoutManager = LinearLayoutManager(context)
        val listHeroAdapter = listPerusahaan_Adapter(list)
        rvPerusahaan.adapter = listHeroAdapter
    }
}
