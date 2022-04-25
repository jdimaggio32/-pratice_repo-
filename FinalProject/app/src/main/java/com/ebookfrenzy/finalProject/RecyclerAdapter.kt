package com.ebookfrenzy.finalProject

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.blue
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.finalProject.databinding.ActivityMainBinding
import com.ebookfrenzy.finalProject.databinding.CardLayoutBinding
import com.google.android.material.snackbar.Snackbar


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val image = R.drawable.trash

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         var itemImage: ImageView
         var itemTitle: TextView
         var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.trashImage)
            itemTitle = itemView.findViewById(R.id.name)
            itemDetail = itemView.findViewById(R.id.phoneNumber)

            itemView.setOnClickListener { v: View ->

                var position: Int = getAdapterPosition()
                Snackbar.make(
                    v, "Deleting Item $position",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()

                FirstFragment().nameArray.removeAt(position)

            }

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)

        return ViewHolder(v)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

         var nameArray = FirstFragment().getNArray()
         var phoneArray = FirstFragment().getPArray()

        viewHolder.itemTitle.text = nameArray[i]
        viewHolder.itemDetail.text = phoneArray[i]
        viewHolder.itemImage.setImageResource(image)

    }

    override fun getItemCount(): Int {
        var nameArray = FirstFragment().getNArray()

        return nameArray.size
    }

}

