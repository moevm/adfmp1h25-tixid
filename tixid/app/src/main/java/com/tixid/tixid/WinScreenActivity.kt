package com.tixid.tixid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WinScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_screen)

        val tvWinner = findViewById<TextView>(R.id.tv_winner)
        val btnMainMenu = findViewById<Button>(R.id.btn_main_menu)

        val winnerName = intent.getStringExtra("WINNER_NAME") ?: "Рома"
        tvWinner.text = "Поздравляем! Победил $winnerName!"

        btnMainMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}
