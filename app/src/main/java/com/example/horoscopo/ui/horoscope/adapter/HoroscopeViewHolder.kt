package com.example.horoscopo.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
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

            binding.parent.setOnClickListener {
                startAnimation(
                    binding.imageHoroscope,
                    newLambda = { onItemSelected(horoscopeInfo) })
//                onItemSelected(horoscopeInfo)
            }
        }
    }

    private fun startAnimation(view: View, newLambda: () -> Unit) {
        view.animate().apply {
            duration = 600
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLambda() }
            start()
        }
    }
}