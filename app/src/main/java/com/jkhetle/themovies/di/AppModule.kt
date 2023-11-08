package com.jkhetle.themovies.di

import com.jkhetle.themovies.data.AppConstants
import com.jkhetle.themovies.data.api.ApiService
import com.jkhetle.themovies.data.datasource.MovieDetailsDataSource
import com.jkhetle.themovies.data.datasource.MovieDetailsDataSourceImpl
import com.jkhetle.themovies.data.datasource.PopularMoviesDataSource
import com.jkhetle.themovies.data.datasource.PopularMoviesDataSourceImpl
import com.jkhetle.themovies.data.repository.MovieDetailsRepository
import com.jkhetle.themovies.ui.repository.MovieDetailsRepositoryImpl
import com.jkhetle.themovies.ui.repository.PopularMoviesRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }

        val httpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
        }

        httpClient.apply {
            readTimeout(60, TimeUnit.SECONDS)
        }

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesPopularMoviesDataSource(apiService: ApiService): PopularMoviesDataSource {
        return PopularMoviesDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun providesPopularMoviesRepository(popularMoviesDataSource: PopularMoviesDataSource): PopularMoviesRepositoryImpl {
        return PopularMoviesRepositoryImpl(popularMoviesDataSource)
    }

    @Provides
    @Singleton
    fun provideMovieDetailsDataSource(apiService: ApiService): MovieDetailsDataSource {
        return MovieDetailsDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(movieDetailsDataSource: MovieDetailsDataSource): MovieDetailsRepository {
        return MovieDetailsRepositoryImpl(movieDetailsDataSource)
    }
}
