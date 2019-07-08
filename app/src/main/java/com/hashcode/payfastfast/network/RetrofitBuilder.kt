package com.hashcode.payfastfast.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    companion object {

        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://payfaster.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}