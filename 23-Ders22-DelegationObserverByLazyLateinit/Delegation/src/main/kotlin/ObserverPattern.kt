package org.example

interface PropertyObserver {
    fun onPropertyChanged(oldValue: Int, newValue: Int)
}

class ObservableProperty(var balance: Int) {
    val observers = mutableListOf<PropertyObserver>()

    fun setValue(newValue: Int) {
        if (newValue != balance) {
            val tempOldValue = balance
            balance = newValue
            notifyObservers(tempOldValue, newValue)
        }
    }

    fun addObserver(observer: PropertyObserver) {
        observers.add(observer)
    }

    private fun notifyObservers(oldValue: Int, newValue: Int) {
        for (observer in observers) {
            observer.onPropertyChanged(oldValue, newValue)
        }
    }
}

class BankAccount : PropertyObserver {
    override fun onPropertyChanged(oldValue: Int, newValue: Int) {
        println("$oldValue -> $newValue")
    }
}


fun main() {
    val observableProperty = ObservableProperty(0)
    val bankAccount = BankAccount()
    observableProperty.addObserver(bankAccount)
    observableProperty.setValue(1000)
//    observableProperty.observers.clear()
    observableProperty.setValue(100)
}
