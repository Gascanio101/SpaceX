package com.example.spacex_v2.data

import retrofit2.Response
import retrofit2.http.GET

interface SpaceXApi {
    @GET("v4/crew")
    suspend fun getCrew(): Response<CrewModel>
}