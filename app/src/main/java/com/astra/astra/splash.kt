package com.astra.astra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed(
            Runnable {
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            },3000
        )


    }//ends oncreate
}//ends class