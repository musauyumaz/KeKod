package functions


fun main() {
    runAndPrint({ println(it) }, { println(it) })
}

inline fun runAndPrint(run: (String) -> Unit, noinline logger: (String) -> Unit) {
    log(logger)
    run("Message")
    logger("End")
}

fun log(logger: (String) -> Unit): Unit {
    logger("Start")
}

//inline keywordü her seferinde fonksiyondan instance oluşmasını engeller. higher order functionın içindeki datayı metodun içine taşır.
//ama bu build süresinde hız kaybına yol açar iyice değerlendirmek gerekir. inline keyword'ünü kullanırken.
//Çok fazla kullanılıyorsa inline yapmak mantıklı. Build alırken generate edilen dosyayı büyütür.

//Higher order function'ın Parametresinde birden fazla eğer fonksiyonunuz varsa noinline kullanmak isteyebilirsiniz. Bu sayede hiçbirinin nesnesinin üretilmemesini sağlarsınız.

class HomeFragment() {
    val homeListAdapter = HomeListAdapter({

    })
}

class HomeListAdapter(onClick: (View) -> Unit) {
    init {
        val homeListViewHolder = HomeListViewHolder()
        homeListViewHolder.bind(onClick)
        homeListViewHolder bind onClick
    }
}

class HomeListViewHolder() {
    inline infix fun bind(noinline onClick: (View) -> Unit): Unit {
        val button = Button()
        button.setOnClickListener(onClick)
//        button.setOnClickListener {
//            onClick.invoke(it)
//        }
    }
}

class Button() {
    fun setOnClickListener(onClick: (View) -> Unit): Unit {

    }
}

class View() {

}