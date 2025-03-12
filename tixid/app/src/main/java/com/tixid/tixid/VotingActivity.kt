package com.tixid.tixid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class VotingActivity : AppCompatActivity() {
    private var selectedCard: Int? = null
    private lateinit var adapter: CardAdapter

    private val cardImages = listOf(
        R.drawable.card1, R.drawable.card2, R.drawable.card3,
        R.drawable.card4, R.drawable.card5, R.drawable.card6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voting)

        val tvLeaderName = findViewById<TextView>(R.id.tv_leader_name)
        val gridView = findViewById<GridView>(R.id.card_grid)
        val btnNext = findViewById<Button>(R.id.btn_next)
        val btnPause = findViewById<Button>(R.id.btn_pause)

        val leaderName = "Рома"
        tvLeaderName.text = "Выберите карточку ведущего: $leaderName"

        adapter = CardAdapter()
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            selectedCard = cardImages[position]
            adapter.notifyDataSetChanged()
        }

        btnNext.setOnClickListener {
            if (selectedCard == null) {
                Toast.makeText(this, "Выберите карточку для голосования!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, GameMapActivity::class.java)
                startActivity(intent)
            }
        }

        btnPause.setOnClickListener {
            val intent = Intent(this, PauseActivity::class.java)
            startActivity(intent)
        }
    }

    private inner class CardAdapter : BaseAdapter() {
        override fun getCount(): Int = cardImages.size
        override fun getItem(position: Int): Any = cardImages[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val imageView = ImageView(this@VotingActivity)
            imageView.layoutParams = AbsListView.LayoutParams(250, 350)
            imageView.setImageResource(cardImages[position])

            if (selectedCard == cardImages[position]) {
                imageView.alpha = 0.5f
            } else {
                imageView.alpha = 1.0f
            }

            return imageView
        }
    }
}
