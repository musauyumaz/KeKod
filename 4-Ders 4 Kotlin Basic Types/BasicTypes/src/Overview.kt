package basics

fun main() {
    val name : String = "Musa"
    val age : Int = 25
    val isTrue : Boolean = true
    val firstLetterOfSurname : Char = 'U'
}

//region Mülakat Soruları
//1. Kotlin'de madem herşey bir class'sa biz primitive tiplere sahip değil miyiz?
//Normalde primitive olduğunu bildiğimiz class gibi gözüken değişken tipleri özel optimizasyonlarla bytecode'a çevrilirken yine primitive olacak şekilde çevriliyorlar.
//Kotlin’de kullanıcı açısından her şey bir sınıf gibi görünür. Ancak bu, JVM seviyesinde performans kaybı olmaması için primitive tiplerle optimize edilir.
//Kotlin, primitiflerin güçlü performansını ve referans tiplerinin esnekliğini birleştirerek daha temiz ve modern bir API sunar.

//2.val değişkeni ile var değişkenin farkı nedir?
//Çok bilinenin aksine val değişkenler immutable değil readonly değişkenlerdir. readonly değeri okunabilen(ama değişemez anlamına gelmez) set edilemeyen değişkendir. immutable ise değeri hiçbir şekilde değişemez değişkendir.
//val ile tanımlanan değişkenin referansı değişmez, ancak referansın işaret ettiği nesne değişebilir.
//var ile tanımlanan değişkenin hem referansı hem de değeri değiştirilebilir.

//3. var bir değişkeni val nasıl yaparsınız? val keywordünü kullanmadan
class A{
    var name : String = "MUSA"
        private set
}
//endregion