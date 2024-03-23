package com.example.midtermexamkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondScreen : AppCompatActivity() {
    private lateinit var backButton: Button
    private lateinit var nameTextView: TextView
    private lateinit var courseTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var addressTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        backButton = findViewById(R.id.backButton)
        nameTextView = findViewById(R.id.name)
        courseTextView = findViewById(R.id.course)
        ageTextView = findViewById(R.id.age)
        addressTextView = findViewById(R.id.address)

        backButton.setOnClickListener {
            onBackPressed()
        }

        // Retrieve student information from intent extras
        val name = intent.getStringExtra("name")
        val course = intent.getStringExtra("course")
        val age = intent.getStringExtra("age")
        val address = intent.getStringExtra("address")

        // Set text to TextViews
        nameTextView.text = "Name: $name"
        courseTextView.text = "Course: $course"
        ageTextView.text = "Age: $age"
        addressTextView.text = "Address: $address"
    }
}

