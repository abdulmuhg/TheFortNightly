package com.abdulmughni.personal.thefortnightly.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import com.abdulmughni.personal.thefortnightly.databinding.ActivityDetailArticleBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailArticleActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    lateinit var binding: ActivityDetailArticleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArticleBinding.inflate(layoutInflater)
        supportActionBar?.title = "Detail"
        setContentView(binding.root)

        val detailArticle = intent.getParcelableExtra<Article>(EXTRA_DATA)
        showDetailArticle(detailArticle)
    }

    private fun showDetailArticle(article: Article?) {
        article?.apply {
            Glide.with(this@DetailArticleActivity)
                .load(article.thumbnail)
                .into(binding.thumbnail)
            binding.title.text = this.title
            binding.authorName.text = this.byLine
            binding.description.text = this.abstracts
            binding.publishTimeText.text = this.publishedDate
            binding.section.text = this.section
            binding.subsection.text = this.subsection

            binding.btnRead.setOnClickListener {
                val intent = Intent(this@DetailArticleActivity, DetailReadArticleActivity::class.java)
                intent.putExtra(DetailReadArticleActivity.EXTRA_URL, article.url)
                startActivity(intent)
            }
        }

    }
}