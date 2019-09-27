package com.kotlin.movie.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.kotlin.movie.R
import com.kotlin.movie.dto.MovieDTO

class HomeStackAdapter: ArrayAdapter<MovieDTO>{

    constructor( context: Context, resource: Int, items: ArrayList<MovieDTO>): super(context,resource, items)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convert = convertView

        if( convert == null) {
            val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convert = inflater.inflate(R.layout.home_item_stack, parent, false)
        }
        val movItem = getItem(position)

        if( movItem != null){
            val img: ImageView = convert!!.findViewById(R.id.imgPoster)

            Glide.with( context ).load(movItem.getPosterImg())
                .placeholder(android.R.drawable.progress_indeterminate_horizontal)
                .error(android.R.drawable.stat_notify_error)
                .into(img)

        }

        return convert!!
    }
}