package org.example

fun main() {
    val name: String? = "null"

    // T = Önüne gelen değişken, R ise son satır
    val returnValue = name?.let { name: String ->
        println("let $name")
    }

    println(returnValue)

    name?.run {
        println("run variable")
    }

    run {
        println("just run")
    }

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