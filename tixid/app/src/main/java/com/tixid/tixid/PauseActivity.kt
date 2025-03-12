package com.tixid.tixid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PauseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pause)

        val btnResume = findViewById<Button>(R.id.btn_resume)
        val btnExit = findViewById<Button>(R.id.btn_exit)

        btnResume.setOnClickListener {
            finish()
        }

        btnExit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}
