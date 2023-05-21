package com.example.weatherappnew.presentation.cityListFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappnew.R
import com.example.weatherappnew.databinding.CardviewCitylistBinding
import com.example.weatherappnew.domain.City

class CityListAdapter: RecyclerView.Adapter<CityListAdapter.CityListHolder>() {
    private val cityList = emptyList<City>()

    class CityListHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = CardviewCitylistBinding.bind(item)

        fun bind (city: City) = with(binding){
            cardviewCityName.text = city.cityName
            cardviewTemperature.text = "${city.weather.temperature} C°"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_citylist,parent,false)
        return CityListHolder(view)
    }

    override fun onBindViewHolder(holder: CityListHolder, position: Int) {
        holder.bind(cityList[position])
    }

    override fun getItemCount(): Int {
        return cityList.size
    }
    fun refresh() {
        notifyDataSetChanged()
    }
}