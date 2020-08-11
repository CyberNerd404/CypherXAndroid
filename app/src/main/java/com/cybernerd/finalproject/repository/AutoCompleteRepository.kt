package com.cybernerd.finalproject.repository

import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.AutoCompleteResponse
import com.cybernerd.finalproject.network.CypherXAPI
import com.cybernerd.finalproject.utils.debug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AutoCompleteRepository(val token : String) {

    var autoCompleteData = MutableLiveData<AutoCompleteResponse>()


    fun getAutoComplete(name : String){
        CypherXAPI().getAutoComplete(token, name).enqueue(object : Callback<List<AutoCompleteResponse>>{
            override fun onFailure(call: Call<List<AutoCompleteResponse>>, t: Throwable) {
                debug("auto","error : ${t.message}")
            }

            override fun onResponse(
                call: Call<List<AutoCompleteResponse>>,
                response: Response<List<AutoCompleteResponse>>
            ) {
                for (res in response.body()!!){
                    autoCompleteData.value = res
                }
            }

        })
    }
}