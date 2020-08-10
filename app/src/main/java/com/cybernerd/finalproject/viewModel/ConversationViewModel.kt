package com.cybernerd.finalproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.cybernerd.finalproject.model.ConversationList
import com.cybernerd.finalproject.repository.ConversationRepository
import com.cybernerd.finalproject.utils.SessionManager

class ConversationViewModel(application: Application): AndroidViewModel(application) {

    lateinit var repository : ConversationRepository

    val conversationList: LiveData<ConversationList>

    init {

       repository = SessionManager(application).fetchAuthToken()?.let {
           ConversationRepository(it)
       }!!
        this.conversationList = repository.recieverList

    }

    fun getConversationList(){
        repository.getRecieverList()
    }

}