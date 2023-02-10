package com.example.colormixer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val  submit = findViewById<Button>(R.id.submit)
        val fullname = intent.getStringExtra("fullname")
        var blue = intent.getBooleanExtra("blue", false)
        val red = intent.getBooleanExtra("red", false)
        val yellow = intent.getBooleanExtra("yellow", false)
        if (blue == true && red == true) {
            val result = "blue and red"

            findViewById<TextView>(R.id.colors).text = result
        }
        else if (blue == true && yellow == true) {
            val result = "blue and yellow"

            findViewById<TextView>(R.id.colors).text = result
        }
        else if (red == true && yellow == true) {
            val result = "red and yellow"
            findViewById<TextView>(R.id.colors).text = result
        }


        submit.setOnClickListener {


            val purple = findViewById<CheckBox>(R.id.purple).isChecked
            val green = findViewById<CheckBox>(R.id.green).isChecked
            val orange = findViewById<CheckBox>(R.id.orange).isChecked

            if (blue == true && red == true and purple == true )
            {
                startActivity(Intent(this, Successactivity::class.java))
            }
            else if (blue == true && red == true and purple == false )
            {
                startActivity(Intent(this, FailureActivity::class.java))
            }
            else if (blue == true && yellow == true and green == true )
            {
                startActivity(Intent(this, Successactivity::class.java))
            }
            else if (blue == true && yellow == true and green == false )
            {
                startActivity(Intent(this, FailureActivity::class.java))
            }
            else if (yellow == true && red == true and orange == true )
            {
                startActivity(Intent(this, Successactivity::class.java))
            }
            else if (yellow == true && red == true and purple == false )
            {
                startActivity(Intent(this, FailureActivity::class.java))
            }

            val intent = Intent(this, Successactivity::class.java).apply {
                putExtra("fullname", fullname)

            }
            val intent2 = Intent(this, FailureActivity::class.java).apply {
                putExtra("fullname", fullname)

            }

            startActivity(intent)


        }



    }
}