package com.skynet.horoscapp.ui.horoscope

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.skynet.horoscapp.databinding.ItemHoroscopeBinding
import com.skynet.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.tvTitle.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvTitle.text = context.getString(horoscopeInfo.name)

        //cuando hemos pulsado
        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope)
            onItemSelected(horoscopeInfo)
        }
    }

    private fun startRotationAnimation(view: View) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            start()
        }
    }
}