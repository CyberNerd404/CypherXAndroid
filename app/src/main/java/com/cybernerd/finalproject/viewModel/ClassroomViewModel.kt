package com.cybernerd.finalproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cybernerd.finalproject.model.ClassroomResponse
import com.cybernerd.finalproject.repository.ClassroomHomeRepository

class ClassroomViewModel(application: Application) : AndroidViewModel(application){

    val classroomlist : LiveData<ClassroomResponse>
    val repository = ClassroomHomeRepository(application)

    init {
        this.classroomlist = repository.classroom
    }
}