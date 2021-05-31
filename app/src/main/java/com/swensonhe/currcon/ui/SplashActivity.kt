package com.swensonhe.currcon.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.swensonhe.currcon.R
import com.swensonhe.currcon.ui.latest_rates.LatestRatesActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LatestRatesActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }, 400)
    }
}