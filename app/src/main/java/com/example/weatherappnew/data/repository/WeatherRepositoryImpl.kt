package com.example.weatherappnew.data.repository

import com.example.weatherappnew.domain.City
import com.example.weatherappnew.domain.Weather
import com.example.weatherappnew.domain.WeatherRepository

class WeatherRepositoryImpl:WeatherRepository {
    private val weather = Weather()
    private val city = City(weather)
    override fun getCityWeather():City {
        return city
    }
}