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

    private val liveData: MutableLiveData<AppState> = MutableLiveData()

    fun getData(): LiveData<AppState> {
        return liveData
    }
    fun getState() {
        when ((0..2).random()){
            0-> liveData.postValue(AppState.Error)
            1-> liveData.postValue(AppState.Success)
            2-> liveData.postValue(AppState.Loading)}
    }

    fun getCityWeather():City{
        return repository.getCityWeather()
    }
}