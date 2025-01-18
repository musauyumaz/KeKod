package classes

class Turtle(val Name: String = "Tosbik", var feetCount: Int = 4) {
    var feetColor: String = "Brown"
        set(value) {
            field = value
        }
        get(): String {
            return field
        }
    val headCount: Int = 1
    val headColor: String = "Brown"
    val shelterColor: String = "Green"
    val tailCount: Int = 1
    val tailColor: String = "Brown"
    val age: Int = 1
    val sex: String = "Female"
    val isMarried: Boolean = true

    init {
        println("Primary constructor created")
    }

    constructor(isMarried: Boolean) : this() {
        println("Secondary constructor created")
    }

    constructor(mName: String = "Tosbik", mFeetCount: Int = 4, isMarried: Boolean = true) : this(mName, mFeetCount) {
        println("Secondary constructor created")
    }

    fun makeASound(): String {
        return "adsadsadas"
    }

    fun eatMeal(): Unit {

    }

    fun walk(): Unit {
        feetCount
    }

    fun swim(): Unit {

    }
}

fun main() {
    val turtleOne: Turtle = Turtle()
    turtleOne.feetCount = 3
    val turtleTwo: Turtle = Turtle("Murtle")
    val turtleThree: Turtle = Turtle(mFeetCount = 4)
    val turtleFour: Turtle = Turtle("", 4)
    val turtleFive: Turtle = Turtle("", 4, false)
    val turtleSix: Turtle = Turtle(false)
    turtleOne.walk()
}