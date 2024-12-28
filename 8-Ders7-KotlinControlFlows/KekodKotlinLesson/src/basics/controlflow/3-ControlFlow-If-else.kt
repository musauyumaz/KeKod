package basics.controlflow

import java.io.IOException

fun main() {
    /*
    * if else case'lerinden sonra suslu parantez açılır ve kapanır.
    * Ancak bu suslu parantezler arasına tek satır kod yazacaksak, süslü parantez kullanmak zorunda değiliz.
    * if - else case'lerinin state ve expression olmak üzere 2 kullanımı vardır. Basitçe;
    * State kullanımı sadece if else kullanarak şartlı durumlarımızı kodlamaktır.
    * Expression kullanımı ise bir value'ya değer olarak eşitliğin karşı tarfına if else kodlarını yazmaktır.
    * Expression olarak yapılan kullanımda, if else case'leri için yazılmış parantezlerin son satırı value olarak
    * */

    println("Öğrenci Misin?")
    val answer = readLine()!!

    //state kullanımı
    if (answer.contains("Evet", ignoreCase = true)) {
        println("Öğrenci")
    } else {
        println("Öğrenci Değil!")
    }

    //Expression kullanımı. {} içerisindeki son satır değer olarak değişkene atanır.
    val result: String = if (answer == "Evet") {
        "Öğrenci"
    } else {
        "Öğrenci Değil"
    }

    println(result)

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Kotlin'de if - else'lerin Expression kullanımından ötürü ternary operatörü yoktur.
    * Ternary yerine aşağıdaki gibi kullanım yapabilirsiniz.
    * */

    val isStudent = false
    val isStudent2 = if (isStudent) {
        "true"
    } else {
        "false"
    }

//    String name2 = isStudent ? "true" : "false" ternary operator

    print("Notunuzu Girinizi : ")
    val grade = readln().toDouble()

    if (grade <= 100 && grade >= 85) {
        println("AA")
    } else if (grade <= 85 && grade >= 70) {
        println("BB")
    } else if (grade <= 70 && grade >= 55) {
        println("CC")
    } else if (grade <= 55 && grade >= 40) {
        println("DD")
    } else {
        println("Sen okulu bırak :)")
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * İki farklı tipteki number değişkenler karşılaştırılırken equals fonksiyonu önce tiplerini karşılaştırdığı için eğer tipler uyuşmuyorsa, IDE hata verecektir.
    * */

//    if(10 == 10L){ //Çalışmaz
//
//    }

    if (10 == 10L.toInt()) {
        println("true")
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Birden fazla şartlı durumunuz varsa bunların her birini, aşağıdaki gibi ayrı ayrı if şekilde yazmak if else şekilde yazmaktan daha kötü performans almanıza yol açar. Zira if else durumnlarında doğru case bulunursa, diğer case'ler kontrol edilmez. Ancak aşağıdaki durumda doğru case bulunsa bile tüm case'ler kontrol edilir.
    * */

    if (grade <= 100) {

    }
    if (grade <= 85) {

    }
    if (grade <= 84) {

    }
    if (grade <= 70) {

    }
    if (grade <= 69) {

    }
    if (grade <= 55) {

    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Bazı durumlarda if else yazmaktansa, if case'ini yazıp return ya da throw gibi kodun devam etmesini bozacak ifadelerle kodu sonlandırabilirsiniz. Kod çalışırken if case'ine girmezse devam eden kod bloğu çalışir ki bu da pratikte else case'i demek olur. Bu şekilde yazım kodu biraz daha temiz gösterecektir.
    * */

    if (isStudent) {
        println("Student")
    } else {
        otherMethod()
    }

    if (isStudent) {
        println("Student")
        throw IOException()
//        return
    }

    otherMethod()

}

private fun otherMethod() {

}