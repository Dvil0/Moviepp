package com.kotlin.movie.dto

import com.google.gson.annotations.SerializedName

class MovieDTO{
    var  uniqueId: String? = null
        get() = field
        set(value) { field = value }

//    val popularity: Double,
//    val voteCount: Int,
//    val video: Boolean,
    @SerializedName("poster_path")
    var posterPath: String? = null
        get() = field
        set(value) { field = value }
//    val id: Int,
//    val adult: Boolean,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null
        get() = field
        set(value) { field = value }
//    val originalLanguage: String,
//    val originalTitle: String,
//    val genreIds: Array<Int>,
    var title: String? = null
        get() = field
        set(value){ field = value}
//    val voteAverage: Double,
//    val overview: String,
//    val releaseDate: String

    open fun getPosterImg(): String{

        if( posterPath.isNullOrEmpty() ){
            return "https://cdn11.bigcommerce.com/s-gho61/stencil/31cc7cb0-5035-0136-2287-0242ac11001b/e/3dad8ea0-5035-0136-cda0-0242ac110004/images/no-image.svg"
        } else{
            return "https://image.tmdb.org/t/p/w500/$posterPath"
        }
    }

    open fun getBackgroundImage(): String{
        if( posterPath.isNullOrEmpty() ){
            return "https://cdn11.bigcommerce.com/s-gho61/stencil/31cc7cb0-5035-0136-2287-0242ac11001b/e/3dad8ea0-5035-0136-cda0-0242ac110004/images/no-image.svg"
        } else{
            return "https://image.tmdb.org/t/p/w500/$backdropPath"
        }
    }
}

open class MovieList{

    @SerializedName("results")
    open var movieList: ArrayList<MovieDTO> = ArrayList()
        get() = field

}