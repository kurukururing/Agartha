package com.agartha.agartha

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class listPerusahaan_Adapter(private val listPerusahaan: ArrayList<Perusahaan>) :
    RecyclerView.Adapter<listPerusahaan_Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_perusahaan_photo)
        val tvPerusahaan: TextView = itemView.findViewById(R.id.nama_perusahaan)
        val tvDescription: TextView = itemView.findViewById(R.id.deskripsi)
        
        // Widget tambahan
        val layoutDetail: LinearLayout = itemView.findViewById(R.id.layout_detail)
        val tvAlamat: TextView = itemView.findViewById(R.id.tv_alamat)
        val btnKunjungi: Button = itemView.findViewById(R.id.btn_kunjungi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_review, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = listPerusahaan.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listPerusahaan[position]
        
        holder.imgPhoto.setImageResource(currentItem.foto)
        holder.tvPerusahaan.text = currentItem.nama
        holder.tvDescription.text = currentItem.deskripsi

        // Logika Interaktif: Tampilkan detail jika isExpanded true
        holder.layoutDetail.visibility = if (currentItem.isExpanded) View.VISIBLE else View.GONE

        // Click Listener untuk toggle status expand
        holder.itemView.setOnClickListener {
            currentItem.isExpanded = !currentItem.isExpanded
            // Beri tahu adapter bahwa item pada posisi ini berubah agar UI di-refresh
            notifyItemChanged(position)
        }
        
        // Listener untuk tombol di dalam widget baru
        holder.btnKunjungi.setOnClickListener {
            // Tambahkan aksi kunjungi website di sini
        }
    }
}
