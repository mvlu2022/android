package com.example.practical5

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkInternetCode(this)
    }

    fun checkConnectivity(view: View) {
        checkInternetCode(this)
    }

    fun checkInternetCode(mainActivity: MainActivity) {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo= connectivityManager.activeNetworkInfo

        if (networkInfo != null && networkInfo.isConnected) {
            if (networkInfo.type == ConnectivityManager.TYPE_MOBILE) {
                Toast.makeText(this, "Device connected to Mobile data", Toast.LENGTH_LONG).show()
            }

            if (networkInfo.type == ConnectivityManager.TYPE_WIFI) {
                Toast.makeText(this,"Device connected to WiFi", Toast.LENGTH_LONG).show()
            }
        }
        else {
            Toast.makeText(this,"You are Offline", Toast.LENGTH_LONG).show()
        }
    }
}