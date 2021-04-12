package com.example.android.navigation


import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
//import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Query
import java.sql.Types.NULL

//private const val BASE_URL = "https://mars.udacity.com/"
//private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
private const val BASE_URL = "https://www.omdbapi.com"


private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

interface MarsApiService{
    //@GET("realestate")
    @GET("/")
    fun getProperties(@Query("apikey") apikey: String,
                      @Query("t") t: String,
                      @Query("y") y: String):
            Deferred<MarsProperty>
}

object MarsApi{
    val retrofitService:MarsApiService by lazy{
        retrofit.create(MarsApiService::class.java)
    }
}


