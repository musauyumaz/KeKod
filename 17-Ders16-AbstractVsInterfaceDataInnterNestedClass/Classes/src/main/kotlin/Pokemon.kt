package org.example

class Pokemon(name: String, type: String, age: Int, origin: String)

/* CLASS
* Mutlaka primary constructor'a sahip olmak zorunda değil
* Mutlaka en azından 1 tane parametre içermek zorunda değil
* Parametre(leri) varsa val ya da var olmak zorunda değil
* Parametreleri default değer alabilir.
* init blockuna sahip
* body'li ya da body'siz kullanılabilir.
* Secondary constructor içerebilir.
* Member property tanımlanabilir
* Visibility modifier'ları kullanabiliyorum.
* Default'u final'dır ama open'da yapılabilir. Dolayısıyla miras alınabilir.
* abstract ya da open sınıfları miras alabilir
* interface'leri implement edebiliriz.
* sealed yapılabilir
* inner & nested yapılabilir
* companion object içerebilir.
* */

/* DATA CLASS
* Mutlaka primary constructor'a sahip olacak
* Mutlaka en azından 1 tane parametre içerecek primary constructor
* Mutlaka bu parametre val/var ile yazılmış olacak.
* Parametreleri default değer alabilir. Bu konu mapping kütüphanelerinin(jackson,gson) boş constructor'a sahip olması gerekliliğinden ötürü önemlidir.
* init blockuna sahip
* body'li ya da body'siz kullanılabilir.
* Secondary constructor içerebilir.
* Member property ve function tanımlanabilir.
* Member property'lerin component function'ları generate edilmez.
* Member property'ler copy, hashcode, equals ve toString fonksiyonları generate edilirken kullanılmazlar.
* Visibility modifier'ları kullanabiliyorum.
* open kullanamıyorum yani miras alamazsınız default olarak final formda bulunuyor
* abstract ya da open sınıfları miras alabilir
* interface'leri implement edebiliriz.
* sealed yapılamıyor
* inner yapılamıyor ama nested olarak bulunabilir.
* companion object içerebilir.
* Eğer generage edilen fonksiyonlardan biri data class içerisinde override edilirse, generate edilmesi engellenir ve böylece class içindeki implementasyon geçerli olur. toString() örneği gibi.
* */

data class PokemonData(val name: String = "") : Boo, A() {

    var age: Int = 0
    override fun foo() {
        TODO("Not yet implemented")
    }
}

open class A

interface Boo {
    fun foo()
}

fun main() {
    val pokemonData = PokemonData()
    val pokemonData2 = PokemonData("asdsad")

    val pair: Pair<String, String> = Pair(pokemonData2.name!!, pokemonData2.name!!)
    val pair2: Triple<String, String, Int> = Triple(",", "", 123)

    pair.first
    pair.second

    pair2.first
    pair2.second
    pair2.third

    val (name,surname) = pair
}