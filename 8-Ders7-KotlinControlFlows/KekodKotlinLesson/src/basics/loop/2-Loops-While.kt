package basics.loop

fun main() {
    /*
    * Değişen hiçbir şey yok Diğer dillerde nasıl kullanıyorsanız Kotlin'de de aynı şekilde kullanıyoruz.Eğer bir döngüye ihtiyacınız varsa ve bu döngü sırasında if else ile bir şartlı duruma ihtiyacınız varsa bu durumda for + if else kullanmak yerine while kullanabilirsiniz.
    * */

    var number = 0

    while (number < 5) {
        print("${number++}, ")
    }

    while (number < 5) {
        print("${number}, ")
        number++
    }

    println("\n---------------------------")

    for (value in 0..110) {
        if (value < 5) {
            print("$value, ")
        } else {
            break
        }
    }
}