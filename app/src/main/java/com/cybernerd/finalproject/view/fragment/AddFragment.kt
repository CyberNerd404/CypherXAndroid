package com.cybernerd.cypherxandroid.ui.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.adapter.ConversationAdapter
import com.cybernerd.finalproject.viewModel.ConversationViewModel
import kotlinx.android.synthetic.main.fragment_add.*

/**
 * A simple [Fragment] subclass.
 */
class AddFragment : Fragment() {

    private lateinit var viewmodel : ConversationViewModel
    private lateinit var conversationAdapter : ConversationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_add, container, false)


        viewmodel = ViewModelProvider(this).get(ConversationViewModel::class.java)

        conversationAdapter = ConversationAdapter(context!!)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewmodel.getConversationList()
        viewmodel.conversationList.observe(viewLifecycleOwner, Observer {
            conversationAdapter.setConversationList(it.details)
        })
        rv_add.adapter = conversationAdapter

        super.onViewCreated(view, savedInstanceState)
    }



}
