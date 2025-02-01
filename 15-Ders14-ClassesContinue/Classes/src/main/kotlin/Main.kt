package org.example

fun main() {
    InitOrDemo("Hello")
    Customer("Musa")
    Person3("Musa", "Uyumaz")
    Person3("Musa", "Uyumaz", false)
}

class Person(firstName: String) {}

class Empty

class InitOrDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints hello")
    }

    val secondaryProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Customer(name: String) {
    val customerKey = name.uppercase().also(::println)
}

class Person2(val firstName: String, val lastName: String, var age: Int)

class Person3(val firstName: String, val lastName: String, var isEmployed: Boolean = true, )

//class Customer2 public @Inject constructor(name:String){}