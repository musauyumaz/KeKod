package basics.functions

/*
* fun keyword'ü ile fonksiyonlar başlar.
* fonksiyon ismi verilir.
* parametre parantezleri açılır ve parantezler girilir.
* : operatörü ve geri dönüş değeri yazılır.
* fonksiyon body'si açılır ve kapatılır.
* Geri dönüş değeri verilmeyen fonksiyonlar Unit tipini geri döndürür.
* */

// val name: String = "Musa"
//fun name : String = "Musa"
//fun name(val surname: String = "Musa"):String = "Musa"
//fun name(surname: String = "Musa"):String = "Musa"

fun main() {
    //Fonksiyon çağırılırken ismi ve parametreleri kullanılır.
    //Eğer bir geri dönüşü varsa bir değişkene atanabilir.
    takeSquare(2)
    val squareValue = takeSquare(2)

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Bir class'ın fonksiyonunu çağırırken ise nokta işaretini kullanabiliriz.
    Math.pow(2.0, 3.0)

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Default değeri olan parametrelere sahip bir fonksiyon çağırılırken, default değeri olan parametrelere değer atamak şart değildir. Default değeri olan bu parametreler opsiyonel parametrelerdir.
    //Default değeri olan parametrelere değer atanmadan fonksiyon çağırılacaksa bu durumda parametre sırası değişir. IDE'ye hangi parametreye değer atadığınızı söylemek için Named Arguments'leri kullanmanız gerekir.
    reformatMessage("Message", true, 7, "tr")
    reformatMessage(message = "Message", size = 7, lang = "tr")
    reformatMessage(message = "Message", isUpperCase = true, size = 7)
    reformatMessage(message = "Message", size = 7)

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //vararg kullanımına örnek key = 3'den önceki parametreler vararg parametresine denk gelir.
    getUserInfo("Musa", "Uyumaz", "Eskişehir", "Türkiye", "", "", "", key = 3)

    //vararg parametresi olarak arrayOf kullanılmak istenirse * operatörü eklenmelidir. (spread operatörü)
    //bu operatör diğer dillerdeki pointer kullanımı anlamına gelmez. Kotlin'de pointer'lar yoktur.
    getUserInfo2(*arrayOf("Musa", "Uyumaz", "Eskişehir", "Türkiye", "", "", ""), key = 4)

    getUserInfo3(3, "Musa", "Uyumaz", "Eskişehir", "Türkiye", "", "", "")

    getUserInfo4(3, "Musa", "Uyumaz", "Eskişehir", "Türkiye", "", true, 3.14, "")
}

/*
* @param number değişken tanımlanır gibi tanımlanır.
* Fonksiyon paramtresi tanımlanırken, val var gibi betimleyiciler kullanılmaz.
* */
fun takeSquare(number: Int): Int {
    return number * number
}

fun repeat(times: Int, startedValue: Int = 0) {
    for (value: Int in startedValue..times) {
        println(value)
    }
}

/*
* = ile fonksiyonlara default değer verilebilir. (Default Argument)
* Default değer ataması yapmak function overload işlemi yapmamızı sağlar.
* Tekrar tekrar aynı fonksiyonun farklı varyosyonlarını yazmak durumunda kalmayız
* */
fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int, lang: String = "tr") {
    println("Message: $message IsUpperCase: $isUpperCase Size: $size Lang: $lang")
}

//Default arguments sayesinde aşağıdaki fonlsiyonları yazmak zorunda kalmayız.
//fun reformatMessage(message: String, isUpperCase: Boolean, size: Int, lang: String = "tr") {
//}

//fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int) {
//}

//fun reformatMessage(message: String, size: Int) {
//}

/*
* Çok uzun sayıda parametreniz olacaksa "variable number of arguments" - vararg tanımlanabilir
* Bu sayede fonksiyon tek bir parametre alıyor gibi gözükürken kendisine çok miktarda değişken atanabilir.
* Bu değişkenlere array'e erişir gibi erişebilirsiniz. [index] ya da .get(index) şeklinde
*
*
* vararg tek ya da son parametre olarak yazılırsa, Jvm'e hazırlanırken, Java'daki "String..." gibi aynı kod derlenir. Ancak vararg param birden fazla tanımlanırken ortada ya da başta yer alırsa, Jvm'e hazırlanırken Array'e dönüştürülür. Bu da performans farkı oluşturur demektir.
* */


fun getUserInfo(vararg userInfo: String, key: Int): Unit {
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo2(vararg userInfo: String, key: Int): Unit {
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo3(key: Int, vararg userInfo: String): Unit {
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo4(vararg userInfo: Any): Unit {
    userInfo[3]
    userInfo.get(3)
}

