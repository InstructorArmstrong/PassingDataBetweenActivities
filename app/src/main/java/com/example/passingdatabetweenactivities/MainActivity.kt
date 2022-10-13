package com.example.passingdatabetweenactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var colorButton: Button
    lateinit var colorLbl: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        colorButton = findViewById(R.id.button)
        colorLbl = findViewById(R.id.labelTv)

        colorButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            this.startActivity(intent)
        }

        val color = intent.getSerializableExtra("COLOR") as DisplayColor?
        Log.d("ThisISMAIN", color.toString());
        if(color != null){
            colorLbl.text = "Your favorite color is: ${color.colorText}"
        }



    }
}