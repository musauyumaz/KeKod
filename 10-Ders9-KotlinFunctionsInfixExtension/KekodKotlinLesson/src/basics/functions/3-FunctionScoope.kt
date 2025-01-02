package basics.functions

/*
* Bir fonksiyon herhangi bir sınıfın içerisinde değil de bir dosyanın içerisinde boşlukta tanımlanıyorsa top level function adını alır.
* Bir fonksiyon oluşturulurken top level tanımlama yapılamıyor, sadece bir sınıfa ait fonksiyonlar yazılabiliyorsa bunlara fonksiyon değil method denir. Bir fonksiyona fonksiyon diyebilmemiz için top level olması lazımdır.
* */

fun main() {
    calculateAtomPhysics()

//    fun calculateAtomPhysics2(): Unit { //Local Functions
//
//    }
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
* Fonksiyon içerisinde fonksiyon tanımı kotlinde yapılabilir. Bu fonksiyonlara Local Functions denir. Sebebi ise, yazdığınız fonksiyonun kendi sınıfınızdan dahi çağırılmasını istemeyebilirsiniz. Bu fonksiyonun herhangi bir başka fonksiyon ya da sınıf için değiştirilmesini istemeyebilirsiniz. Reflection ile fonksiyonlarınız erişilirken gizli kalsın isteyebilirsiniz. Bu gibi durumlarda bu çok önemli fonksiyonunuzu başka bir fonksiyon içerisine yazabilirsiniz.
*
* */

fun calculateAtomPhysics(): Unit {
    val userName = "Codemy"
    println("Initialize Process...")

//    val numberOne = readLine()!!.toInt()
//    val numberTwo = readLine()!!.toInt()
//    val result = numberOne + numberTwo
//    println("$result")

//    val numberThree = readLine()!!.toInt()
//    val numberFour = readLine()!!.toInt()
//    val result2 = numberThree + numberFour
//    println("$result2")

//    getValuesFromUserAndPrint()

    fun getValuesFromUserAndPrint() {
        userName.length
        val numberOne = readLine()!!.toInt()
        val numberTwo = readLine()!!.toInt()
        val result = numberOne + numberTwo
        println("$result")
    }

    getValuesFromUserAndPrint()
}

/*
* Bir sınıfın içerisindeki fonksiyonlara üye fonksiyonlar denir.
* */

class Car {
    fun setColor(colorCodeId: Int) {

    }
}

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
* Bir fonksiyon Generic tip alıyorsa, Generic Function olarak adlandırılır.
* */
fun <T> setColor(colorCodeId: T) {

}
