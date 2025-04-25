package org.example

interface Observable {
    fun onGetValue(value: Int)
    fun onValueChanged(oldValue: Int, newValue: Int)
}

class BankAccount2(val observable: Observable) {

    var balance: Int = 0
        get() {
            observable?.onGetValue(field)
            return field
        }
        set(value) {
            val tempValue = field
            field = value
            observable?.onValueChanged(tempValue, field)
        }

}

class BankAccount3(val onGetValue: (Int) -> Unit, val onValueChanged: (Int, Int) -> Unit) {

    var balance: Int = 0
        get() {
            onGetValue(field)
            return field
        }
        set(value) {
            val tempValue = field
            field = value
            onValueChanged(tempValue, field)
        }

}

fun main() {
    val bankAccount2 = BankAccount2(object : Observable {
        override fun onGetValue(value: Int) {
            println("value is $value")
        }

        override fun onValueChanged(oldValue: Int, newValue: Int) {
            println("oldValue is $oldValue and newValue is $newValue")
        }
    })
    bankAccount2.balance = 100
    bankAccount2.balance = 1002
    println(bankAccount2.balance)

    val bankAccount3 = BankAccount3(
        { value: Int -> println("value is $value") },
        { oldValue: Int, newValue: Int -> println("oldValue is $oldValue and newValue is $newValue") })
    bankAccount3.balance = 100
    bankAccount3.balance = 10000
    println(bankAccount3.balance)

    val onGetValue = { value: Int -> println("value is $value")}
    val onValueChanged = { oldValue: Int, newValue: Int -> println("oldValue is $oldValue and newValue is $newValue") }
    val bankAccount4 = BankAccount3(onGetValue, onValueChanged)
    bankAccount4.balance = 100
    bankAccount4.balance = 1002
    println(bankAccount4.balance)

    val onGetValue2 = fun(value: Int) {println("value is $value")}
    val onValueChanged2 = fun(oldValue: Int, newValue: Int) {println("oldValue is $oldValue and newValue is $newValue") }
    val bankAccount5 = BankAccount3(onGetValue2, onValueChanged2)
    bankAccount5.balance = 100
    bankAccount5.balance = 1002
    println(bankAccount5.balance)

    val bankAccount6 = BankAccount3(::onGetValue3, ::onValueChanged3)
    bankAccount6.balance = 100
    bankAccount6.balance = 1002
    println(bankAccount6.balance)


}

fun onValueChanged3(oldValue: Int, newValue: Int) {println("oldValue is $oldValue and newValue is $newValue") }
fun onGetValue3(value: Int) {println("value is $value")}
