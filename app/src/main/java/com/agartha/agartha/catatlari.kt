package com.agartha.agartha

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class BlankFragment : Fragment() {

    private lateinit var etTanggal: EditText
    private lateinit var etJarak: EditText
    private lateinit var etDurasi: EditText
    private lateinit var btnSimpan: Button
    private lateinit var btnShare: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_catatlari, container, false)

        etTanggal = view.findViewById(R.id.etTanggal)
        etJarak = view.findViewById(R.id.etJarak)
        etDurasi = view.findViewById(R.id.etDurasi)
        btnSimpan = view.findViewById(R.id.btnSimpan)
        btnShare = view.findViewById(R.id.btnShare)

        btnSimpan.setOnClickListener {
            Toast.makeText(requireContext(), "Catatan disimpan", Toast.LENGTH_SHORT).show()
        }

        btnShare.setOnClickListener {

            val shareText = getString(R.string.judul_share) + """

Tanggal: ${etTanggal.text}
Jarak: ${etJarak.text} km
Durasi: ${etDurasi.text} menit
"""

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, shareText)

            startActivity(Intent.createChooser(intent, "Bagikan ke"))
        }

        return view
    }
}