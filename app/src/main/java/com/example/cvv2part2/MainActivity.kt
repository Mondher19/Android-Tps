package com.example.cvv2part2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import java.io.ByteArrayOutputStream


class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        // Get a reference to the ImageView in your layout
        imageView = findViewById<ImageView>(R.id.profileimage)

        imageView.setOnClickListener {
            // Create an Intent to pick an image from the gallery
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

            // Start the Intent to pick an image
            startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
        }





        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        supportActionBar?.apply {
            title = "Create your resume"
            setDisplayUseLogoEnabled(true)

        }

        val goToSecondActivityBtn = findViewById<Button>(R.id.Nextbtn)
        goToSecondActivityBtn.setOnClickListener {

            val fullname = findViewById<EditText>(R.id.fullname).text.toString()
            val email = findViewById<EditText>(R.id.email).text.toString()
            val age = findViewById<EditText>(R.id.age).text.toString()

            val byteArray = intent.getByteArrayExtra("profileimage")
            val bitmap = byteArray?.let { it1 -> BitmapFactory.decodeByteArray(byteArray, 0, it1.size) }
            val profileimage = findViewById<ImageView>(R.id.profileimage)
            profileimage.setImageBitmap(bitmap)


            val intent = Intent(this, secondActivity::class.java).apply {
                putExtra("fullname", fullname)
                putExtra("email", email)
                putExtra("age", age)
                putExtra("profileimage", byteArray)

            }


            startActivity(intent)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return true
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check if the requestCode matches the REQUEST_CODE_PICK_IMAGE
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            // Get the URI of the selected image
            val imageUri = data?.data

            // Set the selected image as the new image for the ImageView
            imageView.setImageURI(imageUri)
        }
    }
    companion object {
        private const val REQUEST_CODE_PICK_IMAGE = 100
    }
}

