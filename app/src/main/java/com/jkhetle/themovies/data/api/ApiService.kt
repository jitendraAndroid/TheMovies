package com.jkhetle.themovies.data.api

import com.jkhetle.themovies.TheMoviesApplication
import com.jkhetle.themovies.data.entity.PopularMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") pageNo: Int,
        @Header("accept") mimeType: String = "application/json",
        @Header("Authorization") authToken: String = "Bearer ${TheMoviesApplication.AUTH_TOKEN}",
    ): Response<PopularMoviesResponse>

}
