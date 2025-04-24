package org.example

class Database2 {
    private val data = mutableMapOf<String, String>()

    fun saveData(key: String, value: String) {
        data[key] = value
        println("Saved '$value' with key '$key' to the database")
    }

    fun loadData(key: String): String {
        return data[key] ?: "No data found"
    }
}

class User2(private val db: Database2) {
    private var _name: String? = null
    private var _email: String? = null

    var name: String
        get() {
            if (_name == null) {
                _name = db.loadData("name")
            }
            return _name ?: "No data found"
        }
        set(value) {
            _name = value
            db.saveData("name", value)
        }

    var email: String
        get() {
            if (_email == null) {
                _email = db.loadData("email")
            }
            return _email ?: "No data found"
        }
        set(value) {
            _email = value
            db.saveData("email", value)
        }
}

fun main() {
    val database2 = Database2()
    val user2 = User2(database2)

    user2.name = "Musa"
    user2.email = "musa.uyumaz73@gmail.com"

    println("User name: ${user2.name}")
    println("User email: ${user2.email}")
}