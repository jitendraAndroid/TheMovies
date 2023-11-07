package com.jkhetle.themovies.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkhetle.themovies.data.entity.PopularMoviesResponse
import com.jkhetle.themovies.ui.repository.PopularMoviesRepositoryImpl
import com.jkhetle.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val popularMoviesRepositoryImpl: PopularMoviesRepositoryImpl,
) : ViewModel() {

    private val _popularMovies: MutableStateFlow<ResourceState<PopularMoviesResponse>> = MutableStateFlow(ResourceState.Loading())
    val popularMovies: StateFlow<ResourceState<PopularMoviesResponse>> = _popularMovies

    fun getPopularMovies(language: String, pageNo: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            popularMoviesRepositoryImpl.getPopularMovies(language, pageNo)
                .collectLatest {
                        popularMoviesResponse ->
                    _popularMovies.value = popularMoviesResponse
                }
        }

    }
    companion object {
        const val TAG = "PopularMoviesViewModel"
    }

}
