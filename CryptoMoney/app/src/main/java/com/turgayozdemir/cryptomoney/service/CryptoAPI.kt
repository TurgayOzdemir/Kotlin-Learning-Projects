package com.turgayozdemir.cryptomoney.service

import android.database.Observable
import com.turgayozdemir.cryptomoney.model.CryptoModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface CryptoAPI {

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    //fun getData() : io.reactivex.rxjava3.core.Observable<List<CryptoModel>>
    //fun getData() : Call<List<CryptoModel>>
    suspend fun getData() : Response<List<CryptoModel>>

}