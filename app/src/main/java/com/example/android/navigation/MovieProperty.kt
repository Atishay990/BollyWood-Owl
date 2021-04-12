package com.example.android.navigation

import com.squareup.moshi.Json

data class MarsProperty(
        //val title: String,
        @Json(name = "Poster") val imgSrcUrl:String
        //  val type:String
        //  val price:Double
)