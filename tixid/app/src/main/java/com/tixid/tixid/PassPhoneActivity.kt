package com.tixid.tixid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PassPhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_phone)

        val btnNext = findViewById<Button>(R.id.btn_next)
        val tvPlayerTurn = findViewById<TextView>(R.id.tv_player_turn)

        val playerName = intent.getStringExtra("PLAYER_NAME") ?: "Игрок"

        tvPlayerTurn.text = "Следующий игрок: $playerName"

        btnNext.setOnClickListener {
            val intent = Intent(this, VotingActivity::class.java)
            startActivity(intent)
        }

    }
}
