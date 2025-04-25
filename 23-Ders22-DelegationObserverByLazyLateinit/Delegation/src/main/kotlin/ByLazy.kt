package org.example

import kotlin.concurrent.thread

/*
* Değerlendirme (Evaluation): by lazy ile tanımlanan bir değişken ilk erişildiğinde değerlendirilir ve değeri hesaplanır. Sonraki erişimlerde ise hesaplanan değer doğrudan döndürülür.
* Bu özellikle hesaplaması maliyetli veya zaman alan işlemler için performans avantajı sağlar.
*
* Null Safety: by lazy ile tanımlanan değişkenler null olamaz (non-nullable).
* Bu güvenli bir şekilde kullanılabileceklerini garanti eder.
*
* Thread Safety: by lazy varsayılan olarak thread-safe'dir. Yani aynı değişkene birden fazla thread aynı anda eriştiğinde doğru değer güvenli bir şekilde döndürülür.
*
* Kullanım Durumu: Genellikle hesaplanması maliyetli olan ancak her zaman kullanılamyabilecek değerler için tercih edilir. Örneğin bir konfigürasyon dosyasını okumak veya bir ağ isteği yapmak gibi işlemler için idealdir.
* */

class Foo {
    init {
        println("Object initialized")
    }
}

fun demo() {
    val lazyObject: Foo by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        println("Lazy object initialized")
        Foo()
    }

    /*
    * SYNCHRONIZED: lazy değerine ilk erişimde tüm thread'leri bloklar ve value alanının oluşturulmasını tek bir tek bir thread'e sınırlar
    * Default yöntem budur.
    *
    * PUBLICATION: value alanının oluşturulmasında tek bir thread'e sınırlama getirmez.
    * Birden fazla thread, value alanını aynı anda oluşturabilir. ancak oluşturma işlemi tamamlandıktan sonra sadece bir thread'e value alanına erişim izni verilir. Diğer thread'ler oluşturma işlemi tamamlanana kadar bekler.
    *
    * NONE: thread güvenliği sağlamaz. Birden fazla thread, aynı anda value alanı alanını oluşturabilir ve bu oluşturma sırasında herhangi bir senkronizasyon yapılmaz bu nedenle bu mod, yalnızca tek thread'in erişimine uygun durumlarda kullanılmalıdır.
    * */


    val lazyObject2: Foo by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Foo()
    }
    //ilk erişimde init bloğu çalışır
    println("First Access: ")
    println(lazyObject)

    //İkinci erişimde init bloğu çalışmaz, önceki nesne döndürülür.
    println("Second access:")
    println(lazyObject)
}

class LazyPublicationExample {
    var count = 0
    val lazyValue: Int by lazy(LazyThreadSafetyMode.PUBLICATION) {
        println("Lazy value is being computed.")

        Thread.sleep(2000)
        ++count
    }
}

fun main() {

//    demo()

    val example = LazyPublicationExample()

    //ilk erişimde değer hesaplanır
    val thread1 = thread { println("Thread 1: ${example.lazyValue}") }

    //İkinci erişimde değer tekrar hesaplanmaz, daha önceki değer kullanılır.
    val thread2 = thread { println("Thread 2: ${example.lazyValue}") }

    val thread3 = thread { println("Thread 3: ${example.lazyValue}") }

    //Thread'lerin tamamlanmasını bekler.
    thread1.join()
    thread2.join()
    thread3.join()
}