package com.example.a7279.mvvmtestrxjavaretrofit.model.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

data class MovieBean(
    val count: Int,
    val movies: List<Movy>,
    val totalCinemaCount: Int,
    val totalComingMovie: Int,
    val totalHotMovie: Int
)
@Entity(tableName = "movy")
data class Movy(
    @PrimaryKey
    @ColumnInfo(name = "Id")
    var movieId: Int=0,
    @ColumnInfo(name = "nameCn")
    var titleCn: String="",
    @ColumnInfo(name = "nameEn")
    var titleEn: String="",
    var type: String="",
    var actorName1: String="",
    var actorName2: String="",
    var commonSpecial: String="",
    var directorName: String="",
    var img: String="",
    @Ignore
    val btnText: String="",
    @Ignore
    val is3D: Boolean=false,
    @Ignore
    val isDMAX: Boolean=false,
    @Ignore
    val isFilter: Boolean=false,
    @Ignore
    val isHot: Boolean=false,
    @Ignore
    val isIMAX: Boolean=false,
    @Ignore
    val isIMAX3D: Boolean=false,
    @Ignore
    val isNew: Boolean=false,
    @Ignore
    val length: Int=0,
    @Ignore
    val nearestShowtime: NearestShowtime?=null,
    @Ignore
    val preferentialFlag: Boolean=false,
    @Ignore
    val rDay: Int=0,
    @Ignore
    val rMonth: Int=0,
    @Ignore
    val rYear: Int=0,
    @Ignore
    val ratingFinal: Double=0.0,
    @Ignore
    val wantedCount: Int=0
)/*{
    constructor():this(0)
}*/

data class NearestShowtime(
    val isTicket: Boolean,
    val nearestCinemaCount: Int,
    val nearestShowDay: Int,
    val nearestShowtimeCount: Int
)