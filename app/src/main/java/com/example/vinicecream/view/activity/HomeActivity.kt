package com.example.vinicecream.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vinicecream.R
import com.example.vinicecream.view.fragment.IceCreamDetail

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var iceCreamDetail = IceCreamDetail()
        supportFragmentManager.beginTransaction().add(R.id.container_home,iceCreamDetail).commit()
    }
}
