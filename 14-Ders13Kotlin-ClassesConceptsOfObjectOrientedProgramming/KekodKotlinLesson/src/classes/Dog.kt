package classes

open class Animal(open val name: String) {
    var feetCount: Int = 4
    var origin: String = "Sivas"
    var tailShape: String = "Oval"

    open fun makeASound(): String {
        return ""
    }

    final fun attackToTheWolf(): Unit {

    }

    fun eat(): Unit {

    }

    fun walk(): Unit {

    }

    fun dance(): Unit {

    }
}

class Dog(override val name: String) : Animal("LillyDogVersion") {
    override fun makeASound(): String {
        return "hav hav"
    }

    fun call(musa: Musa) {
        musa.moo()
    }

    fun call(gencay: Gencay) {
        gencay.goo()
    }
}

class Musa {

}

class Gencay {

}

class Cat(override val name: String) : Animal("Lilly") {
    override fun makeASound(): String {
        return "miyav"
    }
}

fun main() {
    val animal = Animal("")
    val dog = Dog("")
    val cat = Cat("")

    println(dog.makeASound())
    println(cat.makeASound())
}

//open class BaseFragment(val layoutId: Int) : Fragment(){
//    override fun onViewCreate(): View {
//        return inflate.inflater(layoutId)
//    }
//}
//
//class View() {
//}
//
//class DashboardFragment() : BaseFragment(R.layout.fragment_dashboard) {
//}
//
//class ProfileFragment() : BaseFragment(R.layout.fragment_profile) {
//}
