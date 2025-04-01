package org.example

class RecyclerView {
    val outerName: String = "RecyclerView"

    class ViewHolder {
        val nestedName: String = "ViewHolder"

//        fun getOuterName():String{
//            return outerName
//        }
    }
}

class RecyclerView2 {
    val outerName: String = "RecyclerView2"

    inner class ViewHolder {
        val nestedName: String = "ViewHolder2"

        fun getOuterName():String{
            return outerName
        }
    }
}

fun main() {
    val recyclerView = RecyclerView()
    val viewHolder = RecyclerView.ViewHolder()

    val recyclerView2 = RecyclerView2()
    val viewHolder2 = RecyclerView2().ViewHolder()
}