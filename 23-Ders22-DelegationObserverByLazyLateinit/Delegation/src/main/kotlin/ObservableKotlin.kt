package org.example

import kotlin.properties.Delegates

class User3 {
    var name: String by Delegates.observable("<no name>") { property, oldValue, newValue ->
        println("Name changed from $oldValue to $newValue")
    }

    var surName: String by Delegates.observable("<no surname>") { property, oldValue, newValue ->
        println("Surname changed from $oldValue to $newValue")
    }

    var age: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
        println("Age changed from $oldValue to $newValue")
        newValue >= 18
    }
}

fun main() {
    val user = User3()

    user.name = "Musa"
    user.surName = "Uyumaz"
    user.age = 15
    println("age : ${user.age}")

    user.name = "Gençay"
    user.surName = "Yıldız"
    user.age = 32
    println("age : ${user.age}")


}