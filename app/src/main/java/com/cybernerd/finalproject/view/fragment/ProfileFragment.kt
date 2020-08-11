package com.cybernerd.cypherxandroid.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cybernerd.finalproject.R
import com.cybernerd.finalproject.utils.debug
import com.cybernerd.finalproject.viewModel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)


        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.getProfile()
        viewModel.profileLiveData.observe(viewLifecycleOwner, Observer {
//            debug("Profile","Fragment Profile : ${it.user}")
            profileName.text = it.user.first_name
            profileBio.text = it.user.bio
            profileEmail.text = it.user.email
            profileRole.text = it.user.role.role
            profileMobile.text = it.user.mobile
        })

        super.onViewCreated(view, savedInstanceState)
    }

}
