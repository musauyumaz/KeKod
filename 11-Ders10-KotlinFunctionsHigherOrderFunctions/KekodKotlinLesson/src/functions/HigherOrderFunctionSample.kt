package functions

fun main() {
    calculateAndPrintNormal(2, 4, '*')
    calculateAndPrintNormal(5, 44, '+')
    calculateAndPrintNormal(55, 5, '/')
    calculateAndPrintNormal(112, 434, '-')

    calculateAndPrint(2, 4, { numberOne, numberTwo -> numberOne * numberTwo })
    calculateAndPrint(5, 44, { numberOne, numberTwo -> numberOne + numberTwo })
    calculateAndPrint(55, 11, { numberOne, numberTwo -> numberOne / numberTwo })
    calculateAndPrint(112, 434, { numberOne, numberTwo -> numberOne - numberTwo })
    calculateAndPrint(21, 2, { numberOne, numberTwo -> numberOne % numberTwo })


}

fun calculateAndPrintNormal2(numberOne: Int, numberTwo: Int, operation: Char) {

    val sumFunction = { number1: Int, number2: Int ->
        number1 + number2
    }
    val minusFunction = fun(number1: Int, number2: Int): Int {
        return number1 - number2
    }

    val multiplyFunction = (fun(number1: Int, number2: Int): Int = number1 * number2)

    when (operation) {
        '+' -> calculateAndPrint(numberOne, numberTwo, { numberOne, numberTwo -> numberOne + numberTwo })
        '+' -> calculateAndPrint(numberOne, numberTwo) { numberOne, numberTwo -> numberOne + numberTwo }
        '+' -> calculateAndPrint(numberOne, numberTwo, sumFunction)

        '-' -> calculateAndPrint(numberOne, numberTwo, { numberOne, numberTwo -> numberOne - numberTwo })
        '-' -> calculateAndPrint(numberOne, numberTwo, minusFunction)

        '*' -> calculateAndPrint(numberOne, numberTwo, { numberOne, numberTwo -> numberOne * numberTwo })
        '*' -> calculateAndPrint(numberOne, numberTwo, multiplyFunction)

        '/' -> calculateAndPrint(numberOne, numberTwo, { numberOne, numberTwo -> numberOne / numberTwo })
        '/' -> calculateAndPrint(numberOne, numberTwo, ::divFunction)
        '/' -> calculateAndPrint(numberOne, numberTwo, ::divFunction2)

    }

    calculateAndPrint4(3, 45)
    calculateAndPrint7(2, 5, {
        it.plus(4)
    })

    calculateAndPrint9(2, 5, { numberOne, numberTwo ->
        println("$this: $numberOne, $numberTwo")
        45
    })
}

fun divFunction(numberOne: Int, numberTwo: Int): Int {
    return numberOne / numberTwo
}

fun divFunction2(numberOne: Int, numberTwo: Int): Int = numberOne / numberTwo


fun calculateAndPrintNormal(numberOne: Int, numberTwo: Int, operation: Char) {
    val result = when (operation) {
        '+' -> {
            numberOne + numberTwo
        }

        '-' -> {
            numberOne - numberTwo
        }

        '*' -> {
            numberOne * numberTwo
        }

        '/' -> {
            numberOne / numberTwo
        }

        '%' -> {
            numberOne % numberTwo
        }

        else -> {
            numberOne + numberTwo
        }
    }
    println("Result $result")
}

fun calculateAndPrint(numberOne: Int, numberTwo: Int, operation: (numberOne: Int, numberTwo: Int) -> Int) {
    println("Result : ${operation(numberOne, numberTwo)}")
}

fun calculateAndPrint4(
    numberOne: Int = 3,
    numberTwo: Int = 4,
    operation: (Int, Int) -> Int = { numberOne, numberTwo -> numberOne + numberTwo }
) {
    println("Result : ${operation(numberOne, numberTwo)}")
}

fun calculateAndPrint5(
    numberOne: Int = 3,
    numberTwo: Int = 4,
    operation: (Int, Int) -> Int = ::privateSum
) {
    println("Result : ${operation(numberOne, numberTwo)}")
}

fun calculateAndPrint7(
    numberOne: Int = 3,
    numberTwo: Int = 4,
    operation: (Int) -> Int
) {
    println("Result : ${operation(numberOne)}")
}

fun calculateAndPrint9(
    numberOne: Int = 3,
    numberTwo: Int = 4,
    operation: String.(Int, Int) -> Int
) {
    println("Result : ${operation("Sayılar", numberOne, numberTwo)}")
}

fun privateSum(numberOne: Int, numberTwo: Int): Int {
    return numberOne + numberTwo
}