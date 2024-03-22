package com.parcial.programacion_aplicaciones_moviles_calculadora_simple_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainClean : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_clean)

        val clean = findViewById<Button>(R.id.cleanHistory)
        val main = findViewById<Button>(R.id.mainActivity2)
        val history = findViewById<Button>(R.id.mainHistory2)

        clean.setOnClickListener { ArithmeticOperations.clearHistory() }

        main.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )
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
}