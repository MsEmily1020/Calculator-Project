package com.example.calcproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide() // My Application Bar 숨김
        title = "계산기"
        result = findViewById<TextView>(R.id.text)

        val initBtn = findViewById<Button>(R.id.AC)
        initBtn.setOnClickListener {
            result.text = "0"
        }
    }

    // 클릭한 버튼 id로 수행
    fun onClick(_view: View) {
        when(val id = _view.resources.getResourceEntryName(_view.id)) {
            "plus" -> appendResult(false, "+")          // 덧셈
            "subtract" -> appendResult(false, "-")      // 뺄셈
            "X" -> appendResult(false, "X")             // 곱셈
            "division" -> appendResult(false, "/")      // 나누기(몫)
            "remain" -> appendResult(false, "%")        // 나누기(나머지)
            "bracket1" -> appendResult(false, "(")      // 괄호 열기
            "bracket2" -> appendResult(false, ")")      // 괄호 닫기
            "_." -> appendResult(false, ".")            // 소수점
            
            // 숫자 버튼
            else -> {
                val number = id.substring(1).toIntOrNull()
                if (number != null && number in 0 .. 9) {
                    appendResult(true, number.toString())
                }
            }
        }
    }

    private fun appendResult(isNumber: Boolean, value: String) {
        if (isNumber) {
            result.text = if (result.text == "0") value else result.text.toString() + value
        }

        else {
            if(value == "(" || value == ")") {
                result.text = if (result.text == "0") value else result.text.toString() + value
            }

            else if(result.text != "0") {
                result.append(value)
            }

            else Toast.makeText(this, "완성 되지 않은 수식", Toast.LENGTH_SHORT).show()
        }
    }
}