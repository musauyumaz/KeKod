package basics

import java.util.*


fun main() {
    //Yaklaşık olarak her karakter başına 2 byte yer kaplar. UTF-16 encoding kullanır.

    //Çift tırnak içerisine yazılan karakterler bütünüdür.
    //Bir String ifadenin tüm karakterlerinin tek tek alıp Char bir listeye atabilirsiniz ya da ekrana yazdırabilirsiniz.

    val name = "KeKod"
    val char1 = 'K'
    val char2 = 'e'
    val char3 = 'K'
    val char4 = 'o'
    val char5 = 'd'

    val nameArray = charArrayOf(char1, char2, char3, char4, char5)

    for (char in name) {
        println(char)
    }

    val awesomeKeKod = "Kekod is Awesome" //16 chars
    val firstCharOfAwesomeKekod = awesomeKeKod[awesomeKeKod.indices.first]
    val firstCharOfAwesomeKekod2 = awesomeKeKod[1]
    val lastCharOfAwesomeKekod = awesomeKeKod[awesomeKeKod.indices.last]
    val lastCharOfAwesomeKekod2 = awesomeKeKod[15]// not 16 index out of range exception
//    val lastCharOfAwesomeKekod2 = awesomeKeKod[awesomeKeKod.length - 1]// not 16 index out of range exception

    println(firstCharOfAwesomeKekod)
    println(firstCharOfAwesomeKekod2)
    println(lastCharOfAwesomeKekod)
    println(lastCharOfAwesomeKekod2)

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //String'ler immutable'dır. Bir String ilk değer ataması yapıldıktan sonra değerini değiştiremez ya da yeni bir değer set edilemez. String üzerinde yapacağınız tüm işlemler sizlere yeni bir String object'ş dönecektir.
    //String'in ilk hali değişmeyecektir.

    var surname2 = "Uyumaz"
    surname2 = "UYUMAZ"

    val surname = "Uyumaz"
    println(surname.uppercase())
    println(surname)

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //Farklı tipteki bir değişkenin önüne String bir değişken ya da ifade koyarak toplarsanız, sonuç String olacaktır.
    //Ancak String bir değişken ya da ifadenin sonuna + operatörü ile farklı tipte bir değişken eklerseniz kod çalışmaz.

    val numbersValue: String = "value" + (4 + 2 + 8)
//    val numbersValue2: String = (4 + 2 + 8).plus("value") // Çalışmaz.
//    val numbersValue2: String = (4 + 2 + 8) + "value" // Çalışmaz.

    println("numbersValue: " + numbersValue)

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Herhangi bri değişken + operatörüne ihtiyaç duyulmadan direkt olarak "" arasına yazılarak kullanılabilir.
    //Bunun için sadece $ işaretine ihtiyacınız vardır. Bu yapıya String template denir.
    //Eğer değişkenin bir özelliğine ihtiyaç duyacaksanız ${} şeklinde kullanılır.

    println("numbersValue $numbersValue")
    println("numbersValue ${numbersValue.length}")

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //3 tane çift tırnak kullanarak Raw String(Multiline String) oluşturulabilir.
    //Raw String'ler IDE'ye nasıl yazılıyorsa öyle kullanılır. Hizalamada bozulma olmaz.
    //trimIndent() fonksiyonu ile bu Raw String'in kenar boşluklarını silebilirsiniz.
    //Bu silme işlemini yaparken tüm satırlardaki en soldaki karakteri baz alarak silme işlemini sağlar.
    //Alttaki örnek için 3 satırdan da $ işaretinin solundaki boşluğa kadar siler.
    //Raw Stringlerin içinde escape karakterler çalışmaz.

    val rawPineTree = """
                *
               ***
              ***** 
    """.trimIndent()

    //trimMargin(marginPrefix) ise verilen karakter ne ise, string satırlarındaki o karaktere kadar olan kısmı siler
    //Yukarıdan farklı olarak bu karakter tek bir satırda ise, sadece o satırın o karaktere kadar olan kısım silinir.
    //trimMargin() ise karaktere bakmadanm tüm satırların en solundaki değeri baz alıp, tüm satırlardan o değerin solundaki boşluk kadar boşluk siler.

    val rawPineTree2 = """
                *
               ***
              ***** 
    """

    val rawPineTree3 = """
              | *
              |***
              ***** 
    """.trimMargin("|")

    val rawPineTree4 = """
 *
***
              ***** 
    """

    println(rawPineTree)
    println(rawPineTree2)
    println(rawPineTree3)
    println(rawPineTree4)

    //Raw String'ler(Multiline Strings) içinde escape karakterler kullanmak için ${'$'} yapısını kullanabilirsiniz.
    //Raw String'ler \ karakterini alamazlar.

    val price = """
        Price ${'$'}_9.99
    """
    val price2 = "Price \$_9.99"

    println(price)

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Kotlin'de String.Format() metodu, Java'nın String.Format() metoduna çok benzer çalışır.
    //Bu metod belirli bir string içinde yer tutucuları belirtilen değerlerle değiştirerek yeni bir string oluşturmanıza olanak tanır. Yer tutucular, formatlama belirtimleriyle tanımlanır ve bu belirtimler değiştirilecek değerlerin nasıl biçimlendirileceğini kontrol eder.

    //%s: String için
    //%d: Tam sayı(Integer) için
    //%f: Kayan Noktalı Sayı(Float/Double) için
    //%n: Yeni bir satıra geçmek için (Platform Bağımsız)

    val yas = 25
    val mesaj = String.format("Yaşım: %d", yas)
    println(mesaj)

    val boy = 1.80
    val boyMesaj = String.format("Boyum: %.2f metre", boy)
    println(boyMesaj)

    val ad = "Musa"
    val adMesaj = String.format("Adım: %s, Yaşım: %d, Boyum: %.2f", ad, yas, boy)
    println(adMesaj)

    val sayi = 1234567.89
    val usFormat = String.format(Locale.US, "US formatında: %,.2f", sayi)
    println(usFormat)

    val localeTR = Locale("tr", "TR")
//    val usFormatTR = String.format(Locale.of("tr","TR"), "TR formatında: %.2f", sayi)
    val usFormatTR = String.format(localeTR, "TR formatında: %,.2f", sayi)
    println(usFormatTR)

}