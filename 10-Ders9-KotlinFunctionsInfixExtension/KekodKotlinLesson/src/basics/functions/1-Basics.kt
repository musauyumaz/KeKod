package basics.functions

fun main() {

}

/*
* Default değeri olan parametrelere sahip bir fonksiyon Java sınıflarından çağırılacaksa eğer bu fonksiyona @JvmOverloads annotation'i verilmelidir. Böylece yazılan kod Jvm'e hazır hale getirilirken ilgili fonksiyonun tüm varyasyonları yazılır(overload edilir.)
* */

@JvmOverloads
fun print(message: String = "Message") {
    println(message)
}

/*
* Extend edilebilir bir sınıf, yavru(child) sınıf tarafından miras(inherit) alınırsa ve bu sınıfın override edilebilir open bir metodu varsa bu method default argument'e sahip olursa bu sınıfı miras alan sinifta method override edilirse, override edilen methodun parametresine default argument Üst sınıfın methodundaki default argument değeri geçerli olur.
* */

open class A {
    open fun foo(i: Int = 10) {

    }
}

class B : A() {
    override fun foo(i: Int) {

    }
}

// Bir fonksiyona = koyularak da return edeceği değer yazılabilir (Single-Expression Kullanımı)

val userlist = arrayOfNulls<String>(5)

fun getListCount(): Int = userlist.size
fun getListCount2() = userlist.size

fun getListCount3(): Int {
    return userlist.size
}