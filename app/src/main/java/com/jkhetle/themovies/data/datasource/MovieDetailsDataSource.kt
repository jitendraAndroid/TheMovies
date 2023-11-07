package com.jkhetle.themovies.data.datasource

import com.jkhetle.themovies.data.entity.MovieDetailsResponse
import retrofit2.Response

interface MovieDetailsDataSource {
    suspend fun getMovieDetails(movieId: String, language: String): Response<MovieDetailsResponse>
}
