package com.jkhetle.themovies.ui.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jkhetle.themovies.R
import com.jkhetle.themovies.data.AppConstants
import com.jkhetle.themovies.data.entity.MovieDetailsResponse
import com.jkhetle.themovies.ui.components.BackdropImageComponent
import com.jkhetle.themovies.ui.components.EmptyScreen
import com.jkhetle.themovies.ui.components.HeadingTextComponent
import com.jkhetle.themovies.ui.components.Loader
import com.jkhetle.themovies.ui.components.MovieDetailText
import com.jkhetle.themovies.ui.components.RegistrationError
import com.jkhetle.themovies.ui.components.SubHeadingTextComponent
import com.jkhetle.themovies.ui.components.VoteComponent
import com.jkhetle.themovies.ui.viewmodel.MovieDetailsViewModel
import com.jkhetle.utilities.CoreUtility
import com.jkhetle.utilities.ResourceState
import com.jkhetle.utilities.StringUtility
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    navController: NavController,
    movieId: String,
    movieDetailsViewModel: MovieDetailsViewModel,
) {
    val snackHostState = remember { SnackbarHostState() }
    val localCoroutineScope = rememberCoroutineScope()
    val context: Context = LocalContext.current

    val movieDetailsResponse by movieDetailsViewModel.movieDetails.collectAsState()
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
            movieDetailsViewModel.getMovieDetails(movieId, AppConstants.language)
        }

        Scaffold(topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(Color.Transparent.copy(alpha = 0.1f)),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "back button", tint = Color.White)
                    }
                },
            )
        }) { _ ->
            // Not using the content padding to make sure the banner visible from top and the top bar is transparent
            Surface(
                modifier = Modifier.fillMaxSize(),
            ) {
                when (movieDetailsResponse) {
                    is ResourceState.Loading -> {
                        // Display loading
                        Loader(true)
                    }

                    is ResourceState.Success -> {
                        // Parse and display list of movies
                        val response = (movieDetailsResponse as ResourceState.Success).data
                        MovieDetails(movieDetailsResponse = response)
                    }

                    is ResourceState.Error -> {
                        // Display error message
                        val error = (movieDetailsResponse as ResourceState.Error)
                        Log.d(TAG, "Inside Error $error")
                    }
                }
            }
        }
    }

}

@Composable
fun MovieDetails(movieDetailsResponse: MovieDetailsResponse) {
    Column() {
        BackdropImageComponent(movieDetailsResponse.backdropPath)
        Column(modifier = Modifier.padding(16.dp)) {
            HeadingTextComponent(value = movieDetailsResponse.originalTitle)
            SubHeadingTextComponent(
                value = "Duration: ${
                    StringUtility.fromMinutesToHHmm(
                        movieDetailsResponse.runtime,
                    )
                }",
            )
            SubHeadingTextComponent(value = "Language: ${movieDetailsResponse.originalLanguage}")
            VoteComponent(value = movieDetailsResponse.voteAverage)
            MovieDetailText(value = movieDetailsResponse.overview)
        }

    }
}
