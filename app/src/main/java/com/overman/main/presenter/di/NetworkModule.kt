package com.overman.main.presenter.di

import com.google.gson.GsonBuilder
import com.overman.main.presenter.util.CoroutineCallAdapterFactory
import com.overman.main.presenter.util.Url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val CONNECT_TIMEOUT = 30L
    private const val WRITE_TIMEOUT = 30L
    private const val READ_TIMEOUT = 30L

    @JsonPlaceHolderRetrofit
    @Singleton
    @Provides
    fun provideJsonPlaceHolderRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(Url.BASE_URL)
        .client(okHttpClient)
        .build()

    @PicsumRetrofit
    @Singleton
    @Provides
    fun providePicsumRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(Url.BASE_URL2)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder().apply {
                connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            }
            .addInterceptor(httpLoggingInterceptor)
            .build()

//    @Singleton
//    @Provides
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
//        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
//        .addCallAdapterFactory(CoroutineCallAdapterFactory())
//        .baseUrl(Url.BASE_URL)
//        .client(okHttpClient)
//        .build()

}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class JsonPlaceHolderRetrofit

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PicsumRetrofit