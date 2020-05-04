package com.example.fullcovid19.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fullcovid19.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.navHost, NavFragment())
            .commit()
    }
}
