package org.example

fun main() {
    val simple: Int?
    val inferredType = 1
    val aObject = A()
    aObject.counter = 5
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

//    val area2 get() = this.width * this.height
//
//    fun getArea2(): Int = this.width * this.height

    val name = "Musa"
    val surname = "UYUMAZ"
    var age: Int = 25

    var fullname: String = "asdasd"
        //        get(): String {
//            return "${name.uppercase()} ${surname.uppercase()}"
//        }
        get():String {
            field
            return age.toString()
        }
        set(value) {
            field
            age = value.toInt()
        }

    var counter = 0
        set(value) {
            if (value >= 0)
                field = value
        }

}

class A {

    var counter = 0
        set(value) {
            if (value >= 0) {
                println("adsad")
                field = value
            }
        }

}

val size = 10

interface X {
    val isEmpty: Boolean
        get() = size == 0

//    val isEmpty2 : Boolean = true
//        get() = size == 0

    companion object {
        val name = "adsadasdsa"

//        val isEmpty2 : Boolean = true
//            get() = size == 0
    }
}

private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
    get() {
        if(_table == null){
            _table = HashMap()
        }
        return _table ?: throw AssertionError("")
    }

const val SUBSYSTEM_DEPRACATED: String = "This is depracated"
@Deprecated(SUBSYSTEM_DEPRACATED) fun foo(){}