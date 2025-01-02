package basics.functions

fun main() {
    /*
    * Daha okunaklı kodlar yazmak için kullanılır.
    * . (nokta) kullanımı kaldırır.
    * Bir fonksiyonu infix hale getirebilmek için 5 şart vardır;
    * 1.infix keywordü ile başlar
    * 2.fonksiyon bir üye fonksiyon olmalıdır. (bir sınıfa ait olmalıdır.)
    * 3. ya da bir extension fonksiyon olmalıdır.
    * 4.sadece bir parametre almalıdır. Bu parametre vararg olamaz.
    * 5.infix method'un parametresi default değer alamaz.
    *
    * Yapısal olarak;
    *
    * infix fun infixMethod(justOneParam: AwesomeParam) : Whatever{
    *
    * }
    * */

    val isStudent = false
    val isMale = true

    /*
    * and, or, xor gibi onlarca infic method vardır.
    * */

    if (!isStudent and isMale) {
        print("Öğrenci Olmayan Erkek")
    }

    //infix kullanımı
    isStudent and isMale
    isStudent.and(isMale)

    val awesomeInstance = AwesomeClass()
    //infix kullanımı
    awesomeInstance downloadImage "www.google.com.tr"
    awesomeInstance.downloadImage("www.google.com.tr")

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    val number = 5
    // matematiksel operatörlerin, tip dönüşümlerin (type conversion), range kullanımın, infix methodlara karşı işlem önceliği vardır.
    if (number + number - 2 * (awesomeInstance specialPlus 4) == 5) {

    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


    //infix methodların da mantık operatörlerine göre önceliği vardır.
    if (number == 3 && number < 5 || awesomeInstance specialPlus 4 == 5) {

    }
}

class AwesomeClass() {
    infix fun downloadImage(imageUrl: String) {

    }

    infix fun specialPlus(number: Int): Int {
        return 4
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Çalışmaz
//    infix fun <T> downloadImage2(vararg imageUrl : T){
//
//    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //bir sınıfın içindeyken this kullanımı size bulunduğu sınıfı işaret eder.(this o sıradaki instance'ı işaret eder class'ı değil. :))
    // aşağıdaki kullanımda AwesomeClass().downloadImage(imageUrl) kullanımı oluşur aslında (implicit)
    fun logWhenDownloaded(imageUrl: String) {
        downloadImage(imageUrl)
//        downloadImage imageUrl
        this downloadImage imageUrl
    }
}
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//Bir sınıfın dışındayken infix method çağırımı yapılırsa this kullanılmaz.
fun logWhenDownloaded(imageUrl: String){
//    this downloadImage imageUrl
}