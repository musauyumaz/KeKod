package functions

fun main() {

    repeat(10) {
        runAndPrint {
            println(it)
        }
    }
}

inline fun runAndPrint(run: (String) -> Unit) {
    run("Message")
}