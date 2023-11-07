package com.jkhetle.themovies.ui.repository

import com.jkhetle.themovies.data.datasource.PopularMoviesDataSource
import com.jkhetle.themovies.data.entity.PopularMoviesResponse
import com.jkhetle.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject
import kotlinx.coroutines.flow.flow as flow

class PopularMoviesRepositoryImpl @Inject constructor(
    private val popularMoviesDataSource: PopularMoviesDataSource
): PopularMoviesRepository {

    override suspend fun getPopularMovies(
        language: String,
        pageNo: Int
    ): Flow<ResourceState<PopularMoviesResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = popularMoviesDataSource.getPopularMovies(language, pageNo)

            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching popular movies"))
            }
        }.catch { e->
            emit(ResourceState.Error(e?.localizedMessage?: "Some error in flow"))
        }
    }

}