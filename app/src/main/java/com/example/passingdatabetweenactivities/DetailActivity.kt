package com.example.passingdatabetweenactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// Define a constant key for passing data between activities
const val COLOR = "COLOR"

class DetailActivity : AppCompatActivity() {
    lateinit var userInput: EditText
    lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Initialize the userInput and saveBtn elements by finding their corresponding views in the layout
        userInput = findViewById(R.id.editTextColor)
        saveBtn = findViewById(R.id.button2)

        // Set a click listener for the saveBtn
        saveBtn.setOnClickListener {
            // Check if the userInput field is not empty
            if (userInput.text.isNotEmpty()) {
                // Create an intent to navigate back to the MainActivity
                val intent = Intent(this, MainActivity::class.java)

                // Log the entered user input for debugging purposes
                Log.d("DETAILACT", userInput.text.toString())

                // Create a DisplayColor object using the user input and put it into the intent
                val color = DisplayColor(userInput.text.toString())
                intent.putExtra(COLOR, color)

                // Start the MainActivity with the intent, passing the color data
                this.startActivity(intent)
            } else {
                // Show a Toast message if the user input field is empty
                Toast.makeText(this, "Please enter your favorite color!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

// Explanation of key parts:
//
// const val COLOR = "COLOR": This line defines a constant key named "COLOR" that will be used to pass
// data between activities.
//
// onCreate(savedInstanceState: Bundle?): This is the override of the onCreate method for
// DetailActivity. It's called when the activity is created. In this method, the activity's layout
// is set to R.layout.activity_detail.
//
// userInput = findViewById(R.id.editTextColor) and saveBtn = findViewById(R.id.button2): These lines
// initialize the userInput EditText and saveBtn Button elements by finding their corresponding views
// in the layout.
//
// saveBtn.setOnClickListener { ... }: This sets a click listener for the saveBtn button. When the
// button is clicked, it checks if the userInput field is not empty. If it's not empty, it creates an
// intent to navigate back to the MainActivity, logs the user input, creates a DisplayColor object
// with the user input, adds it to the intent using the "COLOR" key, and starts the MainActivity. If
// the user input is empty, it shows a Toast message prompting the user to enter their favorite color.




