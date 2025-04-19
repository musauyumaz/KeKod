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

fun main() {
    RetrofitObject.baseUrl = "asdsad"
}