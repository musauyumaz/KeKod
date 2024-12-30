package org.example

fun main() {
    val name: String = "Musa"
    val surname: String
    val age = 25

    surname = readLine()!!
//    surname = "Uyumaz"

    var isMale = true
    var isStudent: Boolean = true

//Eğer bir dilde benzer işi yaptığını gördüğünüz iki tane farklı yapı varsa mutlaka mutlaka %99 bu arkadaşlar farklı bişey yapıyor olmaları lazım(örneğin var val gibi)
//val bir değer ataması yapıldıktan sonra ister değişkeni tanımladığız yerde değer ataması yapın isterseniz farklı bir yerde ilk kez değer ataması bir kere bile yapıldıktan sonra bu değeri bir daha değiştirmeyeceksiniz IDE'ye bunu söylüyorsunuz. var'da ise ben buna bir değer atadım initialize yaptım istersem daha sonrasında bunu değiştirebilirim demek.
//Mümkün olduğu sürece bir fonksiyonda değişkenlerinizi en yukarıda tanımlayın sonra aşağıda kullanın. Bu şekilde anlaşılabilirlik daha da iyi olmaktadır.
    isStudent = false

}

//region notes
/*fun main() {//Özel bir fonksiyondur. Uygulamanın başlangıç noktasını temsil eder.
//Ve siz bu süslü parantez içine ne yazıyorsanız kod bunun ilk satırından itibaren yorumlanmaya başlar ve devam eder.

    println("Hello World!")
}

fun main(args: Array<String>) {//args isimli bir parametre alır. String array alır. Bu da yine başlangıç noktamız olabilir.
    for (lang in args) {
        println(lang)
    }
}*/


//exe dediğinizya da uygulamalarda ikonlarına tıkladığınız şeyler aslında satır satır kodların yorumlanmasından ibaret. Ama bunların bir başlangıç noktasının da olması gerekiyor ya kotlin dili için bir uygulamanın(Console Uygulamaları) başlangıç noktası bir main fonksiyonudur.
//fun main() {//Özel bir fonksiyondur. Uygulamanın başlangıç noktasını temsil eder.
//Ve siz bu süslü parantez içine ne yazıyorsanız kod bunun ilk satırından itibaren yorumlanmaya başlar ve devam eder.
// Fonksiyonlar parametre alan yapılardır.
//endregion
//region Mülakat Soruları
//1.Type inference(Tip Çıkarımı) nedir?
//  Bir değişken tipinin değer atama sırasında değerin tipinin bilinmesi durumu.
//2. val ve var farkı nedir?
//Kotlin'de val, bir kez atanıp sonradan değeri değiştirilemeyen sabitler (immutable) için kullanılırken, var, istediğiniz kadar değiştirebileceğiniz değişkenler (mutable) için kullanılır.
//3. val mi daha maliyetlidir? Yoksa var mı daha maliyetlidir?(Hangisi daha hızlıdır?)
//Yani, val sabit bir değer, var ise değişken bir değer tutar.
//  val ile var arasındaki performans farkı yok denecek kadar az. Yani hiçbir zaman genel anlamda salt bir değişken tanımlarken val mi var mı kullandığınız bişey ifade etmeyecektir.
//  Ama ufacık bile performans farkı olduğunu düşünüyorsanız val değişkenler var değişkenlere göre daha maliyetlidir. Düşünmeye gelirsek eğer val'de tekrardan değer atamaması için her türlü arka planda bir şart yazılmış olacaktır bu yüzden val daha maliyetlidir.
//  Salt dümdüz bir kod üstünde konuşuyorsak var kullanmak daha performanslı ama gözardı edebileceğiniz kadar düşük bir performans günlük hayat problemlerinde ise val kullanmak var'a göre daha avantajlı val daha performanslı hale gelecek bunun sebebi de multithread işlemler yaptığımız için. Bu thread'lerin birbirleriyle olan iletişimlerinin de bir maliyeti olacak çnkü senin değerin neydi? Yeniden ana thread'e bağlanacaksın ana thread senin thread'ini kontrol edecek o thread başka bir thread'i kontrol edecek falan böyle durumlaredan dolayı thread'lerin birbirinin değerini kontrol etme ihtiyacı sizin bir maliyet kaleminiz olarak karşınıza çıkacak.
//  Bu paralelleştirme işlemlerinin thread'lerini birbirleriyle iletişim maliyeti bir yerden sonra o kadar yüksek olur ki siz bir thread daha açarak kodunuzu hızlandıramazsınız aksine yeni bir thread açmanız kodunuzu iletişim maliyetinden dolayı yavaşlatmaya başlar. O iletişim maliyeti çok fazla thread'le çalıştığınız durumda çok ciddi bir yüksekliğe çıkıyor. ve siz bu durumlarda eğer bir değişkenin değerini değiştirilemez olduğunu koda bildirirseniz onun değerini sonradan kontrol etme ihtiyacımızda yok. val değişkene ne dedik? Bir kere initialize olursa bir daha bunun değerini değiştirmeyeceksin. reassigned etmeyeceksin. O yüzden thread'ler birbirleriyle iletişime geçerken bir değişkenin değerinin bir daha değişmeyeceğini biliyorsa onunla ilgili maliyet oldukça azalmış olur. Ama değişkenin değerinin değişebileceğini düşünüyorsa yani var dediyse ona bu durumda onun değerinin ne olduğunu kontrol etmesi gerekiyor ona göre çeşitli işlemler yapması gerekiyor bu da size maliyet kalemi olarak yansıyor. O yüzden gerçek hayat örneklerinde val değişkenler var değişkenlere göre daha performanslı olacak.
// Best practice olarakta val değişkenler kullanılmalıdır. Eğer illaki tekrardan assign etme durumu olursa o durumlarda var değişkenleri kullanın. Normalde var değişken kullanmayın.
//4. var keywordünü kullanarak val değişken nasıl yapabilirsin?
//set fonksiyonunu private yaparız. Bu sayede var değişkeni dışarıdan değer atanamaz hale getiririm. Bu durumda değişkenin ilk değeri neyse o alınır o korunmuş olur.
//endregion

class A() {
    var isMale: Boolean = true
        private set
}