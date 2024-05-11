package io.github.kirade.simplemember.singleton

class StatefulService {

    var price: Int? = null

    fun order(name:String,  price: Int) {
        println("$name, $price")
        this.price = price
    }



}