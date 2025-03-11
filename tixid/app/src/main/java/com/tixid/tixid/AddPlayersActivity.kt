package com.tixid.tixid

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddPlayersActivity : AppCompatActivity() {
    private val playersList = listOf("Рома", "Артур", "Андрей", "Марк")
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_players)
        
        val btnStartGame = findViewById<Button>(R.id.btn_start_game)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, playersList)
        listView.adapter = adapter
        
        btnStartGame.setOnClickListener {
            val intent = Intent(this, ChooseCardActivity::class.java)
            startActivity(intent)
        }
        
    }
    

}
