package com.example.vinicecream.view.fragment

import android.nfc.Tag
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinicecream.R
import com.example.vinicecream.model.Products
import com.example.vinicecream.view.adapter.ProductAdapter
import com.example.vinicecream.view.api.APIServices
import com.example.vinicecream.view.api.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyOrder : Fragment() {

    private var myAdapter: ProductAdapter? = null
    private var myRecyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_order, container, false)

    }


    override fun onResume() {
        //Create a handler for the RetrofitInstance interface
        val service = RestClient.retrofitInstance!!.create(
            APIServices::class.java)
        val call = service.allProducts
        //Execute the request asynchronously.
        call.enqueue(object : Callback<List<Products>> {
            //Handle successfully response
            override
            fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
                loadDataList(response.body())
            }
            //Handle failure
            override
            fun onFailure(call: Call<List<Products>>, throwable: Throwable) {
                Toast.makeText(context, "Unable to load users", Toast.LENGTH_SHORT).show()
            }
        })
        super.onResume()
    }
    private fun loadDataList(productName: List<Products>?) {
       /* myRecyclerView = view?.findViewById(R.id.recyclerProduct)
        myAdapter = ProductAdapter(productName!!)
        val layoutManager = GridLayoutManager(context,3)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = myAdapter*/
    }
}