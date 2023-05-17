package com.example.weatherappnew.domain

interface WeatherRepository {
    fun getWeather(): Weather

}