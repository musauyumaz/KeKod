package basics

fun main() {
    // 16 bit yer kaplar
    //Tek tırnakların arasına harf, sayı, escape char ya da unicode yazarak kullanılır.
    //Çif tırnak içerisine yazılırsa String olur, Char olmaz.

    val firstCharOfName: Char = 'u'
//    val firstCharOfName2: Char = "M"
//    val firstCharOfName3: Char = 'MU'
    val charNumber: Char = '6'
//    val charNumber2 : Char = '53'
    val nullableChar: Char? = null

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Number değer alan bir Char değişken Int'e çevirilirken, gerçek sayısal değerini almaz.
    //Alacağı değer ASCII tablosundaki o sayısal değerin karşılığı olacaktır.

    val convertedCharNumber = charNumber.toInt()
    val convertedCharNumber2 = charNumber.code
    val digitToInt = charNumber.digitToInt()
    println("charNumber = " + charNumber)
    println("convertedCharNumber = " + convertedCharNumber)
    println("convertedCharNumber2 = " + convertedCharNumber2)
    println("digitToInt = " + digitToInt)

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Kaçış(Escape) karakterlerini de tanımlamak için kullanılabilir.

    val exampleString = "Kotlin'de escape karakterleri örnekleri: \n" +
            "\t \\t ile bir tab boşluğu ekleyebilirsiniz.\n" +
            "\t \\n ile yeni bir satıra geçebilirsiniz.\n" +
            "\t \\b ile bir backspace(geri al) işlemi yapabilirsiniz.\n" +
            "\t \\r ile satır başına dönebilirsiniz.\n" +
            "\t \\' ile tek tırnak(') karakterini kullanabilirsiniz.\n" +
            "\t \\\" ile çift tırnak (\") karakterini kullabilirsiniz.\n" +
            "\t \\\\ ile ters slash(\\) karakterini kullanabilirsiniz.\n" +
            "\t \\\$ ile dolar işareti ($) karakterini kullanabilirsiniz."
    println(exampleString)

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Unicode karakterlerini de tanımlamak içim kullanılabilir.
    val blackHeart = '\u2665' //
    val heavyBlackHeart = '\u2764'

    println("First commit with $blackHeart")
    println("First commit with $heavyBlackHeart")

    val ANSI_RED = "\u001B[31m"
    //ANSI Renk Sıfırlama Kodu (Metni varsayılan rengine döndürür)
    val ANSI_RESET = "\u001B[0m"

    println("First commit with $ANSI_RED$blackHeart$ANSI_RESET")


    println("77 : " + 77.toChar())
    println("85 : " + 85.toChar())
    println("83 : " + 83.toChar())
    println("65 : " + 65.toChar())

    println(Integer.toBinaryString(77858365))
}