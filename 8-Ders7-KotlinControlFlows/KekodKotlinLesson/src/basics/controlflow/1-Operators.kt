package basics.controlflow

fun main(args: Array<String>) {
    var numberOne = 10
    val numberTwo = 5

    println("NumberOne : ${numberOne}")
    println("NumberOne : ${numberOne++}")
    println("NumberOne : ${numberOne}")
    println("NumberOne : ${++numberOne}")

    print("${numberOne + numberTwo}")
    print(" ")
    println(numberOne.plus(numberTwo))

    print("${numberOne - numberTwo} ")
    println(numberOne.minus(numberTwo))

    print("${numberOne * numberTwo} ")
    println(numberOne.times(numberTwo))

    print("${numberOne / numberTwo} ")
    println(numberOne.div(numberTwo))

    print("${numberOne % numberTwo} ")
    println(numberOne.rem(numberTwo))

    println("----------------------------------------------------")

    print("Final Notunu Giriniz : ")
    val grade = readLine()!!.toInt()

    val charNote = if (grade == 100) {
        "$grade = AA"
    } else if (grade <= 99 && grade >= 80) {
        "$grade = BB"
    } else if (grade <= 79 && grade >= 50) {
        "$grade = CC"
    } else if (grade <= 49 && grade >= 20) {
        "$grade = D"
    } else if (grade <= 19 && grade >= 0) {
        "$grade = FF"
    } else {
        "$grade = Bulunamadı!!"
    }

    println("----------------------------------------------------")
    println(grade.compareTo(100) == -1)
    println(grade.compareTo(100) == 1)
    println(grade.compareTo(100) == 0)
    println(grade.equals(100))
    println(grade.equals(100))
    println(!grade.equals(100))

    println(charNote)

    /*
    * a > b a.compareTo(b) > 0 | 65.compareTo(100) = -1
    * a < b a.compareTo(b) < 0 | 100.compareTo(65) = 1
    * a >= b a.compareTo(b) >= 0 | 100.compareTo(100) = 0
    * a <= b a?.equals(b)?: (b === null)
    * a <= b a?.equals(b)?: (b === null)
    * a == b a?.equals(b)?: (b === null)
    * a != b !(a?.equals(b)?: (b === null))
    * */

    println("----------------------------------------------------")

    var a = 20
    var b = 5
    a += b
    println("a += b : " + a)
//    println("a += b : " + (a += b))
//    println("a += b : ${a+=b}") //atama işlemi string içinde gerçekleşmez. İzin verilmez hata alır.
    a -= b
    println("a -= b : " + a)
    a *= b
    println("a *= b : " + a)
    a /= b
    println("a /= b : " + a)
    a %= b
    println("a %= b : " + a)

    println("----------------------------------------------------")

    var numbOne = 10
    var numbTwo = 5
    var flag = true
    println("+a : ${+numbOne}")//10
    println("q-b : ${-numbTwo}")//-5
    println("++a : ${++numbOne}")//11
    println("a++ : ${numbOne++}")//11
    println("+a : ${numbOne}")//12
    println("--b : ${--numbTwo}")//12
    println("!flag : ${!flag}")//false
    println("!flag : ${flag.not()}")//false

    println("----------------------------------------------------")

    /*
    * === ifadesi işaret edilen referans tipleri karşılaştırır.
    * == ifadesi değeri karşılaştırır.
    * */

}