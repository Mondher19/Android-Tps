package com.example.colormixer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  button_mix = findViewById<Button>(R.id.mix)

        button_mix.setOnClickListener {

            val fullname = findViewById<EditText>(R.id.fullname).text.toString()
            val blue = findViewById<CheckBox>(R.id.blue).isChecked
            val red = findViewById<CheckBox>(R.id.red).isChecked
            val yellow = findViewById<CheckBox>(R.id.yellow).isChecked

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("fullname", fullname)
                putExtra("blue", blue)
                putExtra("red", red)
                putExtra("yellow", yellow)
            }
            startActivity(intent)
        }
    }
}