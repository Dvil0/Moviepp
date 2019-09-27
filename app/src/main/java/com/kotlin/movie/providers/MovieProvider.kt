package com.kotlin.movie.providers

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.kotlin.movie.HomeView
import com.kotlin.movie.adapters.HomeStackAdapter
import com.kotlin.movie.adapters.VolleyCallback
import com.kotlin.movie.dto.MovieDTO
import com.kotlin.movie.dto.MovieList

open class MovieProvider constructor( val context: Context){

    val apiKey: String = "12f76d12c95f1a0b86df28eebc6f58a0"
    var url: String = "api.themoviedb.org"
    val language: String = "en-US"
    var populars: Int = 0
    open var response: String? = null

    fun getPopulars( callback: VolleyCallback){

        var items: ArrayList<MovieDTO> = ArrayList<MovieDTO>()
        val volley = Volley.newRequestQueue( context )
        populars++

        url = "http://$url/3/movie/popular?api_key=$apiKey&language=$language&page=${populars.toString()}"

        val stringRequest = StringRequest( Request.Method.GET,  url,
            Response.Listener<String> { response ->

                callback.onSucess( response )

            }, Response.ErrorListener {

                Log.w("RESPONSE","Failed!")

            })

        volley.add( stringRequest )
    }
}