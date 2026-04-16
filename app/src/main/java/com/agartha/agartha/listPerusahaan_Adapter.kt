package com.agartha.agartha
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class listPerusahaan_Adapter(private val listPerusahaan: ArrayList<perusahaan>) :
    RecyclerView.Adapter<listPerusahaan_Adapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_perusahaan_photo)
        val tvName: TextView = itemView.findViewById(R.id.nama_perusahaan)
        val tvDescription: TextView = itemView.findViewById(R.id.deskripsi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_review, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listPerusahaan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, deskripsi, foto) = listPerusahaan[position]

        holder.imgPhoto.setImageResource(foto)
        holder.tvName.text = nama
        holder.tvDescription.text = deskripsi

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listPerusahaan[holder.adapterPosition])
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: perusahaan)
    }
}