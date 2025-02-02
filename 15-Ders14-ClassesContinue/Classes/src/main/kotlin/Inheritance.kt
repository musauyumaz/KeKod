package org.example

fun main() {

}

class Example : Any() {
    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}

final class Base
open class Base2(p: Int)

class Derived(p: Int) : Base2(p)
