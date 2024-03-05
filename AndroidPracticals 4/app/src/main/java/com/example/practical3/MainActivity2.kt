package com.example.practical3

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.confirmationTextView
import kotlinx.android.synthetic.main.activity_main2.saveButton
import kotlinx.android.synthetic.main.activity_main2.usernameEditText

class MainActivity2 : AppCompatActivity()
{
    private lateinit var sharedPreferences: SharedPreferences
    private val sharedPrefFile = "my_sharedprefs_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        // Check if data is already saved in SharedPreferences
        if (sharedPreferences.contains("username")) {
            // If data is present, display it
            val savedUsername = sharedPreferences.getString("username", "")
            usernameEditText.setText(savedUsername)
        }

        // Save button click listener
        saveButton.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        // Get username from EditText
        val username = usernameEditText.text.toString()

        // Save username to SharedPreferences
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.apply()

        // Display confirmation message
        confirmationTextView.text = "Data saved successfully"
    }

}