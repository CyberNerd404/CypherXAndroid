package com.cybernerd.finalproject.viewModel

import android.app.Application
import android.widget.AutoCompleteTextView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cybernerd.finalproject.model.AutoCompleteResponse
import com.cybernerd.finalproject.repository.AutoCompleteRepository
import com.cybernerd.finalproject.utils.SessionManager

class AutoCompleteViewModel(application: Application): AndroidViewModel(application) {

    lateinit var repository : AutoCompleteRepository
    val autoCompleteData : LiveData<AutoCompleteResponse>

    init {
        repository = SessionManager(application).fetchAuthToken()?.let {
            AutoCompleteRepository(it)
        }!!

        this.autoCompleteData = repository.autoCompleteData
    }

    fun autoCompleteData(name : String){
        repository.getAutoComplete(name)
    }
}