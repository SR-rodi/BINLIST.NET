package com.example.binlistnet.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.binlistnet.R

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_BinlistNet)
        Thread.sleep(300) // имитация долгой загрузки активити
        setContentView(R.layout.activity_main)
    }
}