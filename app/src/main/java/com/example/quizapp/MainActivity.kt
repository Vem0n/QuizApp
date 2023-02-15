package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById(R.id.userInput)
        val initiatorBtn: Button = findViewById(R.id.initiatorButton)

        initiatorBtn.setOnClickListener {
            if(userInput.text.isEmpty()) {
                Toast.makeText(this, "Enter your name first!", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, userInput.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }


}