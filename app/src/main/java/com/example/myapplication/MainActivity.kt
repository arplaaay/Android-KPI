package com.example.myapplication

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultView: TextView = findViewById(R.id.resultText)
        val okButton: Button = findViewById(R.id.okButton)
        val cancelButton: Button = findViewById(R.id.cancelButton)

        val spinner: Spinner = findViewById(R.id.langSpinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.bebra_arr,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }



        okButton.setOnClickListener {
            val text = spinner.getSelectedItem().toString();
            resultView.text = text
        }

        cancelButton.setOnClickListener {
            resultView.text = ""
        }


    }
}