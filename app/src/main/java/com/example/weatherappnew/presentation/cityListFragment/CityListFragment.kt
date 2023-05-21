package com.example.weatherappnew.presentation.cityListFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherappnew.databinding.FragmentCitiesBinding

class CityListFragment : Fragment() {
    private lateinit var binding: FragmentCitiesBinding
    private val adapter = CityListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCitiesBinding.inflate(inflater)
        initRecyclerView()
        return binding.root
    }

    companion object {
        fun newInstance()= CityListFragment()
    }

    private fun initRecyclerView(){
        binding.apply {
            weatherListRecycler.layoutManager = LinearLayoutManager(activity)
            weatherListRecycler.adapter = adapter
        }
    }
}