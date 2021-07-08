package com.ziesapp.kuesionerin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doFirstRunCheckup()
    }

    private fun doFirstRunCheckup() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}