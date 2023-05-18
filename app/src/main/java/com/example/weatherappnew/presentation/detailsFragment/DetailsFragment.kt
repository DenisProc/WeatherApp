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

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailsBinding.inflate(inflater)
        val viewModel = ViewModelProvider(this)[DetailsFragmentViewModel::class.java]
        val observer = Observer<AppState> { state -> toast(state) }
        viewModel.getState()
        viewModel.getData().observe(viewLifecycleOwner,observer)


        initDetails(viewModel.getCityWeather(),viewModel)
        return binding.root
    }

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private fun toast(state: AppState)= with(binding){
        when(state){
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

    private fun initDetails(city: City?,viewModel: DetailsFragmentViewModel)= with(binding){
        val coords ="${city?.lat}/${city?.lon}"
        detailsCityName.text = city?.cityName
        detailsCoordinates.text = coords
        detailsTemperature.text = city?.weather?.temperature
        detailsFeelsLike.text = city?.weather?.felt
        reloadingBtn.setOnClickListener { viewModel.getState() }

    }
}