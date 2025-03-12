package com.tixid.tixid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity

class StatisticsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics)

        val listView = findViewById<ListView>(R.id.stats_list)
        val btnMainMenu = findViewById<Button>(R.id.btn_main_menu)

        val playersStats = listOf(
            mapOf("name" to "Рома", "score" to "Побед: 5, Игр: 10"),
            mapOf("name" to "Артур", "score" to "Побед: 3, Игр: 8"),
            mapOf("name" to "Андрей", "score" to "Побед: 7, Игр: 12"),
            mapOf("name" to "Марк", "score" to "Побед: 4, Игр: 9")
        )

        val adapter = SimpleAdapter(
            this,
            playersStats,
            android.R.layout.simple_list_item_2,
            arrayOf("name", "score"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        listView.adapter = adapter

        btnMainMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}
