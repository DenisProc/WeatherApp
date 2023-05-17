package com.example.weatherappnew.data.repository

import com.example.weatherappnew.domain.City
import com.example.weatherappnew.domain.Weather
import com.example.weatherappnew.domain.WeatherRepository

class WeatherRepositoryImpl:WeatherRepository {
    private val city = City()
    private val weather = Weather(city)
    override fun getWeather():Weather {
        return weather
    }
}