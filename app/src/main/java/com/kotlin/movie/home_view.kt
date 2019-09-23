package com.kotlin.movie

import android.os.Bundle
import com.kotlin.movie.R
import android.widget.StackView
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.movie.adapters.HomeStackAdapter
import com.kotlin.movie.dto.StackItemDTO

class HomeView: AppCompatActivity(){

    private var items = arrayListOf<StackItemDTO>()

    override fun onCreate( savedInstanceState: Bundle?){
        super.onCreate( savedInstanceState )
        setContentView(R.layout.home_layout)

        var stkPosters: StackView = findViewById<StackView>((R.id.stkPosters))

        items.add( StackItemDTO("Image1", this.getDrawable(R.drawable.mahoukaheader03b)))
        items.add( StackItemDTO("Image2", this.getDrawable(R.drawable.be)))
        items.add( StackItemDTO("Image3", this.getDrawable(R.drawable.dragonkillerpantheon)))
        items.add( StackItemDTO("Image4", this.getDrawable(R.drawable.rowsam)))

        val stkAdapter: HomeStackAdapter = HomeStackAdapter(this, R.layout.home_item_stack, items)

        stkPosters.adapter = stkAdapter


    }
}