package org.example

/*
*
* Değerlendirme(EValuation) : lateinmit ile tanımlanan değişkenler, başlangıçta değer atanmadan tanımlanır.
* Değer kodun ilerleyen bir noktasında atanmalıdır.
*
* Null Safety: lateinit ile tanımlanan değişkenler null olamaz (non-nullable).
*
* Thread Safety: lateinit varsayılan olarak thread-safe değildir. Eğer birden fazla thread aynı anda erişirse beklenmedik sonuçlar ortaya çıkabilir.
*
* Kullanım Durumu: Genellikle yaşam döngüsü boyunca değeri dışarıdan atancak olan değişkenler için tercih edilir. Örneğin, bir dependency injection framework'ü tarafından atanacak olan veya bir aktivitenin onCreate metodunda atanacak olan değişkenler için idealdir.
*
* */

class MyClass{
    lateinit var lateInitializedProperty : String

    fun initializeProperty() {
        lateInitializedProperty = "Initialized!"
    }

    fun UninitializedPropertyAccessException(){
        println("Value of lateInitializedProperty : $lateInitializedProperty")
    }

    fun printProperty(): Unit {
        if(::lateInitializedProperty.isInitialized){
            println("Value of lateInitializedProperty : $lateInitializedProperty")
        }else{
            println("lateInitializedProperty has not beeen initialized yet.")
        }
    }
}

fun main() {
    val myClass = MyClass()

//    myClass.UninitializedPropertyAccessException()//UninitializedPropertyAccessException
    myClass.initializeProperty()
    myClass.printProperty()
}