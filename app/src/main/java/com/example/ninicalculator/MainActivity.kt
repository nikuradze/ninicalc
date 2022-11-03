package com.example.ninicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var dot: TextView
    private var operand = 0.0
    private var operation = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.resultTextView)
        dot = findViewById(R.id.Dot)

    }

    fun numberclick(clickedView: View) {

            if (clickedView is TextView) {
                var text = tvResult.text.toString()
                var number = clickedView.text.toString()
                if (text == "0") {
                    text = ""
                }
                val result = text + number
                tvResult.text = result


        }
    }

    fun clrClick(clickedView: View) {
        tvResult.text = "0"
        operand = 0.0

    }

    fun dotclick(clickedView: View){
        if ("." !in tvResult.text.toString()) {
            if (clickedView is TextView) {
                var dot = clickedView.text.toString()
                var num = tvResult.text.toString()

                val result = num + dot
                tvResult.text = result
            }
        }
    }

    fun deleteClick(clickedView: View) {
        var k = tvResult.text.toString()
        tvResult.text = k.dropLast(1)
        if (tvResult.text == "") {
            tvResult.text = "0"

        }

    }


    fun operationclick(clickedView: View) {
        if (clickedView is TextView) {

            if (tvResult.text.toString() != "") {
                operand = tvResult.text.toString().toDouble()
                operation = clickedView.text.toString()
                tvResult.text = ""

            } else {
                operation = clickedView.text.toString()
            }
        }

    }

    fun equalsclick(clickedView: View) {
        val secondOperand = tvResult.text.toString().toDouble()
        var result = ""
        when (operation) {
            "+" -> result = (operand + secondOperand).toString()
            "-" -> result = (operand - secondOperand).toString()
            "*" -> result = (operand * secondOperand).toString()
            "/" -> result = (operand / secondOperand).toString()

        }
        if (result.toString().takeLast(2) == ".0") {
            tvResult.text = result.toString().dropLast(2)
        }else{
            tvResult.text = result
        }





    }
}
