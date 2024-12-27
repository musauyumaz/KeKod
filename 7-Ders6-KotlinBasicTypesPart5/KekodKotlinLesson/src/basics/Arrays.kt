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

    //5 elemanlı tüm indexleri 3.14 ile çarpılan olan bir dizi oluşturur.
    var carNamesMini = Array<Double>(5) {
//        pseudo Codes
//        pseudo Codes
//        pseudo Codes
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
     * .toCharArray() fonksiyonu ile Object-Type bir array Primitive-Typed bir array'e dönüştürülür.
     * .toTypedArray() fonksiyonu ile Primitive-Typed array'i Object-Typed bir array'e dönüştürebilirsiniz.
     *
     * Bu tarz tanımlamalarda ilgili index değerine atama için set(index, value) ya da [index] = value kullanılabilir.
     * Bu tarz tanımlamalarda ilgili index değerindeki değişken değerine get(index) ya da [index] şeklinde ulaşılabilir.
     * */

    val firstCharOfCountries = CharArray(4)
    firstCharOfCountries[0] = 'T'
    firstCharOfCountries.set(1, 'A')
    firstCharOfCountries.set(3, 'İ')

    firstCharOfCountries[2] = 'B'

    val charSample: CharArray = arrayOf('T', 'A', 'B', 'İ').toCharArray()

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


    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * vararg kelimesi ile istediğimiz sayıda parametreyi kabul edebiliriz.
     * Eğer vararg'a gelecek şekilde bir array kullanmak istiyorsak "spread" "*" operatörü kullanırızx
     * Spread operatörü verdiğiniz arrayin elemanlarının her birini bir variable olacak şekilde parametre olarak passlar.
     * */

    val lettersArray = arrayOf("c", "d")
    printAllStrings("a", "b", "c", "d")
    printAllStrings(
        "a",
        "b",
        *lettersArray,
        "f"
    )//spread operatörü array'in içindeki elemanları açık bir şekilde buraya ekler.

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * Array'leri karşılaştırırken == operatörünü kullanamazsınız. == operatörü o array'lerin referans object'lerini karşılaştırır. contentEquals ya da contentDeepEquals kullanmanız lazım.
     * */

    val array1 = intArrayOf(1, 2, 3)
    val array2 = intArrayOf(1, 2, 3)

    println(array1.contentEquals(array2))

    val array3 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
    val array4 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))

    println(array3.contentDeepEquals(array4))

    //https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-array/ fonksiyon listesi
    /**
     * .sum()     -> toplama işlemi; sadece number typed array'ler için çalışır
     * .shuffle() ->
     * */

    val sumArray = arrayOf(1, 2, 3)
    println(sumArray.sum())

    val shuffledArray = arrayOf(1, 2, 3)

    shuffledArray.shuffle()
    println(shuffledArray.joinToString())

    shuffledArray.shuffle()
    println(shuffledArray.joinToString())
    
    /**
     * Array'leri List'e ve Set'e dönüştürebilirsiniz.
     * */

    val sampleArray = arrayOf("a", "b", "c", "c")
    println(sampleArray.toSet()) // [a, b, c]

    println(sampleArray.toList()) // [a, b, c, c]

    /**
     * Map'lere de dönüştürebilirsiniz. Ancak bunun için array'in özel olarak Pair<K,V> formunda olması lazım.
     * */

    val cities = arrayOf("Istanbul" to 34, "Kars" to 36, "Hatay" to 31)
    println(cities.toMap())
}

fun printAllStrings(vararg strings: String) {
    for (string in strings)
        print(string)
}