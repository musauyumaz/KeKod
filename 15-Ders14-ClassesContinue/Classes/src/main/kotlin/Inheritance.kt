package org.example

fun main() {
    val derived = Derived3("Hello", "World")
    val base = Base3("Hello")
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

open class Shape {
    open fun draw() {}
    final fun fill() {}
}

class Circle() : Shape() {
    override fun draw() {}
}

open class Rectangle2() : Shape() {
    final override fun draw() {}
}

class ChildRectangle() : Rectangle2() {
    fun adssadad(): Unit {
        draw()
    }
}

open class Shape2 {
    open val vertexCount = 0
}

class Rectangle3 : Shape2() {
    override val vertexCount = 4
}

interface Shape3 {
    val vertexCount: Int
}

class Rectangle4(override val vertexCount: Int) : Shape3

class Polygon3 : Shape3 {
    override var vertexCount: Int = 0
}

open class Base3(val name: String) {
    init {
        println("Initializing base class")
    }

    open val size: Int = name.length.also(::println)
}

class Derived3(name: String, val lastName: String) :
    Base3(name.replaceFirstChar { it.uppercase() }.also { println() }) {
    init {
        println("Initializing a derived clas")
    }

    override val size: Int = (super.size + lastName.length).also { println("") }
}

open class Rectangle5 {
    open fun draw() {
        println("Drawing a rectangle")
    }

    val borderColor: String get() = "black"
}

class FilledRectangle5 : Rectangle5() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}

open class Rectangle6 {
    open fun draw() {}
}

interface Polygon6 {
    fun draw() {}
}
class Square6() : Rectangle6(), Polygon6{
    override fun draw() {
        super<Rectangle6>.draw()
        super<Polygon6>.draw()
    }
}