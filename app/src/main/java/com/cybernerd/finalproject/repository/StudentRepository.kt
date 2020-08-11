package com.cybernerd.finalproject.repository

import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.StudentResponse
import com.cybernerd.finalproject.network.CypherXAPI
import com.cybernerd.finalproject.utils.debug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentRepository(val token : String){

    var studentLiveData = MutableLiveData<StudentResponse>()


    fun getAllStudent(studentResponseInterface: StudentResponseInterface){
        CypherXAPI().getAllStudent(token).enqueue(object : Callback<StudentResponse>{
            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                debug("student","error : ${t.message}")
                studentResponseInterface.onFailer(t)
            }

            override fun onResponse(
                call: Call<StudentResponse>,
                response: Response<StudentResponse>
            ) {
//                debug("student","response : ${response.body()}")

                if (response.body() != null) {
                    response.body()?.let { studentResponseInterface.onSuccess(it) }
                    studentLiveData.value = response.body()
                }
            }

        })
    }

    interface StudentResponseInterface{

        fun onSuccess(response : StudentResponse)

        fun onFailer(t: Throwable)
    }

}