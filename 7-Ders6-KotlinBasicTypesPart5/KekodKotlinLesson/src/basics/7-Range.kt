package basics

fun main() {
    /**
     * Sonlu sayılı liste oluşturmaya yarar.
     * */

    /**
     * Küçükten büyüğe liste oluşturmak için;
     * ".." operatörünü ya da "rangeTo()"
     * "..<" operatörünü ya da "rangeUntil()"
     * fonksiyonunu kullanabilirsiniz.
     * */

    val numbers = 1..100 // [1, 100]
    val numbers2 = 1.rangeTo(100)

    val numbersUntil = 1..100 //[1,100) == [1,99]
    val numberUntil2 = 1.rangeUntil(100)

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Char'lardan oluşan bir liste de tanımlanabilir. Türkçe karakterleri içermez.
     * */
    val alphabet = 'A'..'Z'

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Büyükten küçüğe .. operatörünü kullanarak liste oluşturamayız. IDE hata verecektir.
     * Büyükten küçüğe liste oluşturmak için downTo() fonksiyonunu kullanabilirsiniz. Infix kullanımı da vardır.
     * */

//    val reversedNumber = 100..1 //Çalışmaz
    val reversedNumbers = 100.downTo(1)
    val reversedNumbers2 = 100 downTo 1
    print("reversedNumbers")
    reversedNumbers.forEach { print(" " + it) }
    println()

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * until fonksiyonunu kullanarak da range tanımlanabilir. Ancak bu durumda bitiş değeri listeye dahil edilmez.
     * */
    val gradeNumbers = 10.until(100) //[10,100)
//    val gradeNumbers2 = 10.rangeTo(99) //[10,100)
//    val gradeNumbers3 = 10..99 //[10,100)
    val gradeNumbers2 = 10 until 100//[10,100)
    gradeNumbers.forEach { print(" " + it) }
    println()

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * step fonksiyonunu kullanarak liste oluşturulurken belli sayıda atlamalar yapabilirsiniz.
     * */
    val stepedNumbers = 1..101 step (2)
    val stepedNumbers2 = 1..100 step 3
    print("stepedNumbers")
    stepedNumbers.forEach { print(" " + it) }
    println()

    val reversedStepedNumbers = 100 downTo 1 step (3)
    val reversedStepedNumbers2 = 100.downTo(1) step 2
    print("reversedStepedNumbers")
    reversedStepedNumbers.forEach { print(" " + it) }
    println()

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * CharRange, IntRange ve LongRange isimlerinde özel range'ler vardır. Progression olarak adlandırılır.
     * Diğer tipler bulumaz.
     * Bu durumda first, last, step, count gibi ek bilgiler alınabilir.
     * Iterable<N> interface'ini implement etmişlerdir. 0 sebeple map filter gibi fonksiyonları kullanabilirler.
     * */
    val numberList: IntRange = 10 until 90
    numberList.first
    numberList.last // last bilgisi dönülürken step'e göre dönüş sağlanabilir.
    numberList.step

    when (10) {
        in numberList -> {
            println("10 sayısı numberlist içerisinde yer alır")
        }
    }

    numberList.count()

    val countBiggerThan50 = numberList.count() { it > 50 }

    println(countBiggerThan50)

    println("numberList.average ${numberList.average()}")
    println("numberList.reversed ${numberList.reversed()}")

    println((1..10).filter { it % 2 == 0 })
}