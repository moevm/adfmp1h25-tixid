package com.tixid.tixid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNewGame = findViewById<Button>(R.id.btn_new_game)
        val btnStatistics = findViewById<Button>(R.id.btn_statistics)
        val btnCreators = findViewById<Button>(R.id.btn_creators)

        btnCreators.setOnClickListener {
            val intent = Intent(this, CreatorsActivity::class.java)
            startActivity(intent)
        }
    }
}
