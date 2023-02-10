package com.example.colormixer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FailureActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_failure)
        val  button_quit = findViewById<Button>(R.id.quit)

        val fullname = intent.getStringExtra("fullname")

        val result = "Soory $fullname !"
        findViewById<TextView>(R.id.NameFailure).text = result

        button_quit.setOnClickListener {



            val intent = Intent(this, MainActivity::class.java).apply {

            }
            startActivity(intent)
        }
    }
}