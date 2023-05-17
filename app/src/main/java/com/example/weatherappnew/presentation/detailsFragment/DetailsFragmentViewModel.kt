package com.example.weatherappnew.presentation.detailsFragment

import androidx.lifecycle.ViewModel
import com.example.weatherappnew.data.repository.WeatherRepositoryImpl
import com.example.weatherappnew.domain.Weather
import com.example.weatherappnew.domain.WeatherRepository

class DetailsFragmentViewModel:ViewModel() {
    private val repository: WeatherRepository = WeatherRepositoryImpl()

    fun getCityWeather():Weather{
        return repository.getWeather()
    }
}