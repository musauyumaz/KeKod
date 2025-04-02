package org.example

fun main() {
    calculate(5.toShort(), 5)

    val homeFragment = HomeFragment()
    val dashboardFragment = DashboardFragment()

    homeFragment.call()
    dashboardFragment.call()
}

fun calculate(param1: Number, param2: Number): Int {
    return param1.toInt() + param2.toInt()
}

abstract class BaseFragment<T> {
    fun<T> printNumber(param: T, param2: T) {
        println(param.toString().toInt() + param2.toString().toInt())
    }
}

class HomeFragment : BaseFragment<Int>() {
    fun call() {
        printNumber(2, 3)
    }
}

class DashboardFragment : BaseFragment<Double>() {
    fun call() {
        printNumber(4.2, 4.2)
    }
}

class A