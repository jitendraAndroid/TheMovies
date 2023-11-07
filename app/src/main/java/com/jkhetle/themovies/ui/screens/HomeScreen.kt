package com.jkhetle.themovies.ui.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.jkhetle.themovies.R
import com.jkhetle.themovies.data.AppConstants
import com.jkhetle.themovies.ui.components.EmptyScreen
import com.jkhetle.themovies.ui.components.Loader
import com.jkhetle.themovies.ui.components.PopularMovieImageList
import com.jkhetle.themovies.ui.components.RegistrationError
import com.jkhetle.themovies.ui.viewmodel.PopularMoviesViewModel
import com.jkhetle.utilities.CoreUtility
import com.jkhetle.utilities.ResourceState
import kotlinx.coroutines.launch

const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    navController: NavController,
    popularMoviesViewModel: PopularMoviesViewModel,
) {
    val popularMoviesResponse by popularMoviesViewModel.popularMovies.collectAsState()
    val snackHostState = remember { SnackbarHostState() }
    val localCoroutineScope = rememberCoroutineScope()
    val context: Context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize()) {
        if (!CoreUtility.isInternetConnected(context)) {
            EmptyScreen()
            RegistrationError(
                hostState = snackHostState,
                stringResource(id = R.string.network_check),
            )
            LaunchedEffect(Unit) {
                localCoroutineScope.launch {
                    snackHostState.showSnackbar("No network")
                }
            }
        } else {
            LaunchedEffect(Unit) {
                popularMoviesViewModel.getPopularMovies(AppConstants.language, AppConstants.pageNo)
            }
            when (popularMoviesResponse) {
                is ResourceState.Loading -> {
                    // Display loading
                    Loader(true)
                }

                is ResourceState.Success -> {
                    // Parse and display list of movies
                    val response = (popularMoviesResponse as ResourceState.Success).data
                    PopularMovieImageList(navController, response)
                }

                is ResourceState.Error -> {
                    EmptyScreen()
                    // Display error message
                    val errorResponse = (popularMoviesResponse as ResourceState.Error)
                    Log.d(TAG, "Inside Error $errorResponse")
                    RegistrationError(
                        hostState = snackHostState,
                        stringResource(id = R.string.generic_error),
                    )
                    LaunchedEffect(errorResponse) {
                        localCoroutineScope.launch {
                            snackHostState.showSnackbar(errorResponse.error.toString())
                        }
                    }

                }

            }
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    // HomeScreen()
}
