package com.example.bmi_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

/**
 * 이 프로젝트를 하면서 공부한 것.
 * 1. 변수 설정 (변수타입을 미리 선언한 것, 선언하지 않은 것의 차이
 * 2. XML의 ID값을 변수로 불러오는 것
 * 3. setOnclickListener의 기본 타입 작성하는 법
 * 4. 변수에 XML값을 저장하는 법
 * 5. Intent 사용해서 다른 액티비티로 값을 옮기고 이동하는 법
 * PS. 다른 엑티비티를 만들때 항상 메니페스트에도 추가할 것
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 변수타입을 미리 정해서 사용하는 경우
        val heightEditText: EditText = findViewById(R.id.height_et)

        // 변수타입을 미리 정하지 않는 경우에는 findViewById를 사용할때 제네릭으로 타입을 설정해 줘야 한다.
        val weightEditText = findViewById<EditText>(R.id.weight_et)
        val resultButton = findViewById<Button>(R.id.confirm_btn)

        resultButton.setOnClickListener {
            Log.d("MainActivity", "ResultButton 이 클릭되었습니다.")

            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                //빈값이 발생하여 클릭리스너를 빠져나감
                return@setOnClickListener
            }

            val height: Int = heightEditText.text.toString().toInt()
            val weight = weightEditText.text.toString().toInt()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            startActivity(intent)
        }
    }
}