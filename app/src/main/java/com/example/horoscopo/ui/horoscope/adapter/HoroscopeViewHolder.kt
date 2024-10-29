package com.example.horoscopo.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopo.databinding.ItemHoroscopeBinding
import com.example.horoscopo.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun bind(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        with(binding) {
            val context = nameHoroscope.context
            imageHoroscope.setImageResource(horoscopeInfo.img)
            nameHoroscope.text = context.getString(horoscopeInfo.name)

            binding.parent.setOnClickListener { onItemSelected(horoscopeInfo) }
        }
    }
}