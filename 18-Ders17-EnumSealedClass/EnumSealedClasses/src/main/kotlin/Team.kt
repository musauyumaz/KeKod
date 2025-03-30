package org.example

/*
* Visibility modifierlarla ilgili özel bir kısıtı yok
* primary constructor tanımlanabiliyor
* init bloğu tanımlanabiliyor
* secondary constructor tanımlanabiliyor
*
* enum class'lar başka herhangi bir class'ı miras alamazlar. Başka enum class'ı da miras alamaz
* interface'ler impement edilebiliyor. Eğer implement edilen interface'in body'siz bir fonksiyonu varsa bu durumda bu fonksiyon ya enum class'ının içerisinde ya da enum sabitlerinin her birinin içinde ayrı ayrı override edilmek zorundadır.
* nesnesi üretilemiyor. Öünkü primary constructor'ı mecburi olarak private tutulmak zorunda Primary constructor'ın visibility modifier'ı private dışında diğerlerini kabul etmemektedir.
*
* companion object tanımı yapılabiliyor
*
* sealed, open, abstract innter enum class'lar yapılamıyor. deafult olarak final durumundadırlar. Değiştirilemezler.
* içerisine fun tanımına izin veriyor
* içerisine abbstract fun tanımına izin veriyor ancak bunu yaptığınızda tüm enum sabitleri bu fonksiyonu override etmek zorunda olacaktır.
* open bir fun da yine tanımlayabiliyoruz. Enum sabitleri bu durumda override etmek zorunda kalmıyor. (opsiyonel)
*
* enum sabitlerinin constructor'ları bulunabilir ama içlerine direkt olarak property tanımlanamaz Ancak enum class'ı kendi constructor'ında bir property'e sahipse tüm enum sabitleri bu property'e kendi constructor'larında sahip olmak zorundalar.
* Eğer bu property val ya da var ile tanımlanıyorsa bu enum sabitleri üzerinden bu property'e dışarıdan erişilebilir.
*
* Sabitler tek başlarına bir class'ı miras alamazlar ya da bir interface'i tek başlarına implement edemezler.
* sabitlerin önüne class keyword'ü eklenemiyor. Yapıldığında nested class gibi algılanır
* Sabitlerin içerisine class,function tanımına izin verilmez.
*
* Enum class'lar ve sabitleri özünde class oldukları için toString, hashcode, equals gibi fonksiyonlşarı override edevbilirsiniz.
*
* enum class'ların entries ve values() fonksiyonları bize o enum sabitlerinin listesini verir. Kotlin 1.9 dan sonra entries values() fonksiyonunun yerini almıştır.
* valuesOf() fonksyionu ise o enum'daki belli bir enum sabitini bize döndürür. Eğer yanlış isimlendirme yapılırsa bu durumda IllegalArgumentException alınır.
*
* Enum sabitleri ordinal ve name diye 2 ayrı property'e de sahiptirler. name enum sabitinin birebir ismini döner toString() bağımsızdır. ordinal ise enum sabitinin enum içerisindeki sırasını bize belirtir.(0'dan başlar sabitler.)
*
* enum sabitleri static class formunda bulundukları için nesneleri üretilmeden içerisindeki fonksiyonlara ve property'lere erişebilirsiniz.
*
* Enum sabitinin direkt olarak erişeceksek, bir format kaygımız yoksa zaten enum class'larının bir propertysi olan name'i kullanmalıyız. Eğer bu sabit isminde bir değişiklik yha da format farklılığına gideceksek bu durumda toString'i override etmek en mantıklısı.
* Enum class'ının constructor'ında da bir String property ile de bunu yapabiliriz ama bu çok doğru olmaz.
*
* enum class'ının içerisine yazılabilen düz fonksiyonlara static olmadıkları için dışarıdan erişim yoktur. Bu fonksiyonların amacı enum sabitleri içindeki kodların okunabilirliğini arttırmak için kullanılırlar.
* */

open class A(name : String)

class B(name : String) : A(name)

enum class Team private constructor(val startCount : Int) : SomeInterface {
    FENERBAHCE(3) {
        override fun boo() {
            TODO("Not yet implemented")
        }

        override fun toString(): String {
            return "FENERBAHÇE"
        }
    },
    GALATASARAY(3) {
        override fun boo() {
            TODO("Not yet implemented")
        }
    },
    BESIKTAS(2) {
        override fun boo() {
            TODO("Not yet implemented")
        }
    },
    TRABZONSPOR(2) {
        override fun boo() {
            TODO("Not yet implemented")
        }
    },
    SIVASSPOR(1) {
        override fun boo() {
            TODO("Not yet implemented")
        }
    },
    TOKATSPOR(1) {
        override fun boo() {
            TODO("Not yet implemented")
        }
    },
    YOZGATSPOR(3) {
        override fun boo() {
            TODO("Not yet implemented")
        }

        override fun someDoo() {
            super.someDoo()
        }
    };

    override fun anotherGoo() {
        TODO("Not yet implemented")
    }

    init {

    }

    constructor(type: Int, type2 : Int) : this(type)

    companion object {

    }

    private fun someFoo() {

    }

    abstract fun boo()

    open fun someDoo() {

    }
}

//class SomeOtherClass(1): Team(2)

enum class SomeOtherEnum

interface SomeInterface {

    fun anotherGoo()
    companion object {

    }
}

fun main() {
//    val team = Team()

    Team.BESIKTAS.startCount

    Team.values()
    println(Team.valueOf("YOZGATSPOR").startCount)
    Team.entries

    println(Team.BESIKTAS.name)
    println(Team.BESIKTAS.ordinal)
}

fun printTeam(team : Team){

}