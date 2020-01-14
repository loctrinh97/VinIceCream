package com.example.vinicecream.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.vinicecream.R
import com.example.vinicecream.model.Profile
import com.example.vinicecream.model.User
import com.example.vinicecream.view.api.APIServices
import com.example.vinicecream.view.api.RestClient
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    var nameSignUp : EditText? = null
    var phoneSignUp : EditText? = null
    var emailSignUp : EditText? = null
    var passwordSignUp : EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        nameSignUp = findViewById(R.id.userNameSignUp)
        phoneSignUp = findViewById(R.id.phoneSignUp)
        emailSignUp = findViewById(R.id.emailSignUp)
        passwordSignUp = findViewById(R.id.passwordSignUp)

    }


    fun onSignUp(view: View){
        val signUpName = nameSignUp!!.text.toString()
        val signUpPhone = phoneSignUp!!.text.toString()
        val signUpEmail = emailSignUp!!.text.toString()
        val signUpPassword = passwordSignUp!!.text.toString()


        var userSignUp =  Profile()
        userSignUp.email = signUpEmail
        userSignUp.numberphone = signUpPhone
        userSignUp.password = signUpPassword
        userSignUp.userName = signUpName
        userSignUp.role = "CUSTOMER"
        userSignUp.total_cash = 0.0f
        userSignUp.birthday = "2019/12/20"
        userSignUp.gender ="true"


        val service = RestClient.retrofitInstance!!.create(APIServices::class.java)
        var signUp=service.createUser(userSignUp)

        signUp.enqueue(object : Callback<Profile> {
            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                var userSignUp=response.body()
                if(userSignUp==null){
                    signUpNotification.visibility=View.VISIBLE
                }else{
//                    logInNotification.setText("Sign up success").toString()
                    var intent=Intent(this@SignUpActivity,LoginActivity::class.java)
                    intent.putExtra("userSignUpId", userSignUp.id)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<Profile>, t: Throwable) {
                signUpNotification.visibility=View.VISIBLE
            }
        })

    }
}
