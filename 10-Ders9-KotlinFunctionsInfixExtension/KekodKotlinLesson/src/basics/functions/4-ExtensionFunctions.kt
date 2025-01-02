package basics.functions

fun main() {
    /*
    * Bu dünyayi çekilebilir kılan şeylerin başında gelir Extension Functions :)
    *
    * Üzerinde değişiklik yapamadığımız (readonly) sınıflara ya da istemediğimiz sınıflara bu sınıfların içerisinde yazmadan fonksiyon tanımlayabilmemizi sağlar. Böylece o sınıfa üye bir fonsiyon kazandırabiliriz. Bunu yaparken unutmamanız gereken; yazdığınız extension fonksiyon aslıdna o sınıfın gerçek bir fonksiyonu olmayacaktır.
    *
    * Sad but true story olsundu. Extension fonksiyonlar kalbinize girecekler. Bir sınıfa ait olmaları gerekmez :)
    *
    * Revicer diye adlandıracağımız bir sınıfa ihtiyaç duyar. Extension yazacağımız sınıfı ifade eder. Reciver tanımı
    *
    * Yapısal olarak;
    *
    * fun String.extPrint(handsomeValue : HandsomeOne) : Unit {
    *
    * }
    * */

    //normalde değişkenlere değer atayıp print işlemini aşağıdaki gibi yaparız
    val pi: Double = 3 + 0.14
    println(pi)

    val schoolNumber: Int = 1341
    println(schoolNumber)

    val toIdentityNumber: Long = 18608268888
    println(toIdentityNumber)

    //yukarıdaki kkullanımların yerine normal bir log2 fonksiyonu yazılabilir ve aşağıdaki...
    log2(pi)
    log2(schoolNumber)
    log2(toIdentityNumber)

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //extension fonksiyonlar ister direkt value'lar üzerinden çağırılabilir
    (3 + 0.14).log("")
    1341.log("")
    1341.toFloat()
    18608268888.log("")

    (3 + 0.14) log ""

    //isterseniz de değişkenler üzerinden
    pi.log("")
    schoolNumber.log("")
    toIdentityNumber.log("")

//    1341.extToString()

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //extension fonksiyonlar sarı renkte gözükürler.
    val result: Int = "3".extPlus("5")
    val result2: Int = "3" extPlus "5"

    //infix fonksiyonlar extension fonksiyonlarla kullanılabilir demiştik.
    //extPlus infix extension olduğu için `.` (nokta) kullanımına ihtiyaç duymaz.
    //log ise sadece extension fonksiyon olduğu için .(nokta) ile çağırılır.
    ("3" extPlus "5").log("")

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Extension fonksiyonlar bir sınıfın içerisinde yazıldılar ise kullanım alanı sadece o sınıfın içerisi olabilir.
    * Sınıfın dışından Global çağırım yapılamaz.
    * Int.extToString() methodu Shape sınıfı içinde yazılmıştır. Dolayısıyla Shape sınıfı dışından erişilemez
    * */

//    4.extToString()//Çalışmaz

    //yine de extension methodu veren aşağıdaki main gibi bir method ile erişilebilir.
    val shape = Shape()
    shape.setNumber(45)
    shape.main()

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

}

//Normal fonksiyon
fun log2(number: Number) {
    println(number)
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
* Number (receiver) sınıfına extension olarak yazılmış log fonksiyonu Aynı zamanda infix yapı... this ifadesi, extension yapılan değeri verir. 3 log "4" yaparsanız, aşağıdaki kod size emptyParam = "4", this = 3 olarak verilir.
* */
infix fun Number.log(emptyParam: String) {
    println(emptyParam + this)
}

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
* Infix extension fonksiyon expression formunda kullanılabilir.
* */
infix fun String.extPlus(otherString: String): Int = this.toInt() + otherString.toInt()

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

open class Shape {
    var intNumber = 0

    fun setNumber(intNumber: Int) {
        this.intNumber = intNumber
    }

    fun main(): Unit {
        intNumber.extToString()
        intNumber.log("")
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Bir sınıfın içinde farklı bir sınıfa ait extension fonksiyon yazılırsa, bu sınıfın içinde aynı isimde bir fonksiyon olsa bile extension fonksiyon içerisinde aynı isme sahip fonksiyon çağırılırsa, bu extension fonksiyona işaret eder demektir. Sınıfın aynı isimdeki üye fonksiyonunu extension fonksiyon içerisinde çağırmak için this@sınıfismi.uyefonksiyon() şeklinde çağırım yapılmalıdır.
    * */

    open fun Int.extToString() {
        println("")

        //Int.extToString() methodunu işaret eder.
        extToString()

        //Shape'e ait aşağıdaki üye methodu işaret eder.
        this@Shape.extToString()

        println("Awesome class printi")
    }

    fun extToString() {
        println("KeKod class printi")
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Bir sınıfın yazılmış extension fonksiyuonun aynısını(iism aynı parametre sayısı ve tipleri aynı ayrıca geri dönüş tipi de aynı olmalı) kendi içinde barındırıyorsa bu durumda yazılan extension fonksiyon geçersizdir. Sınıfın üye fonksiyonu çağırılır.
    * */
    fun Shape.setNumber(intNumber: Int) {
        val result = intNumber * intNumber
        println(result)
    }
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Bir sınıfa extension fonksiyon yazılabildiği gibi extension property de yazılabilir. Bunun sebebi aslında property'lerin get() ve set() methodlarından oluşmasından dolayıdır. Bu extension property'lerin içerisinde field tanımlanamaz. Dolayısıyla aslıdna gerçek anlamda bir değişken extension yapılamaz.
    * */
    var Shape.type: String
        get() = type
        set(value) {
            type = value
        }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Open (Extend edilebilir) bir sınıfa sınıfın içinde bir open (override edilebilir)... bu sınıfı miras(inherit) alan sınıflar, ilgili extension fonksiyonu override edebilir...
    * */

    class Rectangle : Shape() {
        override fun Int.extToString() {

        }
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /*
    * NOTES:
    * Nullable extension function
    * */
}