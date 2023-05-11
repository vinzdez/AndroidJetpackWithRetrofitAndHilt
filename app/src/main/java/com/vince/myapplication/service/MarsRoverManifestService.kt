package com.vince.myapplication.service

import com.vince.myapplication.BuildConfig
import com.vince.myapplication.service.model.RoverManifestRemoteModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface MarsRoverManifestService {

    @GET("mars-photos/api/v1/manifest/{rover-name}?api_key=Z6YEmazqfQ7Xdsn7qVHNgSgvClchrb93rBtpm9RM")
    suspend fun getMarsRoverManifest(@Path("rover_name") roverName: String) : RoverManifestRemoteModel
    
    companion object{
        private const val BASE_URL = "https://api.nasa.gov/"
        
        fun create() : MarsRoverManifestService{
            val logger = HttpLoggingInterceptor()
            logger.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder().baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MarsRoverManifestService::class.java)
        }
    }

}