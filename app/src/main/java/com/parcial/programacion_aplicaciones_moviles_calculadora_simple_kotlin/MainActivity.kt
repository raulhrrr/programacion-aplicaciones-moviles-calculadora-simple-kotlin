package com.parcial.programacion_aplicaciones_moviles_calculadora_simple_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var arithmeticOperations: ArithmeticOperations? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arithmeticOperations = ArithmeticOperations()

        val add = findViewById<Button>(R.id.add)
        val subtract = findViewById<Button>(R.id.subtract)
        val multiply = findViewById<Button>(R.id.multiply)
        val divide = findViewById<Button>(R.id.divide)
        val factorial = findViewById<Button>(R.id.factorial)
        val fibonacci = findViewById<Button>(R.id.fibonacci)
        val history = findViewById<Button>(R.id.mainHistory)

        add.setOnClickListener {
            onClickSum()
        }
        subtract.setOnClickListener {
            onClickSubtract()
        }
        multiply.setOnClickListener {
            onClickMultiply()
        }
        divide.setOnClickListener {
            onClickDivide()
        }
        factorial.setOnClickListener {
            onClickFactorial()
        }
        fibonacci.setOnClickListener {
            onClickFibonacci()
        }

        history.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MainHistory::class.java
                )
            )
        }
    }

    @SuppressLint("SetTextI18n")
    fun getNumbers(): Boolean {
        val txtNum1 = findViewById<EditText>(R.id.num1)
        val txtNum2 = findViewById<EditText>(R.id.num2)
        val result = findViewById<TextView>(R.id.result)

        val s1 = txtNum1.text.toString()
        val s2 = txtNum2.text.toString()

        if (s1 == "" && s2 == "") {
            result.text = "Ingrese los números necesarios para la operación"
            return false
        }
        if (s1 == "") {
            result.text = "Ingrese el número 1"
            return false
        }
        if (s2 == "") {
            result.text = "Ingrese el número 2"
            return false
        }
        arithmeticOperations!!.num1 = s1.toFloat()
        arithmeticOperations!!.num2 = s2.toFloat()
        return true
    }

    private fun addCalculationInHistory(operation: String?) {
        val result = findViewById<TextView>(R.id.result)
        ArithmeticOperations.addCalculation(
            java.lang.String.format(
                Locale.getDefault(),
                "%f %s %f = %s",
                arithmeticOperations!!.num1,
                operation,
                arithmeticOperations!!.num2,
                result!!.text
            )
        )
    }

    @SuppressLint("SetTextI18n")
    fun onClickSum() {
        val result = findViewById<TextView>(R.id.result)
        if (getNumbers()) {
            result!!.text = arithmeticOperations!!.sum().toString()
            addCalculationInHistory("+")
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClickSubtract() {
        val result = findViewById<TextView>(R.id.result)
        if (getNumbers()) {
            result!!.text = arithmeticOperations!!.subtract().toString()
            addCalculationInHistory("-")
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClickMultiply() {
        val result = findViewById<TextView>(R.id.result)
        if (getNumbers()) {
            result!!.text = arithmeticOperations!!.multiplyRecursively(
                arithmeticOperations!!.num1,
                arithmeticOperations!!.num2
            ).toString()
            addCalculationInHistory("*")
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClickFactorial() {
        val result = findViewById<TextView>(R.id.result)
        if (getNumbers()) {
            result!!.text = arithmeticOperations!!.factorial(
                arithmeticOperations!!.num1.toInt(),
                arithmeticOperations!!.num2.toInt()
            ).toString()
            addCalculationInHistory("!")
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClickFibonacci() {
        val result = findViewById<TextView>(R.id.result)
        if (getNumbers()) {
            result!!.text = arithmeticOperations!!.fibonacci(
                arithmeticOperations!!.num1.toInt(),
                arithmeticOperations!!.num2.toInt()
            )
            addCalculationInHistory("Fibonacci")
        }
    }

    @SuppressLint("SetTextI18n")
    fun onClickDivide() {
        val result = findViewById<TextView>(R.id.result)
        if (arithmeticOperations!!.num2 == 0.0f) {
            result!!.text = "No se puede dividir entre 0"
        }
        if (getNumbers() && arithmeticOperations!!.num2 != 0.0f) {
            result!!.text = arithmeticOperations!!.divide().toString()
            addCalculationInHistory("/")
        }
    }

}