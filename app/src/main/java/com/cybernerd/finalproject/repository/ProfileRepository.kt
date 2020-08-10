package com.cybernerd.finalproject.repository

import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.Profile
import com.cybernerd.finalproject.network.CypherXAPI
import com.cybernerd.finalproject.utils.debug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileRepository(val token: String) {

    var profileLiveData = MutableLiveData<Profile>()


    fun getProfile(){
        CypherXAPI().getProfile(token).enqueue(object : Callback<Profile>{
            override fun onFailure(call: Call<Profile>, t: Throwable) {
                debug("profile","error : ${t.message}")
            }

            override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                profileLiveData.value = response.body()
            }

        })
    }

}