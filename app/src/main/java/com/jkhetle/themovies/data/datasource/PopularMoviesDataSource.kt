package com.jkhetle.themovies.data.datasource

import com.jkhetle.themovies.data.entity.PopularMoviesResponse
import retrofit2.Response

interface PopularMoviesDataSource {

    suspend fun getPopularMovies(language: String, pageNo: Int): Response<PopularMoviesResponse>

}
