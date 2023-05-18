package com.example.weatherappnew.domain

sealed class AppState {
    object Loading:AppState()
    object Success:AppState()
    object Error:AppState()
}