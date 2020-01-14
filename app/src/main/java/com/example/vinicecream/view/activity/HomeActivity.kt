package com.example.vinicecream.view.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vinicecream.R
import com.example.vinicecream.model.Products
import com.example.vinicecream.view.fragment.Home
import com.example.vinicecream.view.fragment.Me
import com.example.vinicecream.view.fragment.MyOrder
import com.example.vinicecream.view.api.APIServices
import com.example.vinicecream.view.adapter.ProductAdapter
import com.example.vinicecream.view.api.RestClient
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        switchTab()
        homeMenu.setItemSelected(getTabId(0))
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
