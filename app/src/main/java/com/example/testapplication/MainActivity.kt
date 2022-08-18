package com.example.testapplication

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.list)
        rv.adapter = Adapter().apply { notifyDataSetChanged() }

        val sr = findViewById<SwipeRefreshLayout>(R.id.swipeToRefresh)
        sr.setOnRefreshListener { sr.isRefreshing = false }

        val button = findViewById<View>(R.id.button)
        button.setOnClickListener {
            sr.isEnabled = sr.isEnabled.not()
            button.setBackgroundColor(if (sr.isEnabled) Color.GREEN else Color.RED)
        }
    }
}
