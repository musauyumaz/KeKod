fun main() {
    // Kotlinde her şey bir nesnedir. Öyle ki herhangi bir değişkende üye fonksiyonları ve özellikleri çağırabilirsiniz.

    //Diğer programlama dillerinden aşina olduğumuz ilkel veri tiğleri (primitive types) Kotlin'de birer sınıf (class) gibi görünürler. Buna rağmen çalışma zamanında sınıf (class) olmayan ilkel(primitive) hallerine optimize edilirler.
    //Bu primitive tiplerden değişkenler oluşturduktan sonra "Show Kotlin Bytecode" özelliği ile Java'daki halleriyle karşılaştırılabilir.

    //Bu değişken tipleri aşağıdakiler gibidir;
    //Numbers ve onların Unsigned muadilleri.
    //Booleans
    //Characters
    //Strings
    //Arrays

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Bir değişken oluşturmak i.in "val" ya da "var" kelimelerinden istifade edilir.
    //val = "Değeri sonradan değiştirilemez, değişken" "Value" sabit değer kelimesinin kısaltmasıdır.
    //var = "Değeri sonradan değiştirilebilir, değişken" "Variable" değişken kelimesinin kısaltmasıdır.

    //val değişkenlerer genelde immutable dendiğini duyarsınız. Fakat bu yanlış bir ifadedir.
    //Çünkü;
    //readonly demek ilk değer atamasından sonra tekrar değer atanamaz demek.
    //immutable ise bir değişkenin / nesnenin durumu asla ilk değerden farklı olamaz demek.
    //Aşağıdaki calculateAvaliableSpace() fonksiyonunu inceleyebilirsiniz bunun için.
    //val olarak tanımlanan avaliableSpace değişkeninin değeri her seferinde farklı sonuç üretmektedir.
    //https://xabaras.medium.com/kotlin-val-is-read-only-not-immutable-585ce2e5359b

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // val değişken ile var değişken arasında bir performans farkı bulunmuyor denebilir.
    // Yine de akademik seviyede konuşuyorsak, var değişkenler bir "readonly" gibi şarta sahip olmadıkları için gözardı edilebilecek kadar ufak bir farkla val değişkenlere göre performanslıdır.

    //Bunun yanında değer yazdığınız proje multi-thread işlemler gerçekleştiriyorsa, bu işlemlerde kullanılan değişkenlerin birbirlerinin son durumlarını kontrol etme ihtiyacının yarattığı maliyet çok daha ciddi performans sorunlarına yol açmaktadır. Bu sebeple genel kabul (best-practice) olarak val değişkenlerin var değişkenlerden daha performanslı olduğu söylenir.
    //Tüm bu sebeplerle bir değişken tanımladığınızda önce val olarak tanımlamanız, sonrasında başka bir yerde bu değişkenin değerini değiştirecekseniz eğer var yapmanız pek çok açıdan daha kullanışlıdır.

    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Bir class'ın üye değişkenini var olarak tanımlayıp, bu değişkenin önündeki var kelimesini değiştirmeden nasıl val yapabileceğimiz bizlere sorulur.
    //Bunun yolu var değişkenin set fonksiyonunu private yapmamızdır. Bu durumda değişken var olsada readonly hale dönüşür.
    //Aşağıdaki testUser() fonksiyonunda bunu test edebilirsiniz.
}

fun createName(): String {
    val name: String = "Musa"
    return name
}

fun createAge(): Int {
    val age: Int = 25
    return age
}

fun createIsMale(): Boolean {
    val isMale: Boolean = true
    return isMale
}

fun createFirstLetterOfSurname(): Char {
    val firstLeterSurname: Char = 'U'
    return firstLeterSurname
}

fun crateKnownLanguageList(): Array<String> {
    val knownLanguageList: Array<String> = arrayOf("TR", "EN")
    return knownLanguageList
}

fun createSurnameWithoutFirstInit(): String {
    val surname: String
    surname = "UYUMAZ"
    return surname
}

class Box {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 50
    var usedSpace: Int = 0

    val avaliableSpace: Int
        get() {
            return (width * height * length) - usedSpace
        }
}

fun calculateAvaliableSpace() {
    val box = Box()
    box.height = 10
    box.width = 20
    box.length = 5
    box.usedSpace = 2
    println(box.avaliableSpace)

    box.height = 30
    box.width = 10
    box.length = 8
    box.usedSpace = 0
    println(box.avaliableSpace)
}

class User {
    val name: String = "Musa"
    var surname: String = "UYUMAZ"
        private set
}

fun testUser(){
    val user = User()
//    user.name = "Serhat"
//    user.surname = "Uyumaz"
}