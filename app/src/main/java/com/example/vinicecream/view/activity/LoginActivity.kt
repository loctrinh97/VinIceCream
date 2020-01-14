package com.example.vinicecream.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.vinicecream.R
import com.example.vinicecream.model.Products
import com.example.vinicecream.model.User
import com.example.vinicecream.view.api.APIServices
import com.example.vinicecream.view.api.RestClient
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    var loginEmail: EditText? = null
    var loginPassword: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginEmail = findViewById(R.id.emailLogin)
        loginPassword = findViewById(R.id.passwordLogin)


        signUp.setOnClickListener {
            val intent: Intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }


    //onClick SignIn button
    fun funLogin(view: View) {
        val loginEmail = loginEmail!!.text.toString()
        val loginPassword = loginPassword!!.text.toString()

        var userLogin = User()
        userLogin.email = loginEmail
        userLogin.password = loginPassword


        val service = RestClient.retrofitInstance!!.create(APIServices::class.java)
        var login = service.checkLogin(userLogin)

        login.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                var userLogin=response.body()
                if(userLogin==null){
                    logInNotification.visibility=View.VISIBLE
                }else{
                    var intent=Intent(this@LoginActivity,HomeActivity::class.java)
                    intent.putExtra("userLoginId", userLogin.email)
                    startActivity(intent)
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                logInNotification.visibility=View.VISIBLE
            }
        })
    }

}
