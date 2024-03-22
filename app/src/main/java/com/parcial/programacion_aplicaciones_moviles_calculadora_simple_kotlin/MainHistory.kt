package com.parcial.programacion_aplicaciones_moviles_calculadora_simple_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainHistory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_history)

        val historyResult = findViewById<TextView>(R.id.historyResult)
        val result = StringBuilder()

        for (i in ArithmeticOperations.getHistory().size - 1 downTo 0) {
            result.append(ArithmeticOperations.getHistory()[i]).append("\n")
        }

        historyResult.text = result.toString()
        val main = findViewById<Button>(R.id.mainActivity)
        val clean = findViewById<Button>(R.id.mainClean)

        main.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )
        }

        clean.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MainClean::class.java
                )
            )
        }
    }
}