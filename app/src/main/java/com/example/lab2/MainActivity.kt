package com.example.lab2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.spinner)
        val countButton: Button = findViewById(R.id.countButton)
        val editText: EditText = findViewById(R.id.editText)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        val spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.count_options, android.R.layout.simple_spinner_item)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter
        countButton.setOnClickListener {
            val text = editText.text.toString().trim()
            if (text.isEmpty()) {
                Toast.makeText(this, R.string.empty_text_warning, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val textCounter = Counter()
            val countResult = when (spinner.selectedItemPosition) {
                0 -> textCounter.countWords(text)
                1 -> textCounter.countCharacters(text)
                else -> 0
            }
            resultTextView.visibility = View.VISIBLE
            resultTextView.text = getString(R.string.result, countResult)
        }
    }
}