package com.tixid.tixid

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddPlayersActivity : AppCompatActivity() {
    private val playersList = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_players)

        val listView = findViewById<ListView>(R.id.players_list)
        val btnAddPlayer = findViewById<Button>(R.id.btn_add_player)
        val btnStartGame = findViewById<Button>(R.id.btn_start_game)
        val btnMainMenu = findViewById<Button>(R.id.btn_main_menu)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, playersList)
        listView.adapter = adapter

        btnAddPlayer.setOnClickListener {
            showAddPlayerDialog()
        }

        btnStartGame.setOnClickListener {
            if (playersList.size < 3) {
                Toast.makeText(this, "Добавьте минимум 3 игроков", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ChooseCardActivity::class.java)
                startActivity(intent)
            }
        }

        btnMainMenu.setOnClickListener {
            finish()
        }

        listView.setOnItemLongClickListener { _, _, position, _ ->
            removePlayer(position)
            true
        }
    }

    private fun showAddPlayerDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Введите имя игрока")

        val input = EditText(this)
        builder.setView(input)

        builder.setPositiveButton("Добавить") { _, _ ->
            val name = input.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(this, "Имя не может быть пустым", Toast.LENGTH_SHORT).show()
            } else if (playersList.contains(name)) {
                showErrorDialog("Такой игрок уже есть в списке!")
            } else {
                playersList.add(name)
                adapter.notifyDataSetChanged()
            }
        }

        builder.setNegativeButton("Отмена") { dialog, _ -> dialog.dismiss() }

        builder.show()
    }

    private fun showErrorDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ошибка")
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        builder.show()
    }

    private fun removePlayer(position: Int) {
        playersList.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}
