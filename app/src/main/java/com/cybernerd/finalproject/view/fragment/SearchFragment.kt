package com.cybernerd.cypherxandroid.ui.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.adapter.MemberAdapter
import com.cybernerd.finalproject.viewModel.MemberViewModel
import kotlinx.android.synthetic.main.fragment_search.*


/**
 * A simple [Fragment] subclass.
 */
class SearchFragment : Fragment() {
    private lateinit var memberViewModel: MemberViewModel

    private lateinit var memberAdapter: MemberAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        memberViewModel = ViewModelProvider(this).get(MemberViewModel::class.java)
        memberAdapter = MemberAdapter(context!!)

        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        memberViewModel.getMember()
        memberViewModel.memberLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null){
                memberAdapter.setMember(it)
            }
        })
        rv_members.adapter = memberAdapter

        super.onViewCreated(view, savedInstanceState)
    }

}
