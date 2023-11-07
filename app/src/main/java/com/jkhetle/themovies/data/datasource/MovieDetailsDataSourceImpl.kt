package com.jkhetle.themovies.data.datasource

import com.jkhetle.themovies.data.api.ApiService
import com.jkhetle.themovies.data.entity.MovieDetailsResponse
import retrofit2.Response
import javax.inject.Inject

class MovieDetailsDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    MovieDetailsDataSource {

    override suspend fun getMovieDetails(
        movieId: String,
        language: String,
    ): Response<MovieDetailsResponse> {
        return apiService.getMovieDetails(movieId, language)
    }

}
