package com.example.roll

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //startActivity(Intent(this@MainActivity, GameActivity.class))
        findViewById<TextView>(R.id.play).setOnClickListener {
            startActivity(Intent(this@MainActivity, GameActivity::class.java))
        }
    }
}