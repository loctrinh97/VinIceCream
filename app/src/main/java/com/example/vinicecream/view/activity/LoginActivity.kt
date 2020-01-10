package com.example.vinicecream.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.vinicecream.R
import com.example.vinicecream.model.User
import com.example.vinicecream.view.api.APIServices
import com.example.vinicecream.view.api.RestClient
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    var userName: TextView? = null
    var password: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userName = findViewById(R.id.account)
        password = findViewById(R.id.password)


        signUp.setOnClickListener {
            val intent: Intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
//        signIn.setOnClickListener {
//            val intent: Intent = Intent(this@LoginActivity, HomeActivity::class.java)
//            startActivity(intent)
//        }
    }


    //onClick SignIn button
    fun funLogin(view: View) {
        val account = userName!!.text.toString()
        val password = password!!.text.toString()

        var userLogin = User()
        userLogin.userName = account
        userLogin.password = password

        val service = RestClient.retrofitInstance!!.create(APIServices::class.java)
        var login=service.checkLogin(userLogin)
        login.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                var userLogin=response.body() as User
                if(userLogin==null){
                    logInNotification.visibility=View.VISIBLE
                }else{
                    var intent=Intent(this@LoginActivity,HomeActivity::class.java)
                    intent.putExtra("userID", userLogin.id)
                    startActivity(intent)
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                logInNotification.visibility=View.VISIBLE
            }
        })
    }

}
