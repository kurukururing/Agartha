package com.agartha.agartha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton


class beranda : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beranda, container, false)

        val fragment_next = view.findViewById<ExtendedFloatingActionButton>(R.id.floating)
        val btnProfile = view.findViewById<ImageView>(R.id.btn_profile)
        
        val tvTotalDistance = view.findViewById<TextView>(R.id.tvTotalDistance)
        val tvTotalSessions = view.findViewById<TextView>(R.id.tvTotalSessions)
        val lastRunCard = view.findViewById<MaterialCardView>(R.id.lastRunCard)
        val tvLastDate = view.findViewById<TextView>(R.id.tvLastDate)
        val tvLastDetails = view.findViewById<TextView>(R.id.tvLastDetails)
        val emptyState = view.findViewById<LinearLayout>(R.id.emptyState)

        fragment_next.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_beranda_to_catatlari)
        }

        btnProfile.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_beranda_to_fragment_profil)
        }

        // Observe ViewModel data
        sharedViewModel.totalDistance.observe(viewLifecycleOwner) { distance ->
            tvTotalDistance.text = String.format("%.1f", distance)
        }

        sharedViewModel.totalSessions.observe(viewLifecycleOwner) { sessions ->
            tvTotalSessions.text = sessions.toString()
        }

        sharedViewModel.lastRun.observe(viewLifecycleOwner) { lastRun ->
            if (lastRun != null) {
                emptyState.visibility = View.GONE
                lastRunCard.visibility = View.VISIBLE
                tvLastDate.text = lastRun.tanggal
                tvLastDetails.text = "${lastRun.jarak} km | ${lastRun.durasi} menit"
            } else {
                emptyState.visibility = View.VISIBLE
                lastRunCard.visibility = View.GONE
            }
        }

        return view
    }
}
