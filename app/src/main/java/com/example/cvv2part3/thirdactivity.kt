package com.example.cvv2part3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class thirdactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thirdactivity)



        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        val educationbtn = findViewById<Button>(R.id.educationbtn)
        educationbtn.setOnClickListener {
            val fragment = Education()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentthirdAct, fragment).commit()
        }

        val experiencebtn = findViewById<Button>(R.id.experiencebtn)
        experiencebtn.setOnClickListener {
            val fragment = experience()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentthirdAct, fragment).commit()
        }




        toolbar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white))
        supportActionBar?.apply {
            title = "Your Career"
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
                    .replace(R.id.fragmentthirdAct, fragment)
                    .commit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}