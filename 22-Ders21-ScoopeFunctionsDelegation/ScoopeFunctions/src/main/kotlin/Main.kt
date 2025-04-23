package org.example

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

    name?.apply {
        println("apply")
    }
    name?.also {
        println("also")
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