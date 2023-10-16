package com.example.spacex_v2.data

import com.example.spacex_v2.Utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun fetchData(): SpaceXApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(SpaceXApi::class.java)
    }
}