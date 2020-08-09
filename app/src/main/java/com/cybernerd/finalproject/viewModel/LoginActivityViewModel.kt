package com.cybernerd.finalproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cybernerd.finalproject.model.LoginResponse
import com.cybernerd.finalproject.repository.ClassroomHomeRepository
import com.cybernerd.finalproject.repository.LoginActivityRepository

class LoginActivityViewModel(application: Application): AndroidViewModel(application) {


    private val repository = LoginActivityRepository(application)
    val showprogress : LiveData<Boolean>
    val loginData : LiveData<LoginResponse>
    val classroomRepository = ClassroomHomeRepository(application)
    val tokenData : LiveData<String>

    init {
        this.showprogress = repository.showProgress
        this.loginData = repository.loginData
        this.tokenData = classroomRepository.token
    }

    fun login(email: String, password: String){
        repository.login(email,password)
    }

    fun getToken(token: String){
        classroomRepository.token.value = token
    }
}