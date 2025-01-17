package classes

class Turtle {
    val feetCount: Int = 4
    val feetColor: String = "Brown"
    val headCount: Int = 1
    val headColor: String = "Brown"
    val shelterColor: String = "Green"
    val tailCount: Int = 1
    val tailColor: String = "Brown"
    val age: Int = 1
    var name: String = "Tosbik"
    val sex: String = "Female"
    val isMarried: Boolean = true

    fun makeASound(): String {
        return "adsadsadas"
    }

    fun eatMeal(): Unit {

    }

    fun walk(): Unit {

    }

    fun swim(): Unit {

    }
}

fun main() {
    val turtleOne: Turtle = Turtle()
    turtleOne.walk()
    turtleOne.name = "Murtle"
}