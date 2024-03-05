package com.example.practical5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Practical5_B : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical5_b)

        // Start the service
        val serviceIntent = Intent(this, MyService::class.java)
        startService(serviceIntent)


        val stopService_btn = findViewById<Button>(R.id.stopService_btn)

        stopService_btn.setOnClickListener {
            stopService(serviceIntent)
        }
    }
}