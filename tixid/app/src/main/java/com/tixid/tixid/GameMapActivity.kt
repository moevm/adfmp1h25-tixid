package com.tixid.tixid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GameMapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_map)

        val btnStartRound = findViewById<Button>(R.id.btn_start_round)
        val btnPause = findViewById<Button>(R.id.btn_pause)

        btnStartRound.setOnClickListener {
            val intent = Intent(this, WinScreenActivity::class.java)
            startActivity(intent)
        }

        btnPause.setOnClickListener {
            val intent = Intent(this, PauseActivity::class.java)
            startActivity(intent)
        }
    }
}
