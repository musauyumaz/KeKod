package org.example

/*
*
* Kotlin'de class'lar type parameters'lara sahip olabilirler.
*
* Kotlin wildcard'ları desteklemiyor. Bunun yerine Declaration-site variance ve type projections kavramları vardır Wildcars kısmı için Java'ya bakalım
* */

class Box<T>(t: T) {
    var value = t

    fun <L> foo(l: L) {

    }
}

fun calculate(number: Number) {

}

fun main() {
    calculate(3.14)

    //basitçe instance'ını oluşturabiliriz.
    val box: Box<Int> = Box<Int>(1)

    val box2 = Box(1)//type inference da aldığı değer üzerinden yapılabilir.
    val box3 = Box("Box")//type inference da aldığı değer üzerinden yapılabilir.
}

/*
*
* Declaration-site variance
*
* */

//out co-variant kullanımlar için lazımdır. (Kendisi ve SubType'ları geçerli)
interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs
}

// in contra-variance kullanımlar için lazımdır. (Kendisi ve SuperTyoe'ları geçerli olsun istiyorsak)
//interface Comparable<? super T>
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
//    x.compareTo(3.14) // 3.14 değeri double değişken demektir. Double'da Number'ın alt türüdür.
    //Daha açık görmek için, Number arayüzündeki Comparable interface'i Double olan alt türe verilebiliyor
    val y: Comparable<Double> = x //OK!
//    x = y
}

/*
* Type projections in and out
* */

// out T kullanımı ile berabewr kendisini ve supertype'larını alabileceğini biliyor
//Böylece alt türlerin kullanımı engelleniyor. Ama bazen bu kısıtlamayı da yapmak istemeyiz
//Array'ler buna güzel bir örnek.

//class Array<T>(val size: Int) {
//    operator fun get(index: Int): T {
//        TODO("not implemented")
//    }
//
//    operator fun set(index: Int, value: T) {}
//}

//burada amaç bir array'in diğer arrayin tüm itemlarını kopyalayabilmeli
fun copy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

fun copy2(from: Array<out Any>, to: Array<Any>) {}

fun fill(dest: Array<in String>, value: String) {}

fun demo() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    //Array<T> bu durum için Array<Int> invariant durumunda. Yani değişmez
    //Yani ne Array<Int> ne de Array<Any> birbirinin subtype'ı değildir. Niye değildir. Öünkü daha önce konuştuğumuz gibi copy'de beklenmedik durum oluşabilir. Şöyle ki siz String bir array2i Int bir Array'in kopyalamaya çalışabilirdiniz.
//    copy(ints, any)

    //copy2'deki kullanıma baktığınızda bunu artık yapabilirsiniz. Buna Type-Projection diyoruz.
    // copy2'deki Array<out Any> ifadesi Java'daki Array<? extends Object> karşılığı oluyor.
    copy2(ints, any)

    //fill'deki Array<in String> ifadesi Java'daki Array<? super String> karşığılı oluyor.
    val strings: Array<String> = arrayOf("a", "b", "c")
    fill(strings, "d")
}

/*
*
* Star-projections
*
* Bazen type argument hakkında hiç. bişi bilmeyiz. Yine de bunu güvenli bir şekilde kullanabilmemiz lazımdır.
*
* Foo<out T: TUpper> T bu durumda co-variant oluyor ve kendisi ve super type'larını alıyor.
* Foo<*> Foo<out TUpper>'nin eş değeri oluypr. read için -> Foo<out TUpper>

* Foo<in T> T bu durumda contra-variant oluyor ve kendisi ile sub-type'larını alıyor
* Foo<*> sie Foo<in Nothing>in eş değeri oluyor. write için Foo<in Nothing> oluyor.
*
* Foo<T: TUpper> T bu durumda in-variant oluyor super'i TUpper için
* Foo<*> ise read için -> Foo<out TUpper> write için Foo<in Nothing> oluyor.
*
* */

/*
* Function<*, String> ifadesi Funciton<in Nothing, String> olur
*
* */
//Bu ifade Function'ın parametrelerinin türlerini belirmediğimiz ancak dönüş değeri türünün String olduğu bir fonksiyonu temsil eder Bu durumda herhangi bir türden parametre kabul edebiliriz. Ancak dönüş değeri her zaman String olmalıdır. Bu Kotlin'de Funciton<in Nothing, String> ile aynı şeyi ifade eder. Nothing dieğer tüm türlerin alt türüdür. Bu yüzden Funciton herhangi bir türden parametre kabul edebilir.

/*
* Function<Int, *> ifadesi Funciton<Int, out Any>
* */
//Bu ifade Function'ın Int türünden bir parametre aldığı ancak dönüş değeri türünün belirli bir türle sınırlı olmadığı bir Function'ı temsil eder. Yani herhangi bir dönüş değeri türüne sahip olabilir. Bu durumda dönüş değeri Any? olarak kabul edilir, çünkü Any? türü herhangi bir türün alt türüdür nullable olabilir(? işareti)

/*
* Function<*, *> ifadesi Funciton<int Nothing, out Any?>
* */
//Bu ifade hem parametrelerin hem de dönüş değerinin türlerinin belirli bir türle sınırlı olmadığı bir Function'ı temsil eder Yani, Function herhangi bir türden paraemter kabul edebilir. ve herhangi bir türde dönüş değeri verebilir. Bu durumda Function<in Nothing, out Any?> ile aynıdır; çünkü parametre türü Nothing (yani herhangi bir tür) ve dönüş değeri türü Any? (yani herhangi bir tür veya nullable olabilir)

class Boxs<T>(val item: T)

fun printBox(box: Boxs<*>) {
    val item = box.item
    println("Item: $item")
}

fun demo2() {
    val stringBox = Boxs("Hello, Kotlin!")
    val intBox = Boxs(42)

    printBox(stringBox)
    printBox(intBox)
}

//Generic functions