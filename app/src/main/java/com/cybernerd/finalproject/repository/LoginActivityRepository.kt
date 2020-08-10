package com.cybernerd.finalproject.repository

import android.app.Application
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.LoginResponse
import com.cybernerd.finalproject.network.CypherXAPI
import com.cybernerd.finalproject.utils.debug
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val loginData = MutableLiveData<LoginResponse>()


    fun changeState(){
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }


    fun login(email: String, password: String,loginActivityResult: LoginActivityResult){
        showProgress.value = true
        CypherXAPI().login(email, password).enqueue(object : Callback<LoginResponse>{
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                loginActivityResult.onFailer(t)
                showProgress.value = false
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                response.body()?.let { loginActivityResult.onSuccess(it) }
                loginData.value = response.body()
                debug("loginResponse","Response : ${Gson().toJson(response.body())}")
                showProgress.value = false


            }

        })



    }

    interface LoginActivityResult{
        fun onSuccess(response: LoginResponse)

        fun onFailer(t: Throwable)
    }

}