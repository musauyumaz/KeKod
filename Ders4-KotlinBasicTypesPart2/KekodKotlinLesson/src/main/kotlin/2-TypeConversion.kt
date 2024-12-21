fun main() {
    //Implicit Type Conversion : Örtülü - belirgin olmayan şekilde tip dönüşümü.
    //Explicit Type Conversion : Açık - belirgin tip dönüşümü

    // Kotlinde implicit type conversion yoktur.

//    val number: Int = (Int) 3L // Çalışmaz.

    val intValue2 = 3
    val doubleValue = 3.0
    val floatValue = 3.0F
    val longValue = 3L
    val shortValue: Short = 3
    val byteValue: Byte = 3

    getValue(intValue2.toDouble())
    getValue(doubleValue)
    getValue(floatValue.toDouble())
    getValue(longValue.toDouble())
    getValue(shortValue.toDouble())
    getValue(byteValue.toDouble())

    //Tip dönüşümü için kullanabileceğiniz fonksiyonlar;
    //toByte(), toShort(), toInt(), toLong(), toDouble(), toFloat(), toChar(), toString()
    //toUByte(), toUShort(), toUInt(), toULong(), toDuration(), toBigDecimal(), toBigInteger(),

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //1-Numbers.kt dosyasının içerisindeki değişken tiplerinin değer aralıklarını inceleyiniz.
    //Değer aralığı küçük olan tipler büyük olan tiplere, sorunsuz, açık olarak(explicit) dönüştürülebilir.

    val schoolNumber = 126.toByte()
    val convertedValue: Short = schoolNumber.toShort()

    println("schoolNumber : " + schoolNumber)
    println("convertedValue : " + convertedValue)

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Number.kt içerisindeki değişken tiplerinin değer aralıklarını inceleyiniz.
    //Değer aralığı büyük olan tipler küçük olan tiplere açık olarak(explicit) donüştürülürken dikkatli olunmalıdır.
    //Üst tipten bir değişkenin değeri, alt tipin değer aralığından pozitif yönde fazla büyük, negatif yönde fazla küçük ise bu tip dönüşümü sırasında yanlış değer atamaları

    val tcIdentityNumber = 12345678910
    val convertedInt = tcIdentityNumber.toInt()

    println("convertedInt : " + convertedInt)

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Kapalı(implicit) tip dönüşümü olmasa bile, iki number tip arasında matematiksel işlem yapılırsa sonuç değeri çıkan değerin tipinde olacaktır.

    val totalValue: Long = tcIdentityNumber + schoolNumber // Long + Byte = Long

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Kotlin'in sağladığı yukarıdaki tip dönüşümlerinin yanında String to Number dönüşümler için Java'dan aşina olduğumuz tip dönüşümlerini de kullanabiliriz. Bunun için ilgili tiplerin Java versiyonlarını kullanmalısınız.

    //java.lang.Byte.parseByte(), java.lang.Short.parseShort(), java.lang.Int.parseInt(),
    //java.lang.Long.parseLong(), java.lang.Double.parseDouble(), java.lang.Float.parseFloat(),
    //java.lang.Byte.parseByte(), java.lang.Short.parseUShort(), java.lang.Int.parseUInt(),
    //java.lang.Long.parseULong(), java.lang.Double.parseUDouble(), java.lang.Float.parseUFloat()

    val byte: String = "3"
    val intValue = Integer.parseInt(byte)
}

fun getValue(doubleNumber: Double) {}