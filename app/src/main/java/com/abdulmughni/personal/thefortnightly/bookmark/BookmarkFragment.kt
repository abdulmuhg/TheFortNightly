package com.abdulmughni.personal.thefortnightly.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abdulmughni.personal.thefortnightly.R

class BookmarkFragment : Fragment() {

    companion object {
        fun newInstance() = BookmarkFragment()
    }

    private lateinit var viewModel: BookmarkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}