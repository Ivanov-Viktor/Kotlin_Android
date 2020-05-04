package com.example.fullcovid19.data


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CovidRepository : CoroutineScope {
    override val coroutineContext = Dispatchers.IO
    private val covidApi = Retrofit.Builder()
        .baseUrl("https://api.covid19api.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CovidApi::class.java)

    fun getSummary() = async {
        covidApi.getSummary()
            .execute()
            .body()

    }

    fun getRussiaData() = async {
        covidApi.getByCountry("russia")
            .execute()
            .body()
            ?.last()
    }

    fun getUSAData() = async {
        covidApi.getByCountry("united-states")
            .execute()
            .body()
            ?.last()
    }

    fun getItalyData() = async {
        covidApi.getByCountry("italy")
            .execute()
            .body()
            ?.last()
    }
}