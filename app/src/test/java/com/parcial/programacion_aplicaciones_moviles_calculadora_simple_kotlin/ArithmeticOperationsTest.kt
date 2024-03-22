package com.parcial.programacion_aplicaciones_moviles_calculadora_simple_kotlin

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ArithmeticOperationsTest {

    private var arithmeticOperations: ArithmeticOperations? = null

    @Before
    fun setUp() {
        arithmeticOperations = ArithmeticOperations()
    }

    @Test
    fun sum() {
        arithmeticOperations!!.num1 = 1.0f
        arithmeticOperations!!.num2 = 2.0f
        assertEquals(3.0f, arithmeticOperations!!.sum(), 0.0f)
    }

    @Test
    fun subtract() {
        arithmeticOperations!!.num1 = 1.0f
        arithmeticOperations!!.num2 = 2.0f
        assertEquals(-1.0f, arithmeticOperations!!.subtract(), 0.0f)
    }

    @Test
    fun multiply() {
        arithmeticOperations!!.num1 = 1.0f
        arithmeticOperations!!.num2 = 2.0f
        assertEquals(2.0f, arithmeticOperations!!.multiply(), 0.0f)
    }

    @Test
    fun multiplyRecursively() {
        assertEquals(15.0f, arithmeticOperations!!.multiplyRecursively(3f, 5f), 0.0f)
    }

    @Test
    fun factorial() {
        assertEquals(120, arithmeticOperations!!.factorial(5, 1))
    }

    @Test
    fun fibonacci() {
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55", arithmeticOperations!!.fibonacci(0, 10))
    }

    @Test
    fun divide() {
        arithmeticOperations!!.num1 = 1.0f
        arithmeticOperations!!.num2 = 2.0f
        assertEquals(0.5f, arithmeticOperations!!.divide(), 0.0f)
    }
}