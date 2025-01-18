package classes

class Turtle(mName: String = "Tosbik", mFeetCount: Int = 4) {
    var feetCount: Int = mFeetCount
    val feetColor: String = "Brown"
    val headCount: Int = 1
    val headColor: String = "Brown"
    val shelterColor: String = "Green"
    val tailCount: Int = 1
    val tailColor: String = "Brown"
    val age: Int = 1
    val sex: String = "Female"
    var name: String = mName
    val isMarried: Boolean = true

    init {
        println("Primary constructor created")
    }

//    constructor(isMarried: Boolean = true) : this() {
//        this.isMarried = isMarried
//        println("Secondary constructor created")
//    }

    constructor(mName: String = "Tosbik", mFeetCount: Int = 4, isMarried: Boolean = true) : this(mName, mFeetCount) {
        println("Secondary constructor created")
    }

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
    val turtleTwo: Turtle = Turtle("Murtle")
    val turtleThree: Turtle = Turtle(mFeetCount = 4)
    val turtleFour: Turtle = Turtle("", 4)
    val turtleFive: Turtle = Turtle("", 4, false)
    turtleOne.walk()
}