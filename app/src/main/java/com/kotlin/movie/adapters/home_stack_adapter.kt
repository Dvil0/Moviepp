package com.kotlin.movie.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.movie.R
import com.kotlin.movie.dto.StackItemDTO

class HomeStackAdapter: ArrayAdapter<StackItemDTO>{

    constructor( context: Context, resource: Int, items: ArrayList<StackItemDTO>): super(context,resource, items)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convert = convertView

        if( convert == null) {
            val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convert = inflater.inflate(R.layout.home_item_stack, parent, false)
        }
        val stkItem = getItem(position)

        if( stkItem != null){
            val title: TextView = convert!!.findViewById(R.id.txtTitle) as TextView
            val img: ImageView = convert.findViewById(R.id.imgPoster) as ImageView

            title.text = stkItem.titulo
            img.setImageDrawable(stkItem.img)
        }

        return convert!!
    }
}