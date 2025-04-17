package org.example

import kotlin.collections.indices

/*
*
* Kotlin'de class'lar type parameters'lara sahip olabilirler.
*
* Kotlin wildcard'ları desteklemiyor. Bunun yerine Declaration-site variance ve type projections kavramları var.
* Wildcards kısmı için Java'ya bakalım.
*
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
    val box = Box<Number>(1)

    val box2 = Box(1) // type inference da aldığı değer üzerinden yapılabilir.
    val box3 = Box("Box")
}

/*
*
* Declaration-site variance
*
* *
*/

//out co-variant kullanımlar için lazımdır. (Kendisi veya SubType'ları geçerli olsun istiyorsak)
//interface Source<? extends T>
interface Source<out T> {
    fun nextT(): T
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs
}

// in contra-variance kullanımlar için lazımdır. (Kendisi veya SuperType'ları geçerli olsun istiyorsak)
//interface Comparable<? extends T>
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(3.14)
    val y: Comparable<Double> = x // OK!
}

/*
*
* Type projections in and out
*
* */

//out T kullanımı ile beraber kendisini ve supertype'larını alabileceğini biliyoruz.
//Böylece alt türlerin kullanımı engelleniyor. Ama bazen bu kısıtlamayı da yapmak istemeyiz.
//Array'ler buna güzel bir örnek

class Array2<T>(val size: Int) {
    operator fun get(index: Int): T {
        TODO("not implemented")
    }

    operator fun set(index: Int, value: T) {}
}

//burada amac bir array'in diğer array'in tüm itemlarını kopyalayabilmeli.
fun copy(from: Array<Any>, to: Array<Any>) {
    assert(from.size == to.size)
    for (i in from.indices) to[i] = from[i]
}

fun copy2(from: Array<out Any>, to: Array<Any>) {}
fun fill(dest: Array<in String>, value: String) {}

fun demo() {
    val ints: Array<Int> = arrayOf(1, 2, 3)
    val any = Array<Any>(3) { "" }
    //Array<T> bu durum için Array<Int> invariant durumunda yani değişmez.
    //Yani ne Array<Int> ne de Array<Any> birbirinin subtype'ı değildir. Niye değildir. Çünkü daha önce konuştuüumuz gibi copy'de beklenmedik durum olauşabilir. Şöyle ki siz String bir array'i Int bir Array'in için kopyalamaya çalışabilirdiniz
    copy(ints, any)

    //copy2'deki kullanıma baktığınızda bunu artık yapabilirsiniz. Buna Type-Projection diyoruz.
    //copy2'deki Array<out Any> ifadesi Java'faki Array<? extends Object> karşılığı oluyor.
    copy2(ints, any)

    //fill'deki Array<in String> ifadesi Java'daki Array<? super String> karşılığıu oluyor.
    val strings: Array<Any> = arrayOf(1, 2, "c")
    fill(strings, "d")

}

/*
* Star-projections
*
* Bazne type argument hakkında hiç bişi bilmeyiz. Yine de bunu güvenli bir şekilde kullanabilmemiz lazımdır.
*
* Foo<out T : TUpper> T bu durumda co-variant oluyor ve kendisi ve super type'larını alıyor.
* Foo<*> Foo<out TUpper>'nin eş değeri oluypr. read içn -> Foo<out TUpper>

* Foo<in T> T bu durumda contra-variant oluyor ve kendisi ve sub type'larını alıyor.
* Foo<*> Foo<in Nothing>'nin eş değeri oluypr. write içn -> Foo<in Nothing>
*
* Foo<T : TUpper> T bu durumda in-variant oluyor super'i TUpper için.
* Foo<*> ise read için -> Foo<out TUpper> write için Foo<in Nothing> oluyor.
* */

/*
* Function<*, String> ifadesi Function<in Nothing, String> olur.
*
* Bu ifade Function'ın parametrelerinin türlerini belirtmediğimiz ancak dönüş değeri türünün String olduğu bir fonksiyonu temsil eder. Bu durumda herhangi bir türden parametre kabul edebiliriz, ancak dönüş değeri her zaman String olmalıdır. Bu Kotlin'de Function<in Nothing, String> ile aynı şeyi ifade eder. Nothing, diğer tüm türlerin alt türüdür. bu yüzden Function herhangi bir türden parametre kabul edebilir.
*
* */

/*
* Function<Int, *> ifadesi Function<Int, out Any?>

* Bu ifade Fubction'ın Int türünden bir parameter alduğı ancak dönüş değeri türünün belirli bir türle sınırlı olmadığu bir Funcitpon'ı temsil eder. Yani herhangi brir dönüş değeri türüne sahip olabilir. Bu durumda dönüş değeri Any? olarak kabul edilir. çünkü Any? türü herhangi bir türün alt türüdür ve nullable olabilir (? işareti)
*/

/*
* Function<*,*> ifadesi Function<in Nothing, out Any?>

* Bu ifade hemn parameterlin hemn de dönüş değerinini tütrlerinin belirli bir türler sınırlı olmadığı bir Function'ı temsil eder. Yani Function herhnagi bir türden parametre kabul edebilir ve herhangi bir türde dönüş değeri veregbilir. Bu durumda yine Function<in Nothing, out Any?> ile aynıdır; çünkü parametre türü Nothing (yani herhangi bir tür) ve dönüş değeri türü Any?(yani herhangi bir tür veya nullable olabilrir)
* */

class Boxs<T>(val item: T) {
    fun <K> foooo(param: K) {
        
    }
}

fun printBox(box: Boxs<*>) {
    val item = box.item
    println("Item: $item")
}

fun demo2(): Unit {
    val stringBox = Boxs("Hello Kotlin!")
    val intBox = Boxs(42)
    val boolBox = Boxs(true)

    printBox(stringBox)
    printBox(intBox)
    printBox(boolBox)
}