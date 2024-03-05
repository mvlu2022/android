package com.example.practical6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.widget.Button
import android.widget.FrameLayout

class Practical_B : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_b)

        val drawing_view_container = findViewById<FrameLayout>(R.id.drawing_view_container)
        val clear_button = findViewById<Button>(R.id.clear_button)

        val drawingView = DrawingView(this@Practical_B, null)
        drawing_view_container.addView(drawingView)

        clear_button.setOnClickListener {
            drawingView.clearDrawing()
        }


    }
}