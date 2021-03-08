package com.abdulmughni.personal.thefortnightly.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdulmughni.personal.thefortnightly.R
import com.abdulmughni.personal.thefortnightly.core.data.Resource
import com.abdulmughni.personal.thefortnightly.core.ui.ArticleAdapter
import com.abdulmughni.personal.thefortnightly.core.ui.ViewModelFactory
import com.abdulmughni.personal.thefortnightly.databinding.HomeFragmentBinding
import com.abdulmughni.personal.thefortnightly.detail.DetailFragment

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val articleAdapter = ArticleAdapter()
            articleAdapter.onItemClick = { selectedData ->
//                val intent = Intent(activity, DetailFragment::class.java)
//                intent.putExtra(DetailFragment.EXTRA_DATA, selectedData)
//                startActivity(intent)
            }

            val factory = ViewModelFactory.getInstance(requireActivity())
            homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

            homeViewModel.article.observe(viewLifecycleOwner, { article ->
                if (article != null) {
                    when (article) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            articleAdapter.setData(article.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text = article.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            })

            with(binding.rvArticle) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = articleAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}