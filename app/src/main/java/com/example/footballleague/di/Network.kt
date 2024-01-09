package com.example.footballleague.di

import com.example.footballleague.data.remote.api.BASE_URL
import com.example.footballleague.data.remote.api.CompetitionApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Network {

    @Provides
    fun provideApiService(retrofit: Retrofit): CompetitionApiService {
        return retrofit.create(CompetitionApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        // Load the SSL certificate from the assets folder if it exists
        /* val certificatePin = CertificatePinner.Builder()
             .add(serverHostname, "sha256/your_certificate_hash")
             .build()*/
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(httpLoggingInterceptor)
        //.certificatePinner(certificatePinner)
        return builder.build()
    }
}