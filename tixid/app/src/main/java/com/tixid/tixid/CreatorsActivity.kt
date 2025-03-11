package com.tixid.tixid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreatorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creators)

        val creatorsText = findViewById<TextView>(R.id.tv_creators)
        creatorsText.text = "Создатели:\nМусаев Артур\nПоршнев Роман\nНго Тхи Йен"

        val btnBack = findViewById<Button>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
    }
}
