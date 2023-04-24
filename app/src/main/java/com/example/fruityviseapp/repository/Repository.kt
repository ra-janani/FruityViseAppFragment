package com.example.fruityvice.repository

import com.example.fruityviseapp.data.FruityViceItemModel

interface Repository {

    suspend fun getFruits(): ArrayList<FruityViceItemModel>
}