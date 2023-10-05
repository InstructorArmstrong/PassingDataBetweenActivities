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

        // Initialize the button and TextView elements by finding their corresponding views in the layout
        colorButton = findViewById(R.id.button)
        colorLbl = findViewById(R.id.labelTv)

        // Set a click listener for the colorButton
        colorButton.setOnClickListener {
            // Create an intent to navigate to the DetailActivity
            val intent = Intent(this, DetailActivity::class.java)
            // Start the DetailActivity using the intent
            this.startActivity(intent)
        }

        // Retrieve data (a DisplayColor object) from the intent sent from DetailActivity
        // This will be null at first that why we check for null on line 38
        val color = intent.getSerializableExtra("COLOR") as DisplayColor?

        // Log the received color object for debugging purposes
        Log.d("ThisISMAIN", color.toString())

        // Check if a color object was received from the intent
        if (color != null) {
            // Update the TextView to display the received color's text
            colorLbl.text = "Your favorite color is: ${color.colorText}"
        }
    }
}
//
// Explanation of key parts:
//
// lateinit var colorButton: Button and lateinit var colorLbl: TextView: These are member variables
// declared as lateinit, indicating that they will be initialized later in the code. They will hold
// references to the Button and TextView elements in the activity's layout.
//
// onCreate(savedInstanceState: Bundle?): This is the override of the onCreate method, which is called
// when the activity is created. In this method, the activity's layout is set to R.layout.activity_main.
//
// colorButton.setOnClickListener { ... }: This sets a click listener for the colorButton element.
// When the button is clicked, it creates an intent to navigate to DetailActivity and starts that
// activity.
//
// val color = intent.getSerializableExtra("COLOR") as DisplayColor?: This line retrieves data
// (a Serializable object) from the intent that started this activity. It expects the data to be
// associated with the key "COLOR" and casts it to a DisplayColor object. If the data is not found or
// cannot be cast to DisplayColor, it will be null.
//
// Log.d("ThisISMAIN", color.toString()): This logs the received color object for debugging purposes.
//
// if (color != null) { ... }: It checks if the color object is not null. If a valid color object was
// received from the intent, it updates the colorLbl TextView to display a message with the received
// color's text.
//
// The code is designed to receive a color selection from DetailActivity and display it in the main
// activity when the button is clicked.
