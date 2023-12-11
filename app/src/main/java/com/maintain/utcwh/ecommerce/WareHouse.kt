package com.maintain.utcwh.ecommerce

class WareHouse {
    private val wareHouse: HashMap<String, Int> = hashMapOf()

    fun add(product:String, quantity: Int){
        wareHouse[product] = quantity
    }

    fun remove(product: String, quantity: Int): Boolean{
        if (wareHouse.contains(product).not()){
            println("Product not found")
            return false
        }

        if (wareHouse[product] == 0){
            println("No product available")
            return false
        }

        if (wareHouse[product]!! < quantity){
            println("Not enough product")
            return false
        }



        val quantityMain = wareHouse[product]?:0
        wareHouse[product] = quantityMain.minus(quantity)
        return true
    }

    fun getInventory(product: String): Int?{
        return wareHouse[product]
    }
}