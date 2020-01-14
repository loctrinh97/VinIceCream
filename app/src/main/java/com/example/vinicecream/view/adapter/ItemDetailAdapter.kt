package com.example.vinicecream.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vinicecream.R
import com.example.vinicecream.model.Products


class ItemDetailAdapter (private val context: Context, private val dataList: List<Products>) : RecyclerView.Adapter<ItemDetailAdapter.CustomDetailHolder>(){
        inner class CustomDetailHolder(
            //Get a reference to the Views in our layout
            myView: View
        ) : RecyclerView.ViewHolder(myView) {
            var imgItemDetail: ImageView = myView.findViewById(R.id.imgItemDetail)
            var dtProductName: TextView = myView.findViewById(R.id.dtProductName)
            var dtDescription: TextView = myView.findViewById(R.id.dtDescription)
            var dtPrice: TextView = myView.findViewById(R.id.dtPrice)
        }
        // inflate layout for item of recyclerview
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomDetailHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.fragment_ice_cream_detail, parent, false)
            return CustomDetailHolder(view)
        }

        //Calculate the item count for the recyclerview
        override fun getItemCount(): Int {
            return dataList.size
        }

        override fun onBindViewHolder(holder: CustomDetailHolder, position: Int) {
            holder.dtProductName.text = dataList[position].productName
            holder.dtPrice.text = dataList[position].price
            holder.dtDescription.text = dataList[position].desctiption
            Glide.with(context).load(dataList[position].images).into(holder.imgItemDetail)
        }

}
