package functions

import java.util.*
import kotlin.concurrent.schedule

fun main() {
    /*
    * Fonksiyonlar Kotlinde First Class Citizen'dır. Yani değişkenlere değer olarak atanabilir. başka fonksi... parametre olarak verilebilir ya da bir fonksiyonun geri dönüş değeri olabilir demektir.
    *
    * Higher Order Function'lar basitçe bir foksiyona parametre olarak verilen fonksiyonlarıdr. Parametre olarak verilmekten kasıt, fonksiyonun çağırımının parametre kısmında yapılması değil fonksiyonun gövdesinin(body) yani süslü parantezler arasında kalan görev alanının başka bir fonksiyona parametre olarak verilmesidir
    *
    * Yasıla olarak;
    *
    * fun foo(normalFunction: (message: String) -> Unit){
    *   normalFunction("Codemy")
    * }
    *
    * fun foo(boo: String){
    * }
    *
    * Çağırılırken;
    * fun main(){
    *
    *   foo({message ->
    *       println("Message : $message")
    *   })
    * }
    * */

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Higher Order Function'ları tanımlamanın 3 yolu vardır.
    *
    * Bir değişkene atayarak Function tanımlayabilirsiniz.
    * Bu durumda süslü parantezler yanına higher order function'ın aldığı parametreler lambda okundan önce aralarına koyularak yazılır. Higher Order Function tek parametre alıyorsa bu parametreleri yazmak zorunda değilsinizdir. Bu durumda higher order function size "it" kelimesi ile higher order function'ın parametresi tipinde bir değişken
    * */
    val higherOrderFunction = { surname: String -> "surname : $surname" }

    //İsmi olmayan anonymous function tanımlamaları da Higher Order Function olarak normal bir fonksiyona parametre olarak verilebilir.
    val anonymousFunction = fun(surname: String): String {
        return "surname : $surname"
    }

    //Anonymous Function'in expression kullanımını da yine Higher Order Function olarak normal bir fonksiyona parametre olarak verilebilir.
    val anonymous2 = fun(surname: String): String = "surname : $surname"

    //Higher Order Function'la aynı parametre sayısına sahip ve bu parametrelerin hepsinin ... parametre tipleri ile aynı ise bu normal fonksiyon da Higher Order Function olarak normal bir fonksiyona parametre olarak verilebilir. Bunu yapmak için sadece başına :: işareti koymak yeterlidir.
    val news = News()
    news.read(::println)
    news.read({ title -> print("asdsadassa") })
//    news.read(title -> print(title))
//    news.read(print(it))
    val titleFun = fun(title: String): Unit {
        print(title)
    }

    news.read(titleFun)

    printUserInfo(getName(), higherOrderFunction, getAge())
    printUserInfo(getName(), anonymousFunction, getAge())
    printUserInfo(getName(), fun(surname: String): String {
        return "surname : $surname"
    }, getAge())

    //Süslü parantezler (body) direkt olarak Higher Order Function'in parametre olarak beklendiği alana da yazılabilir
    printUserInfo(getName(), {
        "surname : $it"
    }, getAge())

    getItemClickListener({ buttonName ->
        println("$buttonName tıklandı..")
    })

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Eğer bir fonksiyon parametreleri içerisinde bir Higher Order Function son parametre olarak tanımlandıysa bu durum isteniyorsa bu higher order function, fonksiyon parametrelerinin dışına yazılabilir. Daha temiz bir kullanım yapmış oluruz.
    * */

    val newsType = NewsType()
    news.getNewsFromServer("Fox TV", newsType, {
        println(this.toString())
    })//Higher Order Function, fonksiyon parametrelerinin içerisinde tanımlanmıştır.

    news.getNewsFromServer("Fox TV", newsType) {
        println(this.toString())
    }//Higher Order Function, fonksiyon parametrelerinin dışında tanımlanmıştır.

    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
    * Higher Order Function birde fazla parametre içeriyorsa aralarınba virgül koyarak lambda işareti ile tanımlamak zor... Tek parametreye sahipse bu durumda parametre ismi ve lambda işareti koyulmayabilir. Bu durumda ilgili parametreyi "it" kelimesi ile çağırılabilecektir.
    * Eğer bir fonksiyon parametre olarak sadece Higher Order Function alıyorsa bu durumda fonksiyon parantezlerini hiç...
    *
    * */

    news.filterNews { filterType, getFilterName ->
        print("asdasdad")
    }
}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//Normal Fonksiyon
fun getName(): String {
    return "Musa"
}

//Normal Fonksiyon, expression kullanıma örnek
fun getAge(): Int = 25

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
* 2. parametre Higher Order Fonksiyon olarak tanımlanmıştır.
* Higher Order Fonksiyonlar default değer alabilirler. Bunun için basitçe süslü parantezler açmak yeterlidir.
* Dikkat edilmesi gereken konu bu süslü parantezler içine, Higher Order Function parametre bekliyorsa, bunlar verilmelidir.
* */

fun printUserInfo(name: String, getSurname: (surname: String) -> String = { surname -> "" }, age: Int): Unit {
    println("name:  $name, age: $age")

    println(getSurname("UYUMAZ"))
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
* Higher Order Fınction'a parametre tanımlanırken sadece değişken tipini tanımlayarak da (değişken adı olmadan) kullanılabilir.
* */

fun getItemClickListener(onClick: (String) -> Unit) {
    println("Tıklama işlemi başlatılıyor")

    Timer().schedule(delay = 3000) {
        //Bir higher order function paramtere olarak yazıldıktan sonra bu parametrenin normal fonksiyon içerisinde çağırılması gerekmektedir. Aksi halde bu higher order fonksiyonu tanımlamak mantıksız olur. Normal fonksiyonunun çağrıldığı alandaki higher oder function'ın body kısmı hiçbir zaman çağırılmaz demek olur
        onClick("Login")

        println("Tıklama işlemi bitti")
    }
}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class News {
    fun getNewsType(newsType: NewsType): String {
        return when (newsType.toString()) {
            NewsType.breakingNews -> "Breaking"
            NewsType.urgent -> "Urgent"
            NewsType.local -> "Local"
            NewsType.global -> "Global"
            else -> "Normal"
        }
    }
}

class NewsType {
    companion object {
        val breakingNews = "BreakingNews"
        val urgent = "Urgent"
        val local = "Local"
        val global = "Global"
        val normal = "Normal"
    }
}

/*
* Bir Higher ORder Function'ına parametre verirken Clas ismi.() şeklinde tanımlama yapılabilir. Bu sayede ilgili class'da parametre parantezi içerisine yazılabilir
* */

fun News.getNewsFromServer(channelType: String, newsType: NewsType, getNews: NewsType.(Int) -> Unit) {
    when (channelType) {
        "KanalD" -> {
            getNews(newsType, 1)
        }

        "ShowTv" -> {
            getNews(newsType, 2)
        }
        "Tv8" -> {
            getNews(newsType, 3)
        }
        "CNN" -> {
            getNews(newsType, 4)
        }
        "Trt1" -> {
            getNews(newsType, 5)
        }
    }

}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
* Bir Higher Order Function'sın parametresi de yine Higher Order Function olabilir.
* */

infix fun News.filterNews(getFilter: (filterType: String, getFilterName: () -> String) -> Unit){
    getFilter("filterName"){
        "String return label"
    }
}

fun News.read(readTitle: (title:String) -> Unit){
    readTitle("Codemy is Awesome")
}