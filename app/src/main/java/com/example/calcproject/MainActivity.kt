package com.example.calcproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

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
            result.text = ""
        }
    }

    // 클릭한 버튼 id로 수행
    fun onClick(_view: View) {
        when(val id = _view.resources.getResourceEntryName(_view.id)) {
            "plus" -> appendResult("+")          // 덧셈
            "subtract" -> appendResult("-")      // 뺄셈
            "multiply" -> appendResult("x")      // 곱셈
            "division" -> appendResult("÷")      // 나누기(몫)
            "remain" -> appendResult("%")        // 나누기(나머지)
            "bracket1" -> appendResult("(")      // 괄호 열기
            "bracket2" -> appendResult(")")      // 괄호 닫기
            "_." -> appendResult(".")            // 소수점

            // 숫자 버튼
            else -> {
                val number = id.substring(1).toIntOrNull()
                if (number != null && number in 0 .. 9) {
                    appendResult(number.toString())
                }
            }
        }
    }

    private fun appendResult(value: String) {
        result.append(value)
    }

    fun calculateResult(view: View) {
        try {
            val expressionString = result.text.toString().replace("x", "*").replace("÷", "/")
            val expression = ExpressionBuilder(expressionString).build()
            val calculationResult = expression.evaluate()
            result.text = calculationResult.toString()

            if (isWholeNumber(calculationResult)) {
                result.text = calculationResult.toLong().toString()
            }
        } catch (e: Exception) {
            Log.e("Calculation Error", e.toString())
            Toast.makeText(this, "Calculation error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isWholeNumber(calculationResult: Double): Boolean {
        return calculationResult == calculationResult.toLong().toDouble()
    }

    fun backspace(view: View) {
        val currentText = result.text.toString()
        if (currentText.isNotEmpty()) {
            result.text = currentText.substring(0, currentText.length - 1)
        }
    }

}