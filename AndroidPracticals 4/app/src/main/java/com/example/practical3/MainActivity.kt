package com.example.practical3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.btnClick_explicit_intent
import kotlinx.android.synthetic.main.activity_main.btnClick_implicit_intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Explicit Intent
        btnClick_explicit_intent.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        // Implicit Intent
        btnClick_implicit_intent.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:1234567890")
            startActivity(intent)

            /*val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com"))
            startActivity(intent)*/
        }
}
}
