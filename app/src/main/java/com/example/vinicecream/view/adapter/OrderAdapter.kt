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
import com.example.vinicecream.model.Transaction

class OrderAdapter (private val context: Context, private val dataList: List<Transaction>) : RecyclerView.Adapter<OrderAdapter.CustomOrderHolder>(){
    inner class CustomOrderHolder(
        //Get a reference to the Views in our layout
        myView: View
    ) : RecyclerView.ViewHolder(myView) {
        var imgProduct: ImageView = myView.findViewById(R.id.mOderImageProduct)
        var mOderProductName: TextView = myView.findViewById(R.id.mOderProductName)
        var mOderQuantity: TextView = myView.findViewById(R.id.mOderQuantity)
        var mOderPrice: TextView = myView.findViewById(R.id.mOderPrice)
        var mOderStatus: TextView = myView.findViewById(R.id.mOderStatus)

    }

    // inflate layout for item of recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomOrderHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.fragment_product_item, parent, false)
        return CustomOrderHolder(view)
    }

    //Calculate the item count for the recyclerview
    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: OrderAdapter.CustomOrderHolder, position: Int) {
        holder.mOderProductName.text = dataList[position].productName
        holder.mOderQuantity.text = dataList[position].productName
        holder.mOderPrice.text = dataList[position].productName
        holder.mOderStatus.text = dataList[position].productName
        Glide.with(context).load(dataList[position].images).into(holder.imgProduct)


    }

}