package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val total: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val score: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvScore: TextView = findViewById(R.id.tv_score)
        val tvResult: TextView =  findViewById(R.id.tv_result)
        val btnFinish: Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        tvScore.text = "Your score is $score out of ${total}!"



        btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}