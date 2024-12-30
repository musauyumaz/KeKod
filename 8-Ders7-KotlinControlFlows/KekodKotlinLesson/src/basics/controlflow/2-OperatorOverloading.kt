package basics.controlflow

data class PairNumber(val numberOne: Int, val numberTwo: Int) {
    operator fun minus(pairNumber: PairNumber): PairNumber {

        val localNumberOne = numberOne - pairNumber.numberOne
        val localNumberTwo = numberTwo - pairNumber.numberTwo

        val returnPairObject = PairNumber(localNumberOne, localNumberTwo)

        println("Sonuc =(${returnPairObject.numberOne}, ${returnPairObject.numberTwo})")

        return returnPairObject
    }

//    operator fun plus(value: Int): Int {
//        return numberOne + value
//    }
}

fun main(args: Array<String>) {
    val a = 5
    val b = 8

    //operatörler arka planda eşleniği olan(corresponding) methodu çağırır
    var result = a + b
    result = a.plus(b)

    val pairNumberOne = PairNumber(2, 4)
    val pairNumberTwo = PairNumber(-8, 11)

    val resultOne = pairNumberOne.numberOne - pairNumberTwo.numberOne
    val resultTwo = pairNumberOne.numberTwo - pairNumberTwo.numberTwo
    println("Sonuç = ($resultOne, $resultTwo)")

//    pairNumberOne + 5

    pairNumberOne - pairNumberTwo
    pairNumberOne.minus(pairNumberTwo)

    val pairNumber = pairNumberOne - pairNumberTwo
    val pairNumber2 = pairNumberOne - pairNumberTwo
    val pairNumber3 = pairNumberOne - pairNumberTwo
    val pairNumber4 = pairNumberOne - pairNumberTwo
    val pairNumber5 = pairNumberOne - pairNumberTwo

//    val pairNumber5 = pairNumberOne.minus(pairNumberTwo)
//    println("Sonuç = (${pairNumber.numberOne}, ${pairNumber.numberTwo})")
}
