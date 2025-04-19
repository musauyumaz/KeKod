class RetrofitKotlin {
    private var newInstance: RetrofitKotlin? = null

    fun getNewInstance(): RetrofitKotlin? {
        if (newInstance == null)
            newInstance = RetrofitKotlin()
        return newInstance
    }
}

object RetrofitObject {
    private var newInstance: RetrofitKotlin? = null
    var baseUrl = "http://10.0.2.2:8080"
}

class EditText {
    fun addTextChangedListener(textWatcher: TextWatcherInterface) {}
}

interface TextWatcherInterface {
    fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int)
    fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int)
    fun afterTextChanged(s: String?)
}

open class TextWatcherClass : TextWatcherInterface{
    val surname = "asdasdsad"
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(s: String?) {
        TODO("Not yet implemented")
    }

}

fun main() {
    RetrofitObject.baseUrl = "asdsad"

    val editText = EditText()
    val textWatcher = object : TextWatcherInterface {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("Not yet implemented")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged(s: String?) {
            TODO("Not yet implemented")
        }
    }

    val textWatcher2 = object : TextWatcherClass(){
        override fun afterTextChanged(s: String?) {
            super.afterTextChanged(s)
        }
    }

    editText.addTextChangedListener(textWatcher)
}


open class A(){
    val age: Int = 34

}

class Deneme: A(){
    val name: String = "Musa"

    private fun assadas(){
        age
    }

    fun demo(){
        val textWatcher = object : TextWatcherClass(){
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println("$name $age $surname")
            }
        }
    }
}