package com.example.weatherappnew.presentation.detailsFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherappnew.data.repository.WeatherRepositoryImpl
import com.example.weatherappnew.domain.AppState
import com.example.weatherappnew.domain.City
import com.example.weatherappnew.domain.WeatherRepository

class DetailsFragmentViewModel:ViewModel() {
    private val repository: WeatherRepository = WeatherRepositoryImpl()

    private val appStateData: MutableLiveData<AppState> = MutableLiveData()
    private val cityDetailsData: MutableLiveData<City> = MutableLiveData()

    fun getData(): LiveData<AppState> {
        return appStateData
    }
    fun getCityDetails(): LiveData<City>{
        return cityDetailsData
    }
    fun getState() {
        when ((0..2).random()){
            0-> appStateData.postValue(AppState.Error)
            1-> appStateData.postValue(AppState.Success)
            2-> appStateData.postValue(AppState.Loading)}
    }

    suspend fun getCityWeather(city: City){
           cityDetailsData.postValue(repository.getCityWeather(city))
    }

    fun getCity():City?{
        return repository.getCity()
    }
}