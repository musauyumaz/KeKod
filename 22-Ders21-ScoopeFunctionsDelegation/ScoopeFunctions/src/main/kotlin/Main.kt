package org.example


data class User(val name: String, val age: Int)

class Student {
    var name: String = ""
    var age: Int = 0

    fun someUserFun(user: User?) {
        val foo = user?.let {
            5
            null
        } ?: run {
            4
        }

        val boo = user?.also {
            5
        } ?: run {
            4
        }

        println("foo: $foo")
        println("boo: $boo")

        run {

        }
    }
}

fun main() {
//    var localName: String? = "Musa"
//
//    // T = Önüne gelen değişken
//    // R = son satır, yani geri dönüş değeri
//    //Lambda param = T
//    val returnValueLet = localName?.let { name: String ->
//        println("let $name")
//    }
//
//    println(returnValueLet)
//
//    // T = Önüne gelen değişken
//    // R = son satır, yani geri dönüş değeri
//    //Lambda param = yok, this = T
//    val returnValueRun = localName?.run {
//        println("run $this")
//    }
//
//    println(returnValueRun)
//
//    // T = yok, extension işlemi yok
//    // R = son satır, yani geri dönüş değeri
//    //Lambda param = yok, this = yok, çünkü extension yok
//    val returnValueRunJustRun = run {
//        println("just run")
//    }
//
//    println(returnValueRunJustRun)
//
//    // T = fonksiyonun fonksiyon olmayan değişken olan parametresi - yani 1.parametre, extension işlemi yok
//    // R = son satır, yani geri dönüş değeri
//    //Lambda param = yok, this = var, çünkü extension function
//    val returnValueWith = with(localName) {
//        println("with $this")
//    }
//
//    println(returnValueWith)
//
//    // T = Önüne gelen değişken
//    // R = yok, Çünkü high order function'ın geri dönüş değeri yok. Onun yerine T geri döndürülüyor.
//    //Lambda param = T, (this = T, çünkü extension function)
//    val returnValueApply = localName?.apply {
//        println("apply  $this")
//    }
//
//    // T = Önüne gelen değişken
//    // R = yok, Çünkü high order function'ın geri dönüş değeri yok. Onun yerine T geri döndürülüyor.
//    //Lambda param = yok, this = yok, çünkü extension yok
//    val returnValueAlso = localName?.also { name: String ->
//        println("also $name")
//    }
//
//    println(returnValueAlso)
//
//    localName.takeIf {
//        true
//    }
//
//    localName.takeUnless {
//        true
//    }

    val user = User("John", 29)
//    val student = Student()

    println(user.age)
    println(user.name)

    val student = Student().apply {
        name = "John"
        age = 29
    }


    val student2 = Student().also {
        it.name = "John"
        it.age = 29
    }

    val user1 = User("Max", 29).apply { }
    val user2 = User("Max", 29).also { }

    println(student.name)
    println(student2.name)
    student.someUserFun(user1)

    val student3 = Student().run {
        name = "John"
        age = 29
        this
    }

    println(student3.name)

    val student4 = Student().let { _student ->
        _student.name = "John"
        _student.age = 29
        _student
    }

    println(student4.name)

    val student5 = with(Student()) {
        name = "John"
        age = 29
        this
    }

    println(student5.name)
}
//
//inline fun <T, R> T.let(block: (T) -> R): R {
//    return block(this)
//}
//
//inline fun <T, R> T.run(block: T.() -> R): R {
//    return block()
//}
//
//inline fun <R> run(block: () -> R): R {
//    return block()
//}
//
//inline fun <T, R> with(receiver: T, block: T.() -> R): R {
//    return receiver.block()
//}
//
//inline fun <T> T.apply(block: T.() -> Unit): T {
//    block()
//    return this
//}
//
//inline fun <T> T.also(block: (T) -> Unit): T {
//    block(this)
//    return this
//}
