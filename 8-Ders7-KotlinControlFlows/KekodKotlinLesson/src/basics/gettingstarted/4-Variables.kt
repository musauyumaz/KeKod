package basics.gettingstarted

fun main() {
    /**
     * Variable Types
     * Numbers(Byte, Short, Int, Long, Double, Float) & Unsigned Types
     * Characters
     * Booleans
     * Arrays
     * String
     * Decimals [0-9]
     * Octals [0-7] Kotlin tarafından desteklenmiyor.
     * Binary[0-1]
     * Hexadecimals [0-9A-Fa-f]
     * */

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    val number: Int? = null
    /**
     * Kotlin'de primitive tipler direkt olarak tanımlanamazlar.
     * Ancak yazdığımız program makina koduna derlenirken primitive tiplere dönüştürülür.
     * Eğer değişken "nullable" veya "generic" olarak tanımlanırsa referans tipli olarak dönüştürülür.
     * Değişken nullable olsa bile hiç null değer ataması yapılmazsa yine primitive tip olarak dönüştürülür.
     * Bundan dolayı performans olarak Java'dan farklı değildir.
     * Kontrol etmek için;
     * 1- Bir programı çalıştırın.
     * 2- Ctrl + Shift + A -> Show Kotlin Bytecode
     * 3- İsterseniz decompiler diyerek Java kodundaki karşılığını da görebilirsiniz.
     * */

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Multi thread programlama yaparken performans artisi sağlamak için olabildiğince val değişken kullanmaya çalışın
     * Best Practice olarak alışkanlığınız val tanımlamak şeklinde olsun.
     * Eğer değişkenin değerini sonradan değişmeniz gerekirse var'a çevirirsiniz.
     * */

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    val immutableValue: String = "Değişmez Değişken"
    var mutableVariable: String = "Değişebilir Değişken"

//    immutableValue = "val ifadesi ile tanmımlanan değişken sonradan değiştirilemez."
//    mutableVariable = "var ifadesi ile tanımlanan değişkene ise yeniden değer atanabilir."

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Değişken tanımı sırasında değer ataması yapılırsa değişken tipi gereksizdir.
     * */
    val name = "Musa" //Kotlin tip çıkarımını destekler. (Type Inference) -> String
    val age = 25      //Kotlin tip çıkarımını destekler. (Type Inference) -> Int

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Değişken tanımı yapıldıktan sonra atama yapolabilir
     * */
    val surname: String
    surname = "UYUMAZ"

    /**
     * Ancak değer atamas sonradan yapılacaksa değişken tipi belirtilmelidir.
     * Aşağıdaki kod çalışmaz.
     * */

//    val middleName
//    middleName = "MU"
}