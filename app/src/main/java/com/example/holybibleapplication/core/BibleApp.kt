package com.example.holybibleapplication.core

import android.app.Application
import com.example.holybibleapplication.data.net.BooksService
import retrofit2.Retrofit

class BibleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).build()
        val service = retrofit.create(BooksService::class.java)
    }

    companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }
}