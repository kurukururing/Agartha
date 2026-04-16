package com.agartha.agartha
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class listPerusahaan_Adapter(private val listPerusahaan:ArrayList<Perusahaan>) :
    RecyclerView.Adapter<listPerusahaan_Adapter.ViewHolder>() {

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = this.itemView.findViewById(R.id.img_perusahaan_photo)
        val tvPerusahaan: TextView = this.itemView.findViewById(R.id.nama_perusahaan)
        val tvDescription: TextView = this.itemView.findViewById(R.id.deskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_review, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listPerusahaan.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listPerusahaan[position]
        holder.imgPhoto.setImageResource(currentItem.foto)
        holder.tvPerusahaan.text = currentItem.nama
        holder.tvDescription.text = currentItem.deskripsi
    }

    }

