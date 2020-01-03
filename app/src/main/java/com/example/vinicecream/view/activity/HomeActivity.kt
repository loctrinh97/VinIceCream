package com.example.vinicecream.view.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import android.widget.ViewFlipper
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinicecream.R
import com.example.vinicecream.model.Products
import com.example.vinicecream.view.fragment.Home
import com.example.vinicecream.view.fragment.Me
import com.example.vinicecream.view.fragment.MyOrder
import com.example.vinicecream.viewmodel.APIServices
import com.example.vinicecream.view.adapter.ProductAdapter
import com.example.vinicecream.viewmodel.RestClient
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private var myAdapter: ProductAdapter? = null
    private var myRecyclerView: RecyclerView? = null
    private var imageList = intArrayOf(R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four)


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
                Toast.makeText(this@HomeActivity, "Unable to load users", Toast.LENGTH_SHORT).show()
            }
        })
        super.onResume()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        switchTab()
        homeMenu.setItemSelected(getTabId(0))

        val viewFlipper = findViewById<ViewFlipper>(R.id.viewFlipper)
        if (viewFlipper != null) {
            viewFlipper.setInAnimation(applicationContext, android.R.anim.slide_in_left)
            viewFlipper.setOutAnimation(applicationContext, android.R.anim.slide_out_right)
        }

        if (viewFlipper != null) {
            for (image in imageList) {
                val imageView = ImageView(this)
                val layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                layoutParams.setMargins(30, 30, 30, 30)
                layoutParams.gravity = Gravity.CENTER
                imageView.layoutParams = layoutParams
                imageView.setImageResource(image)
                viewFlipper.addView(imageView)
            }
        }






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
                Toast.makeText(this@HomeActivity, "Unable to load users", Toast.LENGTH_SHORT).show()
            }
        })
    }


    private fun loadDataList(usersList: List<Products>?) {
        myRecyclerView = findViewById(R.id.recyclerProduct)
        myAdapter =
            ProductAdapter(usersList!!)
        val layoutManager = GridLayoutManager(this@HomeActivity,3)
            //LinearLayoutManager(this@HomeActivity)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = myAdapter
    }


    private fun getTabId(index: Int) = homeMenu.getChildAt(index).id
    private fun switchTab() {
        homeMenu.setOnItemSelectedListener {
            when (it) {
                R.id.home -> {
                    var home = Home()
                    supportFragmentManager.beginTransaction().replace(R.id.container_home, home)
                        .commit()
                }
                R.id.myOrder -> {
                    var myOrder = MyOrder()
                    supportFragmentManager.beginTransaction().replace(R.id.container_home, myOrder)
                        .commit()
                }
                R.id.me -> {
                    var me = Me()
                    supportFragmentManager.beginTransaction().replace(R.id.container_home, me)
                        .commit()
                }
            }
        }
    }
}
