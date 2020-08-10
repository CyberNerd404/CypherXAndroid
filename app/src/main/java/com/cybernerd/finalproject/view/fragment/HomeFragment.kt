package com.cybernerd.cypherxandroid.ui.home.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.adapter.ClassroomAdapter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var classroomAdapter: ClassroomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val context : Context = context!!


//        classroomViewModel.classroomlist.observe(viewLifecycleOwner, Observer {
//            classroomAdapter.setClassroom(it.details)
//        })
//
//        classroomAdapter = ClassroomAdapter(context)
//        rv_classroom.adapter = classroomAdapter


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)



    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }




}
