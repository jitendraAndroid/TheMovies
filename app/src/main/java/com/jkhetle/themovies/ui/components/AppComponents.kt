package com.jkhetle.themovies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import com.jkhetle.themovies.R
import com.jkhetle.themovies.data.AppConstants
import com.jkhetle.themovies.data.entity.Movies
import com.jkhetle.themovies.data.entity.PopularMoviesResponse

@Composable
fun Loader(value: Boolean) {
    if (value) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(80.dp, 80.dp),
            )
        }
    }
}

@Composable
fun PopularMovieImageList(navController: NavController, response: PopularMoviesResponse) {
    Column {
        Text(
            text = stringResource(id = R.string.top_ten),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(vertical = 5.dp),
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
        )
        if (response.movies.isNotEmpty()) {
            LazyColumn {
                items(response.movies.take(10)) { item: Movies ->
                    PopularMovieItem(navController, item)
                }
            }
        } else {
            EmptyScreen()
        }
    }
}

@Composable
fun EmptyScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.empty_list_icon,
            ),
            contentDescription = "No movies available",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
        )
        Text(
            text = stringResource(id = R.string.empty_list),
            color = MaterialTheme.colorScheme.primary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
    }

}

@Preview
@Composable
fun EmptyListPreview() {
    EmptyScreen()
}

@Composable
fun PopularMovieItem(navController: NavController, item: Movies) {
    val imageUri = AppConstants.IMAGE_BASE_URL + AppConstants.default_config + item.posterPath

    val model = ImageRequest.Builder(LocalContext.current)
        .data(imageUri)
        .size(Size.ORIGINAL)
        .scale(Scale.FIT)
        .crossfade(true)
        .placeholder(R.drawable.placeholder)
        .build()
    val painter = rememberAsyncImagePainter(model)
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .shadow(10.dp, clip = false, shape = RoundedCornerShape(10.dp))
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable {
                navController.navigate("details/${item.id}")
            },
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,

    )

}

@Composable
fun RegistrationError(hostState: SnackbarHostState, message: String) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(
                    bottom = 20.dp,
                    start = 10.dp,
                    end = 10.dp,
                ),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SnackbarHost(hostState = hostState, modifier = Modifier.fillMaxWidth(), snackbar = {
                Snackbar {
                    Text(
                        text = message,
                        color = Color.White,

                    )

                }
            })
        }
    }

}
