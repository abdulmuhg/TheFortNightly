package com.abdulmughni.personal.thefortnightly.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.abdulmughni.personal.thefortnightly.MyApplication
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import com.abdulmughni.personal.thefortnightly.core.ui.ViewModelFactory
import com.abdulmughni.personal.thefortnightly.databinding.ActivityDetailArticleBinding
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    lateinit var binding: ActivityDetailArticleBinding

    @Inject
    lateinit var factory: ViewModelFactory

    private val detailViewModel: DetailViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailArticle = intent.getParcelableExtra<Article>(EXTRA_DATA)
        showDetailArticle(detailArticle)
    }

    private fun showDetailArticle(article: Article?) {

    }
}