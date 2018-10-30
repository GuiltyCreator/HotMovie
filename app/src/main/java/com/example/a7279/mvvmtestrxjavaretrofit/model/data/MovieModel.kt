package com.example.a7279.mvvmtestrxjavaretrofit.model.data

data class MovieBean(
    val count: Int,
    val movies: List<Movy>,
    val totalCinemaCount: Int,
    val totalComingMovie: Int,
    val totalHotMovie: Int
)

data class Movy(
    val actorName1: String,
    val actorName2: String,
    val btnText: String,
    val commonSpecial: String,
    val directorName: String,
    val img: String,
    val is3D: Boolean,
    val isDMAX: Boolean,
    val isFilter: Boolean,
    val isHot: Boolean,
    val isIMAX: Boolean,
    val isIMAX3D: Boolean,
    val isNew: Boolean,
    val length: Int,
    val movieId: Int,
    val nearestShowtime: NearestShowtime,
    val preferentialFlag: Boolean,
    val rDay: Int,
    val rMonth: Int,
    val rYear: Int,
    val ratingFinal: Double,
    val titleCn: String,
    val titleEn: String,
    val type: String,
    val wantedCount: Int
)

data class NearestShowtime(
    val isTicket: Boolean,
    val nearestCinemaCount: Int,
    val nearestShowDay: Int,
    val nearestShowtimeCount: Int
)