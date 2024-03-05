package com.example.practical5

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    private val handler = Handler()
    private val runnable = object : Runnable {
        override fun run() {
            showToast()
            handler.postDelayed(this, 5000) // Toast every 5 seconds
        }
    }

    private fun showToast() {
        Toast.makeText(this, "Service is running", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate() {
        super.onCreate()
        handler.postDelayed(runnable, 0)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}