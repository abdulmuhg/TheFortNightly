package com.abdulmughni.personal.thefortnightly.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.abdulmughni.personal.thefortnightly.MyApplication
import com.abdulmughni.personal.thefortnightly.R
import com.abdulmughni.personal.thefortnightly.core.ui.ViewModelFactory
import javax.inject.Inject

class DetailFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels {
        factory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as MyApplication).appComponent.inject(this)
    }

    companion object {


        fun newInstance() = DetailFragment()
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}