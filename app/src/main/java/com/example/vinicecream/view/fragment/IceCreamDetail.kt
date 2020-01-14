package com.example.vinicecream.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.vinicecream.R
import com.example.vinicecream.databinding.FragmentIceCreamDetailBinding
import com.example.vinicecream.model.ProductDetail
import com.example.vinicecream.view.adapter.ItemDetailAdapter
import com.example.vinicecream.view.api.APIServices
import com.example.vinicecream.view.api.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class IceCreamDetail : Fragment() {
    private var iceAdapter: ItemDetailAdapter? = null
    private var myRecyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val valueAction = this.arguments!!.getInt("productID")
        var binding : FragmentIceCreamDetailBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_ice_cream_detail,container,false)
        val view = inflater!!.inflate(R.layout.fragment_ice_cream_detail, container, false)
        val service = RestClient.retrofitInstance!!.create(APIServices::class.java)
        var callProductDetail=service.productDetail(valueAction)
        callProductDetail.enqueue(object : Callback<ProductDetail> {
            override fun onResponse(call: Call<ProductDetail>, response: Response<ProductDetail>) {
                var products=response.body() as ProductDetail
                binding = DataBindingUtil.setContentView(activity!!, R.layout.fragment_ice_cream_detail)
                binding?.setProductsDetail(products)
            }
            override fun onFailure(call: Call<ProductDetail>, t: Throwable) {
                Toast.makeText(context,"Error",Toast.LENGTH_LONG).show()
            }
        })
        return view
    }



}

