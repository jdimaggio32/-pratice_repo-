package com.ebookfrenzy.recycleviewproject

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.recycleviewproject.R
import com.google.android.material.snackbar.Snackbar

//need a save state for when device is rotated

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var iTitle =""
    var iDetail=""
    var iImage= R.drawable.android_image_1

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
                MainActivity().showDetails(v)

            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    fun  ranNum(): Int {
        val random1 = (0..7).shuffled().last()
        return random1
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        iTitle = Data().getTitles()[ranNum()]
        iDetail = Data().getDetails()[ranNum()]
        iImage = Data().getImages()[ranNum()]

        viewHolder.itemTitle.text = iTitle
        viewHolder.itemDetail.text = iDetail
        viewHolder.itemImage.setImageResource(iImage)
    }

    fun getiTitle(): String {
        return iTitle
    }
    fun getiDetail(): String {
        return iDetail
    }
    fun getiImage(): Int {
        return iImage
    }

    override fun getItemCount(): Int {
        return Data().getTitles().size
    }

}