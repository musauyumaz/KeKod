package org.example

sealed class MySealedClass {
    data object DataObject : MySealedClass()
    object SingletonObject : MySealedClass()
}

fun main() {

}