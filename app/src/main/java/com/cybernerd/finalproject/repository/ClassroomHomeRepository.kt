package com.cybernerd.finalproject.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.ClassroomResponse
import com.cybernerd.finalproject.network.CypherXAPI
import com.cybernerd.finalproject.utils.SessionManager
import com.cybernerd.finalproject.utils.debug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClassroomHomeRepository(val application: Application) {

    val token = MutableLiveData<String>()
    val classroom = MutableLiveData<ClassroomResponse>()


    fun getAllClassroom(){

        CypherXAPI().getClassroom("$token").enqueue(object : Callback<ClassroomResponse>{
            override fun onFailure(call: Call<ClassroomResponse>, t: Throwable) {
                Toast.makeText(application,"Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ClassroomResponse>,
                response: Response<ClassroomResponse>
            ) {

                debug("classroom","${response.body()}")
            }

        })
    }
}