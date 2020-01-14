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

class ProductAdapter (private val context: Context, private val dataList: List<Products>) : RecyclerView.Adapter<ProductAdapter.CustomViewHolder>(){
    inner class CustomViewHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
        var imgProduct: ImageView = myView.findViewById(R.id.imageViewProduct)
        var textProduct: TextView = myView.findViewById(R.id.textViewProductName)
        var price: TextView = myView.findViewById(R.id.textViewProductPrice)
    }

    // inflate layout for item of recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.fragment_product_item, parent, false)
        return CustomViewHolder(view)
    }

    //Set data for item of recyclerview
    override
    fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.textProduct.text = dataList[position].productName
        holder.price.text = dataList[position].price
        Glide.with(context).load(dataList[position].images).into(holder.imgProduct)
    }

    //Calculate the item count for the recyclerview
    override fun getItemCount(): Int {
        return dataList.size
    }
}