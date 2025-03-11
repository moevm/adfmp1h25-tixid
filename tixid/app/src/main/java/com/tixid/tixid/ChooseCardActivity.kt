package com.tixid.tixid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChooseCardActivity : AppCompatActivity() {
    private var selectedCard: Int? = null
    private lateinit var adapter: CardAdapter

    private val cardImages = listOf(
        R.drawable.card1, R.drawable.card2, R.drawable.card3,
        R.drawable.card4, R.drawable.card5, R.drawable.card6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_card)

        val gridView = findViewById<GridView>(R.id.card_grid)
        val btnNext = findViewById<Button>(R.id.btn_next)

        adapter = CardAdapter()
        gridView.adapter = adapter

        gridView.setOnItemClickListener { _, _, position, _ ->
            selectedCard = cardImages[position]
            adapter.notifyDataSetChanged()
        }

        btnNext.setOnClickListener {
            if (selectedCard == null) {
                Toast.makeText(this, "Выберите карточку!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private inner class CardAdapter : android.widget.BaseAdapter() {
        override fun getCount(): Int = cardImages.size
        override fun getItem(position: Int): Any = cardImages[position]
        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup?): android.view.View {
            val imageView = ImageView(this@ChooseCardActivity)
            imageView.layoutParams = android.widget.AbsListView.LayoutParams(250, 350)
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
