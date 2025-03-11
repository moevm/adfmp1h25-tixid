package com.tixid.tixid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class GameMapView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint().apply {
        color = android.graphics.Color.WHITE
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }

    private val players = listOf("Рома", "Артур", "Андрей", "Марк") // Фиксированные игроки
    private val positions = mutableListOf<Pair<Float, Float>>() // Координаты игроков

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (positions.isEmpty()) {
            val centerX = width / 2f
            val centerY = height / 2f
            val radius = width / 3f

            for (i in players.indices) {
                val angle = Math.toRadians((360.0 / players.size * i).toDouble()).toFloat()
                val x = centerX + radius * kotlin.math.cos(angle)
                val y = centerY + radius * kotlin.math.sin(angle)
                positions.add(Pair(x, y))
            }
        }



    }
}
