package org.example

abstract class Human(val name: String, val eventManager: EventManager) {

    open val age: Int = 26
    val eyeColor: String = "blue"

    abstract val middleName: String
    abstract val surname: String

    fun sendEvent() {
        eventManager.sendEvent(name)
    }

    open fun getEventType() {
        eventManager.getEvent(name)
    }

    abstract fun display()
}

class A(eventManager: EventManager, override val middleName: String = "wsadadaswd") : Human("Turk", eventManager) {
    override val surname: String = "adasdd"
    override fun display() {
        TODO("Not yet implemented")
    }

    override val age: Int
        get() = super.age

    override fun getEventType() {
        super.getEventType()
    }

}


abstract class A2(eventManager: EventManager, override val middleName: String) : Human("Turk", eventManager) {
    abstract val skinColor: String
    override val surname: String = "asdsad"
}

open class B(eventManager: EventManager, override val middleName: String) : Human("Kurt", eventManager) {
    //    abstract val blabla: String = "asdsadd"
    override val surname: String = "asdsada"
    override fun display() {
        TODO("Not yet implemented")
    }
}

class ChildA2(override val surname: String) : A2(eventManager = EventManager(), "middleName") {
    override val skinColor: String = "adsadadas"
    override fun display() {
        TODO("Not yet implemented")
    }
}

class ChildB() : B(eventManager = EventManager(), "child") {
    //    abstract val blabla: String = "asdsadd"
    override val surname: String
        get() = super.surname
}

fun main(args: Array<String>) {
//    val human = Human("Arkhu", 18)
    val childA2 = ChildA2("sadsad")
    val b = B(EventManager(), "asdasd")
}

class EventManager {
    fun sendEvent(name: String): Unit {}

    fun getEvent(name: String): Event {
        return Event()
    }
}

class Event