package org.example

sealed class SealedTeams {
    object Fenerbahce : SealedTeams()
    object Gelatasaray : SealedTeams()
    object Besiktas : SealedTeams()
    object Trabzonspor : SealedTeams()
}

sealed class SealedTeams2
object Fenerbahce : SealedTeams2()
object Gelatasaray : SealedTeams2()
object Besiktas : SealedTeams2()
object Trabzonspor : SealedTeams2()

enum class TeamsEnum(starCount : Int): SS{
    Fenerbahce(3) {
        override fun print() {
            TODO("Not yet implemented")
        }
    }, Galatasaray(4) {
        override fun print() {
            TODO("Not yet implemented")
        }
    }, Besiktas(2) {
        override fun print() {
            TODO("Not yet implemented")
        }
    }, Trabzonspor(1) {
        override fun print() {
            TODO("Not yet implemented")
        }
    }
}

interface SS{
    fun print()
}

fun main() {
    val sealedFB = SealedTeams.Fenerbahce
    val sealedFB2 = Fenerbahce

    val fb = TeamsEnum.Fenerbahce
}