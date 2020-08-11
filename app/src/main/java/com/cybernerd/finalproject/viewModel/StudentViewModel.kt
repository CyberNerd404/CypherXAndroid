package com.cybernerd.finalproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.StudentResponse
import com.cybernerd.finalproject.repository.StudentRepository
import com.cybernerd.finalproject.utils.SessionManager

class StudentViewModel(application: Application): AndroidViewModel(application), StudentRepository.StudentResponseInterface{

    private var repository: StudentRepository

    val studentLiveData : MutableLiveData<StudentResponse>

    init {
        repository = SessionManager(application).fetchAuthToken()?.let {
            StudentRepository(it)
        }!!

        this.studentLiveData = repository.studentLiveData
    }

    fun getAllStudent(){
        repository.getAllStudent(this)
    }

    override fun onSuccess(response: StudentResponse) {
        studentLiveData.value = response
    }

    override fun onFailer(t: Throwable) {

    }


}