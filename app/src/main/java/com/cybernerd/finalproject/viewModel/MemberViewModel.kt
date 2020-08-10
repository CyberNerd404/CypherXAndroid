package com.cybernerd.finalproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cybernerd.finalproject.model.User
import com.cybernerd.finalproject.repository.MemberRepository
import com.cybernerd.finalproject.utils.SessionManager

class MemberViewModel(application: Application): AndroidViewModel(application) {

    private lateinit var repository: MemberRepository
    val memberLiveData : LiveData<User>


    init {
        repository = SessionManager(application).fetchAuthToken()?.let {
            MemberRepository(it)
        }!!

        this.memberLiveData = repository.memberLiveData
    }

    fun getMember(){
        repository.getMember()
    }

}