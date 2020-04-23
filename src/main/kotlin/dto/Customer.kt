package dto

class Customer(
    val userId: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double
) : Comparable<Customer> {

    override fun compareTo(other: Customer): Int {
        return when {
            this.userId > other.userId -> 1
            this.userId < other.latitude -> -1
            else -> 0
        }
    }

}