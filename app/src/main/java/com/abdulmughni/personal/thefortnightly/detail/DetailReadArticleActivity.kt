package com.abdulmughni.personal.thefortnightly.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import com.abdulmughni.personal.thefortnightly.R
import com.abdulmughni.personal.thefortnightly.core.domain.model.Article
import com.abdulmughni.personal.thefortnightly.databinding.ActivityDetailReadArticleBinding
import kotlinx.android.synthetic.main.activity_detail_read_article.*

class DetailReadArticleActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_URL = "extra_url"
    }

    private lateinit var binding: ActivityDetailReadArticleBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailReadArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val url = intent.getStringExtra(EXTRA_URL)

        binding.webView.loadUrl(url.toString())
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onJsAlert(view: WebView, url: String, message: String, result: android.webkit.JsResult): Boolean {
                Toast.makeText(this@DetailReadArticleActivity, message, Toast.LENGTH_LONG).show()
                result.confirm()
                return true
            }
        }
        binding.webView.webChromeClient = WebChromeClient()
    }
}