import TextWatcher.Companion.name

interface TextWatcher {
    fun onTextChanged()
    fun beforeTextChanged()
    fun afterTextChanged()

    fun funWithBody(): Unit {

    }

    companion object{
        var name: String = "Musa"
    }
}

interface ChildInterface : TextWatcher{
    override fun onTextChanged() {}
    override fun beforeTextChanged() {}
    override fun afterTextChanged() {}
}

class InterfaceSample() : ChildInterface{
    override fun beforeTextChanged() {
    }

    override fun afterTextChanged() {
    }

    var text: String = "asdsada"


}

fun main() {

//    val textWatcher = TextWatcher()
    val textWatcher = object : TextWatcher {
        override fun onTextChanged() {
            TODO("Not yet implemented")
        }

        override fun beforeTextChanged() {
            TODO("Not yet implemented")
        }

        override fun afterTextChanged() {
            TODO("Not yet implemented")
        }

        override fun funWithBody() {
            super.funWithBody()

            name
        }
    }


}