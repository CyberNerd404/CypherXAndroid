package com.cybernerd.finalproject.repository

import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.ConversationList
import com.cybernerd.finalproject.network.CypherXAPI
import com.cybernerd.finalproject.utils.debug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConversationRepository(val token : String) {

    var recieverList = MutableLiveData<ConversationList>()

    fun getRecieverList(){

        CypherXAPI().getConversationList(token).enqueue(object : Callback<ConversationList>{
            override fun onFailure(call: Call<ConversationList>, t: Throwable) {
                debug("chat","error : ${t.message}")
            }

            override fun onResponse(
                call: Call<ConversationList>,
                response: Response<ConversationList>
            ) {
                recieverList.value = response.body()
//                debug("chat","success : ${response.body()}")
            }

        })
    }
}