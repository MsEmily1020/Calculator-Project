package com.example.calcproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide() // My Application Bar 숨김
        result = findViewById<TextView>(R.id.text)
        title = "계산기"

    }

    // 클릭한 버튼 id로 수행
    fun onClick(view: View) {
        val id = view.resources.getResourceEntryName(view.id)
        for (i in 0..9) {
            if(id == "_${i}") {
                appendNumber(true, i.toString())
            }
        }
    }

    private fun appendNumber(isNumber: Boolean, value: String) {
        if (isNumber) {
            if (result.text == "0") result.text = value
            else result.append(value)
        }
    }
}