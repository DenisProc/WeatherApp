package com.example.weatherappnew.domain

sealed class AppState {
    data class Loading(val progress: Int)
    data class Success(val weather: Int)
    data class Error(val error: Int)
}