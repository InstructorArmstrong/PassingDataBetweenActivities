package com.example.passingdatabetweenactivities

// Define a data class for storing color-related data.
data class DisplayColor(
    val colorText: String?
) : java.io.Serializable // This needs to be part of the class so the data can be passed from the detail to the main
