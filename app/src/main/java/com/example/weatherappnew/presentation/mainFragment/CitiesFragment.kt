package com.example.weatherappnew.presentation.mainFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherappnew.databinding.FragmentCitiesBinding

class CitiesFragment : Fragment() {
    private lateinit var binding: FragmentCitiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCitiesBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        fun newInstance()= CitiesFragment()
    }
}