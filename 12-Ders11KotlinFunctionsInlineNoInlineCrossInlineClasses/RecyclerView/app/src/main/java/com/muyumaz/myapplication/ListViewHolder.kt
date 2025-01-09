package com.muyumaz.myapplication

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ListViewHolder(itemView: View) : ViewHolder(itemView) {

    val txtName: LinearLayout

    init {
        txtName = itemView.findViewById(R.id.lnrRootView)
    }

    inline fun bind(crossinline onClick: (View) -> Unit): Unit {
        txtName.setOnClickListener{
            onClick.invoke(it)
        }

//        txtName.setOnClickListener(onClick)
    }
}