package classes

class Encapsulation {
    private var name: String = "Musa"
    private val surname: String = "UYUMAZ"

    fun getFullName(): String {
        return "$name $surname"
    }

    fun getName(): String {
        return name
    }

    fun setName(value: String): Unit {
        name = value
    }
}

fun main() {
    val encapsulation = Encapsulation()
//    encapsulation.name = "asdsa"
}