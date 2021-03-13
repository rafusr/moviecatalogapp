package com.dicoding.andikas.moviecatalogapp.model.tvshow

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TvShow(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvShowId")
        val id: Int,

    @ColumnInfo(name = "backdropPath")
        val backdrop_path: String,

    @ColumnInfo(name = "releaseDate")
        val first_air_date: String,

    @ColumnInfo(name = "title")
        val original_name: String,

    @ColumnInfo(name = "overview")
        val overview: String,

    @ColumnInfo(name = "posterPath")
        val poster_path: String,

    @ColumnInfo(name = "favorited")
        var favorited: Boolean
)