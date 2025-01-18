package functions

fun main() {
    calculate(2, 54) { numberOne, numberTwo ->
        numberOne + numberTwo
    }
}

inline fun calculate(
    numberOne: Int,
    numberTwo: Int,
    noinline operation: (Int, Int) -> Int
) {
    logger(numberOne, numberTwo, operation)
}

fun logger(
    numberOne: Int,
    numberTwo: Int,
    operation: (Int, Int) -> Int
) {
    val result = operation(numberOne, numberTwo)
    println("Result : $result")
}