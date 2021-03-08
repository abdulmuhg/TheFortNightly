package com.abdulmughni.personal.thefortnightly

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    private val loadingTime = 3000

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        Glide.with(this)
            .load(R.drawable.fortnightly)
            .into(fortnightly_img)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }, loadingTime.toLong())
    }
}