package com.example.practical7.practical7_B

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practical7.R

class MainActivity2 : AppCompatActivity() {

    lateinit var cameraOpenId: Button
    lateinit var clickImageId: ImageView
    val pic_id = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        cameraOpenId = findViewById(R.id.camera_button)
        clickImageId = findViewById(R.id.click_image)


        cameraOpenId.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, pic_id)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == pic_id) {
            val photo = data!!.extras!!["data"] as Bitmap?
            clickImageId.setImageBitmap(photo)
        }
    }

}