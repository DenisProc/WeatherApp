package com.example.weatherappnew.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherappnew.R
import com.example.weatherappnew.presentation.detailsFragment.DetailsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startDetailsFragment()
    }
    private fun startDetailsFragment(){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, DetailsFragment.newInstance())
            .commit()
    }
}