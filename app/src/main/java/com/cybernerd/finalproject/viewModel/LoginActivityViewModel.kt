package com.cybernerd.finalproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cybernerd.finalproject.model.LoginResponse
import com.cybernerd.finalproject.repository.ClassroomHomeRepository
import com.cybernerd.finalproject.repository.LoginActivityRepository
import com.cybernerd.finalproject.utils.SessionManager

class LoginActivityViewModel(application: Application): AndroidViewModel(application), LoginActivityRepository.LoginActivityResult {



    private val repository = LoginActivityRepository(application)
    val showprogress : LiveData<Boolean>
    val loginData : MutableLiveData<LoginResponse>

    lateinit var classroomRepository : ClassroomHomeRepository


    init {
        this.showprogress = repository.showProgress
        this.loginData = repository.loginData

        classroomRepository = SessionManager(application).fetchAuthToken()?.let {
            ClassroomHomeRepository(
                it
            )
        }!!
    }

    fun login(email: String, password: String){
        repository.login(email,password, this)
    }


    override fun onSuccess(response: LoginResponse) {
        loginData.value = response
        classroomRepository.getAllClassroom()

    }

    override fun onFailer(t: Throwable) {

    }
}