package org.example

fun main() {
    val name: String? = "Musa"

    // T = Önüne gelen değişken
    // R = son satır
    //Lambda param = T
    val returnValueLet = name?.let { name: String ->
        println("let $name")
    }

    println(returnValueLet)

    // T = Önüne gelen değişken
    // R = son satır
    //Lambda param = yok, this = T
    val returnValueRun = name?.run {
        println("run $this")
    }

    println(returnValueRun)

    // T = yok, extension işlemi yok
    // R = son satır
    //Lambda param = yok, this = yok, çünkü extension yok
    val returnValueRunJustRun = run {
        println("just run")
    }

    println(returnValueRunJustRun)

    with(name) {
        println("with")
    }

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