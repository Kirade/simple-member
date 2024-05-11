package io.github.kirade.simplemember.order

interface OrderService {
    fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order
}