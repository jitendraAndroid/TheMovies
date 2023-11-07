package com.jkhetle.themovies.data.entity

import com.squareup.moshi.Json

data class PopularMoviesResponse(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val movies: List<Movies>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int,
)
