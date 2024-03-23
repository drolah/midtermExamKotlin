package com.example.midtermexamkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private val studentsList = mutableListOf<List<String>>()
    private lateinit var nameEditText: EditText
    private lateinit var courseEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var addButton: Button
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.name)
        courseEditText = findViewById(R.id.course)
        ageEditText = findViewById(R.id.age)
        addressEditText = findViewById(R.id.address)
        addButton = findViewById(R.id.addButton)
        listView = findViewById(R.id.studentData)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        listView.adapter = adapter

        addButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val course = courseEditText.text.toString()
            val age = ageEditText.text.toString()
            val address = addressEditText.text.toString()

            val studentInfo = listOf(name, course, age, address)
            studentsList.add(studentInfo)

            // Update the ListView
            adapter.add(name)
            adapter.notifyDataSetChanged()

            clearInputFields()
        }

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedStudentInfo = studentsList[position]

            val intent = Intent(this, SecondScreen::class.java).apply {
                putExtra("name", selectedStudentInfo[0]) // Pass the name
                putExtra("course", selectedStudentInfo[1]) // Pass the course
                putExtra("age", selectedStudentInfo[2]) // Pass the age
                putExtra("address", selectedStudentInfo[3]) // Pass the address
            }
            startActivity(intent)
        }
    }

    private fun clearInputFields() {
        nameEditText.text.clear()
        courseEditText.text.clear()
        ageEditText.text.clear()
        addressEditText.text.clear()
    }
}

