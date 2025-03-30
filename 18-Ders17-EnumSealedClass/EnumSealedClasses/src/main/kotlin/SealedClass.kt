package org.example

/*
* Visibility modifierlarla ilgili özel bir kısıtı yok
* primary constructor tanımlanabiliyor.
* init bloğu tanımlanabiliyor
* secondary constructor tanımlanabiliyor
*
* sealed class'lar başka bir class'ı miras alabilirler. Bu class'ın open sealed, abstract olması farketmez.
* interface tanımında bir problem yoktur. Eğer body'siz bir fonksiyonu varsa subClass'lar bunu override etmek zorunda.
*
* init'i ve constructor'ı olsa bile nesnesi direkt olarak üretilemiyor. ve primary constructor'ı default olarak private değil protected olarak bulunuyor. Bu primary constructor içerisinde tanımlanan property sub class'larda ister constructor içerisinde ister birer sabit olarak miras alındığı yerde değeri atanabilir.
*
* Eğer constructor'ı private'a çekerseniz bu sayede sub class'ların bu class scoope'u dışında miras alınmasını engellemiş olursunuz. Bu da özellikle daha da kısıtlı bir hiyerarşi kurmak istediğiniz kütüpphane kullanımlarında (closed api) önemlidir.
*
* companion object tanımı yapılabiliyor.
*
* İçerisinde hali hazırda subsclass'ları olan bir sealed class'ı dışarıda bir yerde başka bir class'a miras olarak veremiyoruz.
*
* final ya da open yapılamıyorlar.open, abstract innter enum class'lar yapılamıyor. zaten abstract formunda bulunuyorlar.
*
* içerisine fun tanımına izin veriyor
* içerisine abbstract fun tanımına izin veriyor ancak bunu yaptığınızda tüm enum sabitleri bu fonksiyonu override etmek zorunda olacaktır.
* open bir fun da yine tanımlayabiliyoruz. Enum sabitleri bu durumda override etmek zorunda kalmıyor. (opsiyonel)
*
* direct class'ların constructor'ında sealed class'tan bağımsız property'ler tanımlanabiliyor.
* direct class'larda sealed class'lardan bağımsız interface implement edebiliyor.
* direct class'lar zaten açık bir şekilde sealed class2ı miras aldıklarıdnan başka bir class'ı miras alamazlar Multiple inheritance kotlinde desteklenmiyor.
* Direct class'lar içerisinde sealed class'tan bağımsız olarak companion object tanımlanabilir.
* Direct class'lar içerisinde normal open ve abstract fun tanımı yapılabilir. Abstract fun tanımı kullanılabilmesi için direct class'ında abstract olması gerekir.
*
* direct class'lar enum class dışında diğer class türleri olabilirler. sealed, inner, abstract, data olabilir ancak enum class olamamasının sebebi; enum class'lar bir başka class'ı miras alamazlar. Ama sealed class'ların sub class'ları açık bir şekilde zaten sealed class'ı alabilmelilerdi.
*
* Enum class'lar ve sabitleri özünde class oldukları için toString, hashcode, equals gibi fonksiyonlşarı override edevbilirsiniz.
* */

sealed class Errors constructor(val errorCode: Int) : A1(), B1 {
    abstract class NoInternet(val errorMessage: String) : Errors(100), SomeInterface2 {
        override fun someMethod(): String {
            TODO("Not yet implemented")
        }

        override fun soo() {
            TODO("Not yet implemented")
        }

        fun specialFun() {

        }
        open fun specialFun2() {

        }
        abstract fun specialFun3()
    }

    class ServerError : Errors(200) {
        override fun someMethod(): String {
            TODO("Not yet implemented")
        }
    }

    class FileIOError(errorCode: Int) : Errors(errorCode) {
        override fun someMethod(): String {
            TODO("Not yet implemented")
        }
    }

    fun someMethod2(): String {
        return ""
    }

//    abstract fun boo()

    companion object {

    }

    init {

    }

//    constructor(errorCode: Int) : this()
}

interface SomeInterface2 {
    fun soo()
}

open class A1

open class C1 : Errors(1) {
    //Direct class direct sub class child class
    override fun someMethod(): String {
        TODO("Not yet implemented")
    }

}

class Foo : C1() //indirect class, indirect sub class indirect child classs

interface B1 {
    fun someMethod(): String
}

fun main() {
//    val error : Errors()
}