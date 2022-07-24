package com.sangeetha.tiana.di

import com.sangeetha.tiana.data.remote.MakeupProductAPI
import com.sangeetha.tiana.data.repository.MakeupRepositoryImpl
import com.sangeetha.tiana.domain.repository.MakeupRepository
import com.sangeetha.tiana.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.file.attribute.AclEntry
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideMakeupProductAPI(): MakeupProductAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MakeupProductAPI::class.java)
    }

    private val okHttpClient =  OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun provideMakeupRepository(api: MakeupProductAPI): MakeupRepository {
        return MakeupRepositoryImpl(api)
    }
}