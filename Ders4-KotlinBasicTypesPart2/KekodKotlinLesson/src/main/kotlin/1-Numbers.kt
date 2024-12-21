package basics

fun main() {
    /*
    *
    *           Type    | Size (bits)   |               Min Value               | Max Value
    *           ------------------------------------------------------------------------------------------------
    *           Byte    | 8 bit         | -128                                  | 127
    *           Short   | 16 bit        | -32,768                               | 32,767
    *           Int     | 32 bit        | -2,147,483,648 (-2^31)                | 2,147,483,647 (2^31 - 1)
    *           Long    | 64 bit        | -9,223,372,036,854,775,808 (-2^63)    | 9,223,372,036,854,775,808 (-2^63 - 1)
    *
       *        UByte   | 8 bit         | 0                                     | 255
    *           UShort  | 16 bit        | 0                                     | 65,535
    *           UInt    | 32 bit        | 0                                     | 4,294,967,295 (2^32 - 1)
    *           ULong   | 64 bit        | 0                                     | 18,446,744,073,709,551,615 (2^64 - 1)
    *
    *
    *
    *           Type     | Size (bits)   | Significant bits | Exponent bits | Decimal digits
    *           ------------------------------------------------------------------------------------------------
    *           Float    | 32 bit        |        24        |       8       |      6-7
    *           Double   | 64 bit        |        53        |       11      |      15-16
    * */

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Değişkene değer ataması yapılırken maksimum performans almak için doğru değişken tipini kullanmak önemlidir.
    //Bunun için değişkenlerin değer aralıklarını yukarıdan kontrol edebilirsiniz.
    //Tip çıkarımı (Type Inference) sırasında eğer sayı Int ifadeden büyük değilse tipi default olarak Int set edilir
    //Tip çıkarımı (Type Inference) sırasında eğer sayı Int ifadeden büyükse tipi default Long set edilir.

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    val minByteValue: Byte = Byte.MIN_VALUE
    val maxByteValue: Byte = Byte.MAX_VALUE

    val minShortValue: Short = Short.MIN_VALUE
    val maxShortValue: Short = Short.MAX_VALUE

    val minIntValue: Int = Int.MIN_VALUE
    val maxIntValue: Int = Int.MAX_VALUE

    val minLongValue: Long = Long.MIN_VALUE
    val maxLongValue: Long = Long.MAX_VALUE

    val minFloatValue: Float = Float.MIN_VALUE
    val maxFloatValue: Float = Float.MAX_VALUE

    val minDoubleValue: Double = Double.MIN_VALUE
    val maxDoubleValue: Double = Double.MAX_VALUE

    println("minByteValue : " + minByteValue)
    println("maxByteValue : " + maxByteValue)
    println("minShortValue : " + minShortValue)
    println("maxShortValue : " + maxShortValue)
    println("minIntValue : " + minIntValue)
    println("maxIntValue : " + maxIntValue)
    println("minLongValue : " + minLongValue)
    println("maxLongValue : " + maxLongValue)
    println("minFloatValue : " + minFloatValue)
    println("maxFloatValue : " + maxFloatValue)
    println("minDoubleValue : " + minDoubleValue)
    println("maxDoubleValue : " + maxDoubleValue)

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // Long         değişkenler için sayının sonuna "L" konularak değer ataması yapılabilir.
    // Float        değişkenler için sayının sonuna "F" ve "f" konularak değer ataması yapılabilir.
    // Double       değişkenler için geleneksel gösterim desteklenir.
    // Decimal      tanımı yapılabilir       [0-9]
    // Octal        tanımı yapılamıyor       [0-7]
    // Hexadecimal  tanımı yapılabilir
    // Binary       tanımı yapılabilir       [0-1]

    val longNumber = 1586L
    val floatNumber1 = 19.90F
    val floatNumber2 = 13f
    val doubleNumber = 3.14
    val doubleNumber2 = 3.14e10
    val decimalNumber = 1907
//    val octalNumber = 0197
    val hexadecimalNumber = 0x759
    val binaryNumber = 0b01000011

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Number değişken tanımı yapılırken underscore "_" kullanılabilir.

    val oneMillion = 1_000_000 //1000000
    val creditNumber = 1234_5678_9012_3456L
    val bytes = 0b01000011_01101111_01100100_01100101_01101101_01111001

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Primitive tipler kotlinde class'larla temsil edilirler. Biz bir Int değişken oluşturduğumuzda bu bir class. Class dediğimiz yapı da bir yapı primitive değil. Primitive tiplerin class olarak görünmesine rağmen özel optimizasyonlarla bytecode'a çevrilirken primitive hallerini kullanıyoruz. Ama bunun bir istisnası var. Eğer ki siz primitive bir değişkeni nullable yapıyorsanız yani bu artık null değer de alacak diyorsanız bu arkadaşın temsili artık primitive tip olarak değil class tiplerine dönüşür.

    //Bir değişken primitive bir tip olsa bile kotlin'de nullable değer alıyorsa nullable olabiliyorsa bu artık class'a tekabül ediyor olacaktır. Bu hem değişkenin kapladığı alanı değiştirir. Buna erişim hızını değiştirir. Hem de referansları değişir. Yani gereksiz nullable(?) operatörünü kullanmayın.

    //Boxed   : Değişkenin obje referansı olarak tutulmasıdır.
    //UnBoxed : Değişkenin primitive olarak tutulmasıdır.
    // === Operatörü değişkenlerin referansını karşılaştırırken kullanılır.
    // == operatörü değişkenlerin değerini karşılaştırırken kullanılır.

    val number: Int = 127//int
    val boxedNumber: Int? = number
    val anotherBoxedNumber: Int? = number
    println(boxedNumber === anotherBoxedNumber) //true

    val number2: Int = 128
    val boxedNumber2: Int? = number2
    val anotherBoxedNumber2: Int? = number2
    println(boxedNumber2 === anotherBoxedNumber2) //false

    //nullable numberlar işin içine girdiğinde eğer ki kontrol ettirdiğiniz değerin kendisi -128 ile 127 arasında ise yani verdiğiniz değer byte aralığı içindeyse bu referans tipli bir class'ın objesi bile olsa referans kontrollerinde özel optimizasyonlar sebebiyle aynı alana işaret ediyorsunuz. Yani -128 ~ 127 aralığında bir sayı kullanıyorsanız bunlar nullable Int olsa bile halen küçük int(primitive) gibi davranıyorlar.
    //Integer'lar için sayısal değerlerin nullable olması durumunda eğer byte aralığının(-128~127) içerisinde iseniz bu durumda özel optimizasyonlar sizin aynı referans aralığına işaret ettiğinizi gösteriyor. Farklı değişkenler gibi gözükseler bile bunlar aslında aynı değişkenler oluyor. Aralık dışında ise farklı memory alanlarına işaret ediyor demektir.


    //Backend'ten dönen Double ve Float değişkenleri kullanırken dikkatli olmanız gerekiyor.
    //Eğer Backend'ten dönen değer üzerinde "." işaretine göre bir split işi yapacaksanız başınız ağrıyabilir.
    //Çünkü backend'ten dönen Double ve Float değişkenleri her zaman "." ile ayrışmıyor olabilir.
    //Database dilinin farklı olmasına göre (türkçe - ingilizce gibi) "." yerine "," ile de ayrışıyor olabilir.

}
//region Mülakat Soruları
//4.Type Inference nedir?
//Eşitliğin karşı tarafında bir value varsa siz o değişkenin değişken tipini vermeseniz bile eşitliğin diğer tarafındaki değere bakarak değişkenin tipinin ne olacağına IDE karar verebilir. Bir değişken tipinin eşitliğin sağ tarafına bakarak belirlenmesi işlemine type inference(tip çıkarma) denir. Ama sayısal değerlerde verilen değer eğer Int değer aralığında ise Int set edilir Int değer aralığından daha büyükse Long set edilir.

//5. === operatörü neyi kontrol eder? == operatörü neyi kontrol eder?
//== size değişkenlerin değerlerini yani value'sunu === ise bunların memory'deki referanslarını kontrol ettirir. memory'deki referans dediğimiz şey siz her bir değişken oluşturduğunuzda hani o bilgisayarlarımızda ram dediğimiz bir alan var ya onların içerisinde ne kadarlık yer kapladıklarını ve hangi adreste yer kapladıklarını söylüyorsunuz.

//6. Kotlin'de primitive tipteki değişken nullable yapılır ve === ile kontrol edilirse nasıl bir sonuç alırsınız?
//endregion
