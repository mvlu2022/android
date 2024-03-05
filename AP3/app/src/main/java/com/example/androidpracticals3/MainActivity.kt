package com.example.androidpracticals3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.buttonFlipPicture

class MainActivity : AppCompatActivity()
{
    lateinit var imageView: ImageView
    lateinit var button: Button
    private val pickImage = 100
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.buttonLoadPicture)

        button.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        buttonFlipPicture.setOnClickListener() {
            // imageView.scaleX = -1f

            // Flip vertically
            imageView.scaleY = -1f

            Toast.makeText(this, "Image Flipped!!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        imageUri = data?.data
        imageView.setImageURI(imageUri)


        imageView.setOnClickListener() {
            Toast.makeText(this, data?.data?.path, Toast.LENGTH_LONG).show()
        }
    }
}