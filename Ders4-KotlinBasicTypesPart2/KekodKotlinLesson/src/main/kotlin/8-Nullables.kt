package basics

fun main() {

    //Bir değişkene null değer ataması yapabilemk için değişken tipinin sonuna ? isareti konulur.
    //Eğer bir değişkene tip verilmez ve direkt null değer ataması yapılırsa, IDE tip çikarımı yaparken bu değişkenin değerini Nothing? olarak işaretler. Çünkü hangi tipe karşılık geldiğini bilemez.

    val name: String? = null
    val age: Int? = null

    val number: Nothing? = null

    val number3 = null //Nothing?

    var number1: Int? = null
    var number2: Int? = null

    var result: Int? =
        0//sen burada Int? olarak işaretlediğin zaman değer bile atasan IDE bunun belki ileride null olabileceğini düşündüğü için risk almak istemiyor. Nullable Operatörü istiyor.
    result!!.plus(324)//Kardeşim sen benim işime karışma ben bunun null olmayacağını sana garanti ediyorum. Sen null olduğuyla ilgilenme her halükarda çalıştır.
    result?.plus(324)//Bu kod null olabilir fakat herhangi bir yerde result'a değer verildiyse bu kodu çalıştır. Eğer null'sa çalıştırma. `if result != null` ise bu kodu çalıştır. null'sa çalıştırma null değilse çalıştır.

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //Elimizde nullable bir değişken varsa bu değişkenin methodlarından birine ihtiyaç duyacaksak ya da direkt olarak kullanacaksak bu durumda IDE'ye ya bu değişkenin null olmayacağının garantisini !! operatörünü vermek gerekiyor ya da null değilse çalışsın demek için ?. operatörünü kullanmak gerekiyor.
    //Best practice olarak debug modda çalışırken kodlarımıza !! şeklinde yazmamız Kotlin Null Pointer Exception almamızı sağlar. Bu sayede gözden kaçan nullable değerleri bulabilmemizi sağlar. Ancak canlıya çıkan kodlarda projemizin crash olmaması için ?. kullanmamız daha doğru olacaktır.

    number1 = readLine()!!.toInt()
    number2 = readLine()!!.toInt()

    //yukarıda readline()'nin null olmayacağını !! işaretleriyle söylediğimiz için alt satırda tekrar nullable kod yapmamıza gerek kalmıyor (smart cast özelliği)
    result = number1 + number2

    print(result)

    //nullable kontrolünü böyle yapıyorsanız halen keko bir yazılımcısınızdır.
    if (number1 != null && number2 != null)
        result = number1 + number2
}

//region Mülakat Soruları
// `val number = null` değişkenin tipi nedir?
//IDE bu değişkene özel bir tip olan Nothing? verir. Nothing private constructor'ı olan bir class'tır. Yani bişey ifade etmeyen bir class.
//Nothing değişkenler daha çok bir fonksiyonun değer döndürmek zorunda olmadığı durumlarda mesela exception fırlatacaksınız diyelim o gibi durumlarda exception fırlatmalarda nothing'i çok görürsünüz. Unit'ten farklıdır. Unit bi değer döndüğünü söyler size. Boşta olsa bir değer dönüyor der. Nothing hiçbişey değil. Unit boş bir string gibi("") Nothing null gibi.
//endregion