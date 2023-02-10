package com.example.colormixer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class Successactivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successactivity)
        val  button_quit = findViewById<Button>(R.id.quit)
        val fullname = intent.getStringExtra("fullname")

        val result = "Congratulation $fullname !"
        findViewById<TextView>(R.id.NameFailure).text = result


        button_quit.setOnClickListener {



            val intent4 = Intent(this, MainActivity::class.java).apply {
                putExtra("fullname", "")
                putExtra("blue",false)
                putExtra("red", false)
                putExtra("yellow", false)
                putExtra("green",false)
                putExtra("orange", false)
                putExtra("purple", false)
            }
            startActivity(intent4)
        }


    }
}