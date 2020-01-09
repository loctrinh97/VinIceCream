package com.example.vinicecream.view.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinicecream.R
import com.example.vinicecream.model.Products
import com.example.vinicecream.viewmodel.APIServices
import com.example.vinicecream.view.adapter.ProductAdapter
import com.example.vinicecream.viewmodel.RestClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : Fragment() {
    private var myAdapter: ProductAdapter? = null
    private var myRecyclerView: RecyclerView? = null
    private var imageList = intArrayOf(R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var mView = LayoutInflater.from(context).inflate(R.layout.fragment_home, container, false)
        val viewFlipper = mView.findViewById<ViewFlipper>(R.id.viewFlipper)
        if (viewFlipper != null) {
            viewFlipper.setInAnimation(context, android.R.anim.slide_in_left)
            viewFlipper.setOutAnimation(context, android.R.anim.slide_out_right)
        }

        if (viewFlipper != null) {
            for (image in imageList) {
                val imageView = ImageView(context)
                val layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                layoutParams.setMargins(30, 30, 30, 30)
                layoutParams.gravity = Gravity.CENTER
                imageView.layoutParams = layoutParams
                imageView.setImageResource(image)
                imageView.setScaleType(ImageView.ScaleType.FIT_XY)
                viewFlipper.addView(imageView)
            }
        }
        return mView

    }


    override fun onResume() {
        //Create a handler for the RetrofitInstance interface
        val service = RestClient.retrofitInstance!!.create(APIServices::class.java)

        val call = service.allUsers

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
    private fun loadDataList(usersList: List<Products>?) {
        myRecyclerView = view?.findViewById(R.id.recyclerProduct)
        myAdapter =
            ProductAdapter(usersList!!)
        val layoutManager = GridLayoutManager(context,3)
        //LinearLayoutManager(this@HomeActivity)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = myAdapter
    }
}