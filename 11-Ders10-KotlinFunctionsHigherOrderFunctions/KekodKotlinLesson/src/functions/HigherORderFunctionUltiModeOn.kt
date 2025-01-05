package functions

fun main() {
    qoo(::wooFun, ::rooFun, yoo = ::yooFun2, poo = ::pooFun, doo = ::dooFun)
    qoo(::wooFun, ::rooFun, ::tooFun, ::yooFun2, ::pooFun, ::dooFun)
}

private fun wooFun() {
    println("woofun called")
}

private fun rooFun(number: Int): String {
    println("roofun called")
    return number.toString()
}

private fun tooFun(number: Int): String {
    println("toofun called")
    return number.toString()
}

private fun String.yooFun(number: Int): String {
    return "$this ${number.toString()}"
}

private fun yooFun2(message: String, number: Int): String {
    println("yoofun2 called")
    return "$message ${number.toString()}"
}

private fun pooFun(soo: () -> Unit) {
    println("poofun called")
    soo()
}

private fun dooFun(foo: () -> Unit): () -> Unit {
    foo()
    return {
        println("resultDoFunction called")
    }
}

private fun localPooFun() {
    println("Soo fun called")
}

private fun localFooFun() {
    println("Doo fun called")
}

fun qoo(
    woo: () -> Unit,
    roo: (Int) -> String,
    too: (Int) -> String = ::defaultToo,
    yoo: String .(Int) -> String,
    poo: (soo: () -> Unit) -> Unit,
    doo: (foo: () -> Unit) -> () -> Unit
) {
    woo()
    val resultRoo: String = roo(5)
    val resultToo: String = too(4)
    val resultYoo: String = yoo("Message", 56)
    poo(::localPooFun)
    val resultDooFunction = doo(::localFooFun)
    resultDooFunction.invoke()
}


private fun defaultToo(number: Int): String {
    return number.toString()
}