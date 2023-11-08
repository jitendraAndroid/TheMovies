package com.jkhetle.themovies.ui.repository

import com.jkhetle.themovies.data.datasource.MovieDetailsDataSource
import com.jkhetle.themovies.data.entity.MovieDetailsResponse
import com.jkhetle.themovies.data.repository.MovieDetailsRepository
import com.jkhetle.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(private val movieDetailsDataSource: MovieDetailsDataSource):
    MovieDetailsRepository {

    override suspend fun getMovieDetails(
        movieId: String,
        language: String,
    ): Flow<ResourceState<MovieDetailsResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = movieDetailsDataSource.getMovieDetails(movieId, language)

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching movie details"))
            }
        }.catch { e ->
            emit(ResourceState.Error(e?.localizedMessage ?: "Some error in flow"))
        }
    }

}
