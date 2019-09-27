package com.kotlin.movie

import android.os.Bundle
import android.util.Log
import android.widget.StackView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.kotlin.movie.adapters.HomeStackAdapter
import com.kotlin.movie.adapters.VolleyCallback
import com.kotlin.movie.dto.MovieDTO
import com.kotlin.movie.dto.MovieList
import com.kotlin.movie.providers.MovieProvider
import kotlin.system.measureTimeMillis

class HomeView: AppCompatActivity(){

    private var items = arrayListOf<MovieDTO>()
    private var stkPosters: StackView? = null
    private var stkAdapter: HomeStackAdapter? = null

    override fun onCreate( savedInstanceState: Bundle?){
        super.onCreate( savedInstanceState )
        setContentView(R.layout.home_layout)

        val stkPosters: StackView = findViewById<StackView>((R.id.stkPosters))

        stkAdapter = HomeStackAdapter(this, R.layout.home_item_stack, items)

        val provider = MovieProvider( this )

        provider.getPopulars( object: VolleyCallback{
            override fun onSucess( resp: String) {
                val movList = Gson().fromJson( resp, MovieList::class.java)
                val list = movList.movieList
                for( mov in list ){
                    items.add( mov )
                }
                stkPosters.adapter = stkAdapter
                stkAdapter?.notifyDataSetChanged()
            }
        })
    }
}