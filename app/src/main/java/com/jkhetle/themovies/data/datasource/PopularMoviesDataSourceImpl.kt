package com.jkhetle.themovies.data.datasource

import com.jkhetle.themovies.data.api.ApiService
import com.jkhetle.themovies.data.entity.PopularMoviesResponse
import retrofit2.Response
import javax.inject.Inject

class PopularMoviesDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : PopularMoviesDataSource {

    override suspend fun getPopularMovies(
        language: String,
        pageNo: Int,
    ): Response<PopularMoviesResponse> {
        return apiService.getPopularMovies(language, pageNo)
    }
}
