package com.example.weatherappnew.presentation.detailsFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherappnew.databinding.FragmentDetailsBinding
import com.example.weatherappnew.domain.AppState
import com.example.weatherappnew.domain.City
import com.example.weatherappnew.domain.Weather
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    var defaultCity:City = City(Weather())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentDetailsBinding.inflate(inflater)
        val viewModel = ViewModelProvider(this)[DetailsFragmentViewModel::class.java]
        val stateObserver = Observer<AppState> { appState -> getState(appState) }
        val weatherObserver = Observer<City> {initDetails(viewModel)}

        //viewModel.getState()
        //viewModel.getData().observe(viewLifecycleOwner,stateObserver)

            CoroutineScope(Dispatchers.IO).launch {
                viewModel.getCityWeather(defaultCity) }
        viewModel.getCityDetails().observe(viewLifecycleOwner,weatherObserver)


        return binding.root
    }

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private fun getState(appState: AppState)= with(binding){
        when(appState){
            AppState.Error -> {binding.loadingLayuot.visibility = View.GONE
                                binding.progressBar.visibility = View.GONE
                                binding.reloadingBtn.visibility = View.GONE
                                Toast.makeText(requireContext(),"Ошибка", Toast.LENGTH_LONG).show()}
            AppState.Loading -> Toast.makeText(requireContext(),"Загрузка", Toast.LENGTH_LONG).show()
            AppState.Success -> {binding.loadingLayuot.visibility = View.GONE
                                binding.progressBar.visibility = View.GONE
                                binding.reloadingBtn.visibility = View.GONE
                                Toast.makeText(requireContext(),"Успешно", Toast.LENGTH_LONG).show()}
        }
    }

    private fun initDetails(viewModel: DetailsFragmentViewModel)= with(binding){
            detailsCityName.text = viewModel.getCity()?.cityName
            detailsCoordinates.text = "${viewModel.getCity()?.lat}/${viewModel.getCity()?.lon}"
            detailsTemperature.text = viewModel.getCity()?.weather?.temperature
            detailsFeelsLike.text = viewModel.getCity()?.weather?.felt
            reloadingBtn.setOnClickListener { viewModel.getState() }}
}