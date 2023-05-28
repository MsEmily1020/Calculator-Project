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

    }

    // 클릭한 버튼 id로 수행
    fun onClick(view: View) {
        val id = view.resources.getResourceEntryName(view.id)

        when(id) {
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
                for (i in 0..9) {
                    if (id == "_${i}") {
                        appendResult(true, i.toString())
                    }
                }
            }
        }
    }

    private fun appendResult(isNumber: Boolean, value: String) {
        if (isNumber) {
            if (result.text == "0") result.text = value
            else result.append(value)
        }

        else {
            if(value == "(" || value == ")") {
                if (result.text == "0") result.text = value
                else result.append(value)
            }

            else if(result.text == "0") {
                Toast.makeText(this, "완성 되지 않은 수식", Toast.LENGTH_SHORT).show()
            }

            else result.append(value)
        }
    }
}