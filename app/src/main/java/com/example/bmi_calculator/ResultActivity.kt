package com.example.bmi_calculator

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : $height, weight : $weight")

        val bmi = weight / (height / 100.0).pow(2.0) //Math.pow(height/100.0, 2.0)로도 사용함(자바)
        val resultText = when{
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "정도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val bmiResultTextView = findViewById<TextView>(R.id.bmiResult_tv)
        val resultTextView = findViewById<TextView>(R.id.result_tv)

        bmiResultTextView.text = bmi.toString()
        resultTextView.text = resultText
    }
}