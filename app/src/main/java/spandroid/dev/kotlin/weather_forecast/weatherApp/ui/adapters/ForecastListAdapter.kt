package spandroid.dev.kotlin.weather_forecast.weatherApp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.antonioleiva.weatherapp.domain.model.Forecast
import com.antonioleiva.weatherapp.domain.model.ForecastList
import com.antonioleiva.weatherapp.extensions.ctx
import com.antonioleiva.weatherapp.extensions.toDateString
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.kotlin_item_forecast.view.*
import spandroid.dev.R

class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.kotlin_item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(view: View, private val itemClick: (Forecast) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon_adapter)
                itemView.date.text = date.toDateString()
                itemView.description.text = description
                itemView.maxTemperature_adapter.text = "${high}º"
                itemView.minTemperature_adapter.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}