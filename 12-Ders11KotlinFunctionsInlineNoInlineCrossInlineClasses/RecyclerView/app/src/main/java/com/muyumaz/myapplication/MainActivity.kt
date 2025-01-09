package com.muyumaz.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recylist)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val list = listOf("1", "2", "3", "4")

        recyclerView.adapter = ListAdapter(list) {
            Toast.makeText(this, "blabla", Toast.LENGTH_SHORT).show()
        }
    }
}