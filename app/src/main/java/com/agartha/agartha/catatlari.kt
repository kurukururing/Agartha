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
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class catatlari : Fragment() {

    private lateinit var etTanggal: EditText
    private lateinit var etJarak: EditText
    private lateinit var etDurasi: EditText
    private lateinit var btnSimpan: Button
    private lateinit var btnShare: Button
    private var catatanTerakhir: run? = null

    // Use activityViewModels to share the ViewModel across fragments
    private val sharedViewModel: SharedViewModel by activityViewModels()

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

        // --- catch data
        btnSimpan.setOnClickListener {
            // 1. Ambil teks dari inputan
            val inputTanggal = etTanggal.text.toString()
            val inputJarakStr = etJarak.text.toString()
            val inputDurasiStr = etDurasi.text.toString()

            if (inputTanggal.isEmpty() || inputJarakStr.isEmpty() || inputDurasiStr.isEmpty()) {
                Toast.makeText(requireContext(), "Harap isi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 2. Ubah tipe data biar sesuai dengan Data Class
            val jarakLari = inputJarakStr.toDoubleOrNull() ?: 0.0
            val durasiLari = inputDurasiStr.toIntOrNull() ?: 0

            // 3. Masukkan ke dalam Data Class Run
            val dataLariBaru = run(
                tanggal = inputTanggal,
                jarak = jarakLari,
                durasi = durasiLari
            )
            catatanTerakhir = dataLariBaru

            // 4. Update SharedViewModel
            sharedViewModel.addRun(dataLariBaru)

            Toast.makeText(requireContext(), "Catatan disimpan", Toast.LENGTH_SHORT).show()

            // 5. Navigate back to Beranda
            findNavController().popBackStack()
        }

        btnShare.setOnClickListener {
            // Cek dulu apakah ada data yang sudah disimpan di memori
            if (catatanTerakhir != null) {

                // Ambil data dari variabel catatanTerakhir
                val shareText = getString(R.string.judul_share) + """
                
                Tanggal: ${catatanTerakhir?.tanggal}
                Jarak: ${catatanTerakhir?.jarak} km
                Durasi: ${catatanTerakhir?.durasi} menit
                """

                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, shareText)

                startActivity(Intent.createChooser(intent, "Bagikan ke"))

            } else {
                // Kalau catatanTerakhir masih kosong (user belum klik simpan)
                Toast.makeText(requireContext(), "Simpan catatan dulu sebelum dibagikan ya!", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}