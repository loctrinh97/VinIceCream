package com.example.vinicecream.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.vinicecream.R
import com.example.vinicecream.view.activity.LoginActivity
import com.example.vinicecream.view.activity.MapActivity
import com.example.vinicecream.view.activity.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_me.*

class Me:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_me, container, false)
        var loginMe : Button = view.findViewById(R.id.btnLoginMe)
        var btnMyLocation : Button = view.findViewById(R.id.btnMyLocation)

        loginMe.setOnClickListener{
            var intentToLogin  = Intent(activity, LoginActivity::class.java)
            context!!.startActivity(intentToLogin)
            }

        btnMyLocation.setOnClickListener{
            var intentToMap  = Intent(activity, MapActivity::class.java)
            context!!.startActivity(intentToMap)
//            var map = Map()
//            activity!!.supportFragmentManager.beginTransaction().replace(R.id.container_home, map)
//                .commit()
        }

        return view
    }
}