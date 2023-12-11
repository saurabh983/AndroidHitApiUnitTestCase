package com.maintain.utcwh.ecommerce

import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.BeforeEach
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class OrderTest {

    private val LAPTOP = "Macbook"
    private val MOUSE = "Dell"
    private val wareHouse = WareHouse()

    @Before
    fun setUp() {
        wareHouse.add(LAPTOP,50)
        wareHouse.add(MOUSE,50)
    }

    @Test
    fun `test order is  fulfilled if capacity in warehouse is sufficient`() {
        val order = Order(LAPTOP, 20)
        order.fill(wareHouse)
        assertTrue(order.isFilled())
        assertEquals(30,wareHouse.getInventory(LAPTOP))
    }

    @Test
    fun isFilled() {
    }
}