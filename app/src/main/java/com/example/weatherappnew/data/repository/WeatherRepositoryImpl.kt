package com.example.weatherappnew.data.repository

import com.example.weatherappnew.cons.YANDEX_MY_KEY
import com.example.weatherappnew.data.api.retrofit.RetrofitInstance
import com.example.weatherappnew.domain.City
import com.example.weatherappnew.domain.Weather
import com.example.weatherappnew.domain.WeatherRepository

class WeatherRepositoryImpl:WeatherRepository {

    companion object{
        var cityForSave:City = City(Weather())
    }
    override suspend fun getCityWeather(city: City):City {
        val dto =RetrofitInstance.weatherApi.getCityWeather(YANDEX_MY_KEY,city.lat,city.lon)
        cityForSave.weather.temperature = dto.fact.temp.toString()
        cityForSave.weather.felt = dto.fact.feels_like.toString()
        return cityForSave
    }

    override fun getCity():City?{
        return cityForSave
    }
}