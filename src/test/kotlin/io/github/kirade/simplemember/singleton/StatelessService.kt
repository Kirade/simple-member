package io.github.kirade.simplemember.singleton

class StatelessService {
    fun order(name: String, price: Int): Int{
        println("$name, $price")
        return price
    }
}