package org.example

import kotlin.reflect.KVisibility
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.isAccessible

class Account private constructor(val test: String) {
    private var balance: Long = 3243534634
    private val accountName: String = "Hirda Hesap"

    private constructor(branchName: String, branchCode: Int) : this(branchName) {
        println("2. Constructor tetiklendi parametreler branchName : $branchName, branchCode : $branchCode")
    }

    private fun sendMoneyFromBalance(sendedMoney: Long) {
        balance = balance - sendedMoney
    }
}

fun main() {
//    val account = Account()
//    println(account.balance)
//    println(account.accountName)
//    account.sendMoneyFromBalance(100L)
//    println(account.balance)
//    println(account.accountName)

    val constructorsList = Account::class.constructors
    constructorsList.forEach { constructor ->
        println(constructor.parameters.size)
    }

    val primaryConstructor = Account::class.primaryConstructor
    primaryConstructor?.isAccessible = true
    val account: Account? = primaryConstructor?.call("Maltepe")
    println(account?.test)

    Account::class.memberProperties.forEach { property ->

        if (property.visibility == KVisibility.PRIVATE && property is kotlin.reflect.KMutableProperty<*>) {
            property.isAccessible = true

            if (property.name == "balance") {
                val privateFieldValue = property.getter.call(account)
                println("privateFiled değeri: $privateFieldValue")
            }
        }
    }
}