package com.maintain.utcwh

import org.junit.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun add() {
        val calculator = Calculator()
        val expected = 100
        assertEquals(expected, calculator.add(10,90))
    }

    @Test
    fun substraction(){
        val calculator = Calculator()
        val expected = 0
        assertEquals(expected, calculator.substraction(10,10))
    }
}