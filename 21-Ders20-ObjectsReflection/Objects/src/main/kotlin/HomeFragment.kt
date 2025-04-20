package org.example

open class BaseFragment

interface SomeFragmentFunction{
    fun foooss()
}

class HomeFragment {
    var valueList: List<Pair<String, Any>> = listOf()

    companion object MyCompanion: BaseFragment(), SomeFragmentFunction{

        const val PI = 3.14

        fun newInstance(valueList: List<Pair<String, Any>>): HomeFragment {
            val fragment = HomeFragment()
            fragment.valueList = valueList
            fragment.valueList = valueList
            fragment.valueList = valueList
            fragment.valueList = valueList
            fragment.valueList = valueList
            fragment.valueList = valueList
            fragment.valueList = valueList
            return fragment
        }

        override fun foooss() {
            TODO("Not yet implemented")
        }
    }
}

object FragmentFactory {
    fun newHomeFragmentInstance(valueList: List<Pair<String, Any>>): HomeFragment {
        val fragment = HomeFragment()
        fragment.valueList = valueList
        fragment.valueList = valueList
        fragment.valueList = valueList
        fragment.valueList = valueList
        fragment.valueList = valueList
        fragment.valueList = valueList
        fragment.valueList = valueList
        return fragment
    }
}

fun main() {
    val homeFragment = HomeFragment()
    homeFragment.valueList = listOf()

    HomeFragment.MyCompanion.newInstance(listOf())
    FragmentFactory.newHomeFragmentInstance(listOf())
}