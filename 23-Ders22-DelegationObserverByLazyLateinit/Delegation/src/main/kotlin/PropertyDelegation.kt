package org.example

import kotlin.reflect.KProperty

//Seperation of Concern - User sınıfı verileri yönetirken, Delegate sınıf veritabanı işlerini, Database sınıfı ise veritabanı implementasyonunu yönetir.
class Database {
    private val data = mutableMapOf<String, String>()

    fun saveData(key: String, value: String) {
        data[key] = value
        println("Saved '$value' with key '$key' to the database")
    }

    fun loadData(key: String): String {
        return data[key] ?: "No data found"
    }
}

//eğer DB'de bir değişiklik olkursa user sınıfı bu değişikliği bilmek zorunda değil, sadece Delegate sınıfta düzenleme yapılır.
class DatabaseDelegate(private val db: Database, private val key: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return db.loadData(key)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        db.saveData(key, value)
    }
}

//User sınıfı veritabanı implementasyonundan haberdar değil. encapsulation
class User(db: Database) {
    var name: String by DatabaseDelegate(db, "name")
    var email: String by DatabaseDelegate(db, "email")
}

fun main() {
    val database = Database()
    val user = User(database)


    user.name = "Musa"
    user.email = "musa.uyumaz73@gmail.com"

    println("User name: ${user.name}")
    println("User email: ${user.email}")
}