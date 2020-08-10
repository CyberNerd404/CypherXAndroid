package com.cybernerd.finalproject.repository

import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.Member
import com.cybernerd.finalproject.model.User
import com.cybernerd.finalproject.network.CypherXAPI
import com.cybernerd.finalproject.utils.debug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MemberRepository(val token : String) {

    var memberLiveData = MutableLiveData<User>()

    fun getMember(){
        CypherXAPI().getMember(token).enqueue(object : Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                debug("member","error : ${t.message}")

            }

            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                memberLiveData.value = response.body()
            }

        })

    }
}