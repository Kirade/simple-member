package io.github.kirade.simplemember.order

class Order(
    val memberId: Long,
    val itemName: String,
    val itemPrice: Int,
    val discountPrice: Int,
) {
    fun calculatePrice(): Int {
        return itemPrice - discountPrice
    }

    override fun toString(): String {
        return """
            Order{memberId=$memberId, itemName=$itemName, itemPrice=$itemPrice, discountPrice=$discountPrice}
        """.trimIndent()
    }
}
