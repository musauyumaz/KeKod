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
    //Tip çıkarımı (Type Inference) sırasında eğer sayı Int ifadeden büyükse tipi default
}