package com.cybernerd.finalproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.StudentResponse
import com.cybernerd.finalproject.repository.StudentRepository
import com.cybernerd.finalproject.repository.TeacherRepository
import com.cybernerd.finalproject.utils.SessionManager

class TeacherViewModel(application: Application): AndroidViewModel(application), TeacherRepository.TeacherResponseInterface{

    private var repository: TeacherRepository

    val teachertLiveData : MutableLiveData<StudentResponse>

    init {
        repository = SessionManager(application).fetchAuthToken()?.let {
            TeacherRepository(it)
        }!!

        this.teachertLiveData = repository.teacherLiveData
    }


    fun getAllTeacher(){
        repository.getAllTeacher(this)
    }

    override fun onSuccess(response: StudentResponse) {
        teachertLiveData.value = response
    }

    override fun onFailer(t: Throwable) {

    }


}