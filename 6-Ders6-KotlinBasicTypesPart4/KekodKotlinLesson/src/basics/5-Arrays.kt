package basics

fun main() {

    /**
     * Aynı türden ya da belirtilen türün alt türlerinden, sabit sayıda veri tutan bir veri yapısıdır.
     * En sık kullanılan versiyonu Object-Type Array'lerdir. Array sınıfı ile temsil edilirler.
     *
     * Eğer primitive tipleri Object-Type Array olarak kullanırsanız Boxed kulllanım yapmış olursunuz. Bu da performansa etki eder. Eğer sadece primitive'lerden oluşan arrayler oluşturacaksanız, bu durumda Primitive-Type Array'ler kullanın
     * ByteArray(byte[]), ShortArray(short[]), IntArray(int[]), LongArray(long[])
     * DoubleArray(double[]), FloatArray(float[])
     * BooleanArray(boolean[]), CharArray(char[])
     *
     * arrayOf(aynı tip değerler) şeklinde tanımlanabilir.
     * arrayOf<Any>(fark tip değerler) şeklinde tanımlanabilir.
     * arrayOfNulls<Type>(size) şeklinde ise verilen boyut kadar null değer içeren dizi tanımlanabilir.
     * emptyArray() boş array tanımlar
     * **/

    val studentNumbers = arrayOf(13, 45, 53, 54, 25, 10)
    val studentNames = arrayOf("Musa", "Serhat", "Gençay", "Gökhan")
    val firstCharOfNames = arrayOf('M', 'S', 'G', 'G')
    val mixedArray = arrayOf<Any>(13, "Musa", "M", true)

    val arrayOfNulls = arrayOfNulls<String>(4)
    println(arrayOfNulls.joinToString())

    val emptyArray = emptyArray<String>()
    val emptyArray2: Array<String> = emptyArray()

//    emptyArray[5] = "Yeni Eleman"

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Array'ler sabit büyüklüktedirler. Array'lere ekleme ve çıkarma yapmak aynı String'te memory'de yeni bir Array oluşturulmasına neden olur.
     * */

    var citiesArray = arrayOf("İstanbul", "Hatay", "Kars")

    citiesArray += "Sivas"
    //Birden fazla eleman eklemek için
    citiesArray += arrayOf("İzmir", "Konya")
    println(citiesArray.joinToString())

    citiesArray.forEach { print("$it, ") }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Array<Type>(size){high order function} şeklinde de tanımlanabilir.
     * Bu durumda higher order function içerisinde son satıra denk gelen değerler diziyi oluşturur.
     * Higher order function, içerisi dizinin boyutu kadar index'i(it) bir arttırarak çalışır.
     * */

    //5 elemanlı tüm elemanları 3.14 olan bir dizi oluşturur.
    var carNamesMini = Array<Double>(5) {
        3.14 * it
    }

    //10 elemanlı 0-9 arasındaki index değerlerinin karesini alan bir dizi oluşturur.
    // {0,1,2,4,9,16,25,36,49,81}
    val carNames = Array(10) {
        println((it * it).toString())
    }

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * ByteArray, ShortArray, IntArray, LongArray, DoubleArray, FloatArray gibi ya da bunların unsigned halleri primitive array tanımlamaları da yapılabilir.
     * .toTypedArray() fonksiyonu ile Object-Type bir array Primitive-Typed bir array'e dönüştürülür.
     *
     * Bu tarz tanımlamalarda ilgili index değerine atama için set(index, value) ya da [index] = value kullanılabilir.
     * Bu tarz tanımlamalarda ilgili index değerindeki değişken değerine get(index) ya da [index] şeklinde ulaşılabilir.
     * */

    val firstCharOfCountries = CharArray(4)
    firstCharOfCountries[0] = 'T'
    firstCharOfCountries.set(1, 'İ')
    firstCharOfCountries.set(3, 'A')

    firstCharOfCountries[2] = 'B'

    println("firstCharOfCountries index 2 :" + firstCharOfCountries.get(2))
    println("firstCharOfCountries index 2 :" + firstCharOfCountries[2])

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * val ile tanmımlanmış bir array'in herhangi bir index'indeki değer değiştirilebilir.
     * val indexdeki değerlerin değişmesine karışmaz
     * Ancak ilgili diziyi başka bir dizi ile eşitlemenize izin verilmez.
     * Bunun için tanımlamayı var ile değiştirmeniz gerekir.
     * */

    val awesomeArray = arrayOfNulls<String>(5)
    awesomeArray[2] = "Musa"
    //awesomeArray = arrayOf("foo", "boo", "goo", "doo", "loo") //Çalışmaz

    /**
     * Array'in size'i dışına çıkıyorsanız (boyutu dışına çıkıyorsanız) IndexOutOfBound hatası alırsınız.
     * */

    awesomeArray[4] = "Gençay"
//    awesomeArray[5] = "Gençay" //Çalışmaz hata alır.

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //2 boyutlu diziler
    val twoDArray = Array(2) { Array<Int>(2) { 0 } }
    println(twoDArray.contentDeepToString())
    // [[0,0], [0,0]]

    //3 boyutlu diziler
    val threeDArray = Array(3) { Array(3) { Array(3) { 0 } } }
    println(threeDArray.contentDeepToString())
    // [[[0,0,0], [0,0,0], [0,0,0]],
    // [[[0,0,0], [0,0,0], [0,0,0]],
    // [[[0,0,0], [0,0,0], [0,0,0]]]

    //Array'ler her zaman değişebilirdir(mutable)

    val simpleArray = arrayOf(1, 2, 3)
    //Accesses the element and modifies it
    simpleArray[0] = 10
    twoDArray[0][0] = 2

    println(simpleArray[0].toString())
    println(twoDArray[0][0].toString())

    //Aynı zamanda array'ler üst class'ları yerine atanamazlar (invariant)
    val arrayOfString: Array<String> = arrayOf("V1", "V2")
//    val arrayOfAny: Array<Any> = arrayOfString
    var arrayOfAny: Array<Any> = arrayOf("V1", "V2")

}

//region Mülakat Soruları
// . Kotlin'de Array'ler Mutable mıdır yoksa immutable mı?
//Array'in içinde bulunan ve değişebilen indexler mutable'dır. Ama tümden array objesi/nesnesi immutable'dır.
//endregion