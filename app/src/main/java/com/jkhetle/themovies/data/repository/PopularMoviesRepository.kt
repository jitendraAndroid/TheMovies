package com.jkhetle.themovies.data.repository

import com.jkhetle.themovies.data.entity.PopularMoviesResponse
import com.jkhetle.utilities.ResourceState
import kotlinx.coroutines.flow.Flow

interface PopularMoviesRepository {
    suspend fun getPopularMovies(
        language: String,
        pageNo: Int,
    ): Flow<ResourceState<PopularMoviesResponse>>
}
