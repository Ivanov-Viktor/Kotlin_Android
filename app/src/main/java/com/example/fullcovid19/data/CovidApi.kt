package com.example.fullcovid19.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CovidApi {


    @GET("summary")
    fun getSummary(): Call<Summary>

    @GET("country/{countryName}/status/confirmed/live")
    fun getByCountry(@Path("countryName") countryName: String): Call<List<CountryCases>>

}

