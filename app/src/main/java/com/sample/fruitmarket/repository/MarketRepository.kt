package com.sample.fruitmarket.repository

import com.sample.fruitmarket.model.RegisteredSeller
import com.sample.fruitmarket.model.VillageRate
import com.sample.fruitmarket.repository.network.MarketServiceImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MarketRepository @Inject constructor(private val marketServiceImpl: MarketServiceImpl) {

    fun getTodayRates(apiKey: String):Flow<List<VillageRate>> = flow {
        emit(marketServiceImpl.getTodayRates(apiKey))
    }.flowOn(Dispatchers.IO)

    fun getSeller(apiKey: String, id: String):Flow<RegisteredSeller?> = flow {
        emit(marketServiceImpl.getSeller(apiKey, id))
    }.flowOn(Dispatchers.IO)

}