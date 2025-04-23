package org.example

import java.awt.image.renderable.ParameterBlock

fun main() {
    val name: String? = "Musa"

    // T = Önüne gelen değişken
    // R = son satır, yani geri dönüş değeri
    //Lambda param = T
    val returnValueLet = name?.let { name: String ->
        println("let $name")
    }

    println(returnValueLet)

    // T = Önüne gelen değişken
    // R = son satır, yani geri dönüş değeri
    //Lambda param = yok, this = T
    val returnValueRun = name?.run {
        println("run $this")
    }

    println(returnValueRun)

    // T = yok, extension işlemi yok
    // R = son satır, yani geri dönüş değeri
    //Lambda param = yok, this = yok, çünkü extension yok
    val returnValueRunJustRun = run {
        println("just run")
    }

    println(returnValueRunJustRun)

    // T = fonksiyonun fonksiyon olmayan değişken olan parametresi - yani 1.parametre, extension işlemi yok
    // R = son satır, yani geri dönüş değeri
    //Lambda param = yok, this = var, çünkü extension function
    val returnValueWith = with(name) {
        println("with $this")
    }

    println(returnValueWith)

    // T = Önüne gelen değişken
    // R = yok, Çünkü high order function'ın geri dönüş değeri yok. Onun yerine T geri döndürülüyor.
    //Lambda param = T, (this = T, çünkü extension function)
    val returnValueApply = name?.apply {
        println("apply  $this")
    }

    // T = Önüne gelen değişken
    // R = yok, Çünkü high order function'ın geri dönüş değeri yok. Onun yerine T geri döndürülüyor.
    //Lambda param = yok, this = yok, çünkü extension yok
    val returnValueAlso = name?.also { name: String ->
        println("also $name")
    }

    println(returnValueAlso)

    name.takeIf {
        true
    }

    name.takeUnless {
        true
    }
}

inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}

inline fun <T, R> T.run(block: T.() -> R): R {
    return block()
}

inline fun <R> run(block: () -> R): R {
    return block()
}

inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    return receiver.block()
}

inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}

inline fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}
