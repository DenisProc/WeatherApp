package com.example.weatherappnew.domain

interface WeatherRepository {
    fun getCityWeather(): City

}