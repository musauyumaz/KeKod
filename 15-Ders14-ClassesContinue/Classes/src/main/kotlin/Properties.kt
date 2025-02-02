package org.example

fun main() {

}

class Address {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"

    var foo: String = "asdsad"
        private set
}

fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name
    result.street = address.street

    return result
}

class Rectangle10(val width: Int, val height: Int) {
    val area: Int
        get() = this.width * this.height

    val area2 get() = this.width * this.height

    fun getArea(): Int = this.width * this.height

    val name = "Musa"
    val surname = "UYUMAZ"
    val age: Int = 25

    val fullname: String
        get(): String {
            return "${name.uppercase()} ${surname.uppercase()}"
        }
        set(value) {}


}

