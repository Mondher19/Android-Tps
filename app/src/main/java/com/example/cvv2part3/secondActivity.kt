package com.example.cvv2part3

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.cvv2part3.R

class secondActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val fullname = intent.getStringExtra("fullname")
        val email = intent.getStringExtra("email")
        val age = intent.getStringExtra("age")
        val byteArray = intent.getByteArrayExtra("profileimage")
        val bitmap = byteArray?.let { BitmapFactory.decodeByteArray(byteArray, 0, it.size) }
        val profileimage = findViewById<ImageView>(R.id.profileimage)
        profileimage.setImageBitmap(bitmap)

        findViewById<TextView>(R.id.fullname).text = fullname
        findViewById<TextView>(R.id.email).text = email



        val skillsbtn = findViewById<Button>(R.id.skillsbtn)
        skillsbtn.setOnClickListener {
            val fragment = Skills()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentSecondAct, fragment).commit()
        }

        val hobbiesbtn = findViewById<Button>(R.id.hobbiesbtn)
        hobbiesbtn.setOnClickListener {
            val fragment = Hobbies()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentSecondAct, fragment).commit()
        }

        val languagesbtn = findViewById<Button>(R.id.languagesbtn)
        languagesbtn.setOnClickListener {
            val fragment = Languages()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentSecondAct, fragment).commit()
        }

        val goToThirdActivityBtn = findViewById<Button>(R.id.thirdbtn)
        goToThirdActivityBtn.setOnClickListener {
            val intent = Intent(this, thirdactivity::class.java)
            startActivity(intent)
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        supportActionBar?.apply {
            title = "Create your resume"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        // Get a reference to the ImageView in your layout

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.infobtn -> {
                val fragment = aboutme()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentSecondAct, fragment)
                    .commit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
