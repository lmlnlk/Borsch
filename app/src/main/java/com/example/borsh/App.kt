package com.example.borsh

import android.app.Application
import com.example.borsh.models.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {
        val okHttp = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

        val api = Retrofit.Builder()
            .baseUrl("http://germangorodnev.com:4500")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()
            .create(Api::class.java)
    }
}