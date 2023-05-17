package com.example.weatherappnew.presentation.detailsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherappnew.databinding.FragmentDetailsBinding
import com.example.weatherappnew.domain.City
import com.example.weatherappnew.domain.Weather

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel = DetailsFragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailsBinding.inflate(inflater)
        initDetails(viewModel.getCityWeather())
        return binding.root
    }

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private fun initDetails(weather: Weather?)= with(binding){
        val coords ="${weather?.city?.lat}/${weather?.city?.lon}"
        detailsCityName.text = weather?.city?.cityName
        detailsCoordinates.text = coords
        detailsTemperature.text = weather?.temperature
        detailsFeelsLike.text = weather?.felt

    }
}