package com.agartha.agartha

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class run(
    val tanggal: String,
    val jarak: Double,
    val durasi: Int
)

class SharedViewModel : ViewModel() {
    val lastRun = MutableLiveData<run?>()
    val totalDistance = MutableLiveData<Double>(0.0)
    val totalSessions = MutableLiveData<Int>(0)

    fun addRun(newRun: run) {
        lastRun.value = newRun
        totalDistance.value = (totalDistance.value ?: 0.0) + newRun.jarak
        totalSessions.value = (totalSessions.value ?: 0) + 1
    }
}