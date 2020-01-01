package com.example.vinicecream.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.vinicecream.R
import com.example.vinicecream.view.fragment.Home
import com.example.vinicecream.view.fragment.Me
import com.example.vinicecream.view.fragment.MyOrder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        switchTab()
        homeMenu.setItemSelected(getTabId(0))
      //  actionViewFlipper()
    }

    fun actionViewFlipper() {
        var adsArray: ArrayList<String> = ArrayList()
        adsArray.add("https://icecreamandshop.com/images/slide101.0cab2ddd4a06cea0.jpg")
        adsArray.add("https://icecreamandshop.com/images/slide105.d61a79903895e7b2.jpg")
        adsArray.add("https://icecreamandshop.com/images/slide102.df0f0ec716e466e3.jpg")
        adsArray.add("https://icecreamandshop.com/images/slide103.55735ac132a08805.jpg")
        for (i in 0 until adsArray.size step 1) {
            var imageView: ImageView = ImageView(this)
            Picasso.with(applicationContext).load(adsArray.get(i)).into(imageView)
            imageView.setScaleType(ImageView.ScaleType.FIT_XY)
            viewFlipperAds.addView(imageView)
        }
        viewFlipperAds.setFlipInterval(5000)
        viewFlipperAds.setAutoStart(true)

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
