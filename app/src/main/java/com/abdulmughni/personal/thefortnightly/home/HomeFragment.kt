package com.abdulmughni.personal.thefortnightly.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abdulmughni.personal.thefortnightly.R

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}