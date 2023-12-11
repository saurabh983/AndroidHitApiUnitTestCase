package com.maintain.utcwh.ecommerce

class Order(private val product: String, private val quantity: Int) {
    private lateinit var wareHouse: WareHouse
    private var isFilled = false

    fun fill(wareHouse: WareHouse){
        this.wareHouse = wareHouse
        isFilled = wareHouse.remove(product,quantity)
    }

    fun isFilled(): Boolean{
        return isFilled
    }
}