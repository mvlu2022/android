package com.android.myapplication.practical3b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.example.androidpracticals3.R

class Practical3_B : AppCompatActivity()
{
    lateinit var gridView: GridView

    var gridView_Text = arrayOf("iphone 15", "Coming Soon", "Item 3", "Item 4", "Product 5",
                                       "Product 6", "Test Jr", "Test Test", "Logo Logo")

    // Mutable -> Can Change // Immutable -> Cannot Change
    private var gridView_Images = intArrayOf(
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical3_b)

        gridView = findViewById(R.id.gridView)
    //  val gridView = findViewById<GridView>(R.id.gridView)

        
        val mainAdapter = MainAdapter(this, gridView_Text, gridView_Images)
        gridView.adapter = mainAdapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            Toast.makeText(applicationContext, "Item Selected: " + gridView_Text[+position], Toast.LENGTH_SHORT).show()
        }


    }
}