package com.example.weatherappnew.domain

interface WeatherRepository {
    suspend fun getCityWeather(city: City):City
    fun getCity():City?

}