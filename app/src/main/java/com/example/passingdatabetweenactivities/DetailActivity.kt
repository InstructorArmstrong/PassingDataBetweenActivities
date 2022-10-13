package com.example.passingdatabetweenactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val COLOR = "COLOR"

class DetailActivity : AppCompatActivity() {
    lateinit var userInput: EditText
    lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        userInput = findViewById(R.id.editTextColor)
        saveBtn = findViewById(R.id.button2)


        saveBtn.setOnClickListener {
            if(userInput.text.isNotEmpty()){
                val intent = Intent(this, MainActivity::class.java)
                Log.d("DTAILACT", userInput.text.toString());
                val color = DisplayColor(userInput.text.toString())
                intent.putExtra(COLOR, color)
                this.startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter your favorite color!", Toast.LENGTH_SHORT).show()
            }

        }

    }
}