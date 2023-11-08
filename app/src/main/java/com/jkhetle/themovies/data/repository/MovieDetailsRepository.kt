package com.jkhetle.themovies.data.repository

import com.jkhetle.themovies.data.entity.MovieDetailsResponse
import com.jkhetle.utilities.ResourceState
import kotlinx.coroutines.flow.Flow

interface MovieDetailsRepository {
    suspend fun getMovieDetails(
        movieId: String,
        language: String,
    ): Flow<ResourceState<MovieDetailsResponse>>
}