package com.example.practical6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animation_rtl: Animation = AnimationUtils.loadAnimation(this, R.anim.left_to_right)
        val animation_ltr: Animation = AnimationUtils.loadAnimation(this, R.anim.right_to_left)
        val animation_bounce: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce)


        val bounceButton: Button = findViewById(R.id.bounceButton)
        val normalButton: Button = findViewById(R.id.normalButton)
        val leftToRight_Button: Button = findViewById(R.id.leftToRight_Button)
        val rightToLeft_Button: Button = findViewById(R.id.rightToLeft_Button)

        bounceButton.setOnClickListener {
            // start the animation on click of button
            bounceButton.startAnimation(animation_bounce)
        }

        normalButton.setOnClickListener {

        }

        leftToRight_Button.setOnClickListener {
            // start the animation on click of button
            leftToRight_Button.startAnimation(animation_ltr)
        }

        rightToLeft_Button.setOnClickListener {
            // start the animation on click of button
            rightToLeft_Button.startAnimation(animation_rtl)
        }
    }
}