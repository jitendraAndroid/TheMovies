package com.jkhetle.themovies.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkhetle.themovies.data.entity.MovieDetailsResponse
import com.jkhetle.themovies.ui.repository.MovieDetailsRepository
import com.jkhetle.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository,
) : ViewModel() {

    private val _movieDetails: MutableStateFlow<ResourceState<MovieDetailsResponse>> =
        MutableStateFlow(ResourceState.Loading())

    val movieDetails: StateFlow<ResourceState<MovieDetailsResponse>> = _movieDetails

    fun getMovieDetails(movieId: String, language: String) {
        viewModelScope.launch(Dispatchers.IO) {
            movieDetailsRepository.getMovieDetails(movieId, language)
                .collectLatest { movieDetailsResponse ->
                    _movieDetails.value = movieDetailsResponse
                }
        }

    }

    companion object {
        const val TAG = "MovieDetailsViewModel"
    }

}
