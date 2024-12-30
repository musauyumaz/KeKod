package basics.loop

fun main() {
    /*
    * 3 farklı şekilde for tanımlayabilirsiniz.
    * value in list                    şeklinde value değerlerini alabilirsiniz
    * index in list.indices            şeklinde index değerlerini alabilirsiniz
    * (index, value) in list.withIndex şeklinde index,value değerlerini alabilirsiniz
    * */

    for (value: Int in 1..10) {
        print("$value ")
    }

    val countryCodeArray = arrayOf("tr", "az", "en", "fr")

    for (value in countryCodeArray) {
        print("$value ")
    }

    for (index in countryCodeArray.indices) {
        print("\n$index.değeri : ${countryCodeArray[index]}")
    }

    for ((index, value) in countryCodeArray.withIndex()) {
        print("\n$index.değeri : $value")
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * repeat(size) şeklinde herhangi bir listeye ihtiyaç duymadan tekrarlayan işler yapabilirsiniz.
    * */

    repeat(10) {
        println("\nDaha çok blog yazmam lazım!")
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * return kullanarak ilgili şart sağlanırsa, döngüden çıkabilirsiniz.
    * continue kullarak ilgili şart sağlanırsa, döngüye o değeri atlayarak devam edebilirsiniz
    * */

    for (value in 1..50) {
        if (value % 2 == 1) {
            continue
        }
        print("\n$value")
    }

    for (value in 1..50) {
        if (value % 2 == 1) {
            break
        }
        print("\n$value")
    }

    /*
    * İç içe for döngüleri kullanıyorsak bir üstteki for'a değil de iki üstteki üç üstteki for'a dönmek istiyorsak label kullanabiliriz. Bunun için labelname@ ifadesini ilgili for'un önüne yazıp, return ya da continue yere ise @labelname şeklinde yazmamız yeterlidir.
    * */

    for (value in 1..50) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                continue
            }

            print("continue1 : $value2 | ")
        }
    }

    println("")

    returnlabel@ for (value in 1..50) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                continue@returnlabel
            }

            print("continue2 : $value2 | ")
        }
    }

    println("")

    returnlabel@ for (value in 1..50) {
        for (value2 in 0..10) {
            if (value2 == 5) {
                break@returnlabel
            }
            print("break2 : $value2 | ")
        }
    }
    println("dasdsadsad")
}