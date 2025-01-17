package functions

fun main() {
    calculate2(2, 54) { numberOne, numberTwo ->
        if (numberTwo == 0) {
            return
        }
        numberOne / numberTwo
    }
}

inline fun calculate2(
    numberOne: Int,
    numberTwo: Int,
    crossinline operation: (Int, Int) -> Int
) {
    logger2(numberOne, numberTwo) { _numberOne, _numberTwo ->
        operation.invoke(_numberOne, _numberTwo)
    }
//    logger2(numberOne,numberTwo,operation)
}

fun logger2(
    numberOne: Int,
    numberTwo: Int,
    operation: (Int, Int) -> Int
) {
    val result = operation(numberOne, numberTwo)
    println("Result : $result")
}