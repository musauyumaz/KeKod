interface TextWatcher {
    fun onTextChanged()
    fun beforeTextChanged()
    fun afterTextChanged()

    fun funWithBody(): Unit {

    }
}

interface ChildInterface : TextWatcher{
    override fun onTextChanged() {
    }
}

class InterfaceSample : ChildInterface{
    override fun beforeTextChanged() {
    }

    override fun afterTextChanged() {
    }

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
        }
    }
}