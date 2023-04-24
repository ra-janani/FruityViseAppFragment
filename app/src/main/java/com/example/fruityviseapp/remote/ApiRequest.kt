package com.example.fruityvice.remote

import com.example.fruityviseapp.data.FruityViceItemModel
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.BASE_URL)
    suspend fun getFruits(): ArrayList<FruityViceItemModel>
}