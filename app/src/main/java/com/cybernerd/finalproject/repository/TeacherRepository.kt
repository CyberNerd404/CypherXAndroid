package com.cybernerd.finalproject.repository

import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.StudentResponse
import com.cybernerd.finalproject.network.CypherXAPI
import com.cybernerd.finalproject.utils.debug
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeacherRepository(val token : String) {

    var teacherLiveData = MutableLiveData<StudentResponse>()


    fun getAllTeacher(teacherResponseInterface: TeacherResponseInterface) {
        CypherXAPI().getAllTeachers(token).enqueue(object : Callback<StudentResponse> {
            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                debug("teacher", "error : ${t.message}")
                teacherResponseInterface.onFailer(t)
            }

            override fun onResponse(
                call: Call<StudentResponse>,
                response: Response<StudentResponse>
            ) {
//                debug("teacher", "response : ${response.body()}")
                if (response.body() != null) {
                    response.body()?.let { teacherResponseInterface.onSuccess(it) }
                    teacherLiveData.value = response.body()
                }
            }

        })
    }

    interface TeacherResponseInterface {

        fun onSuccess(response: StudentResponse)

        fun onFailer(t: Throwable)
    }

}

