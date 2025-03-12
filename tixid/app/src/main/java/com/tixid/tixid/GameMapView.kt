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

    private val players = listOf("Рома", "Артур", "Андрей", "Марк")
    private val positions = mutableListOf<Pair<Float, Float>>()

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

        for (i in positions.indices) {
            val (x1, y1) = positions[i]
            val (x2, y2) = positions[(i + 1) % positions.size]
            canvas.drawLine(x1, y1, x2, y2, paint)
        }

        for ((index, pos) in positions.withIndex()) {
            val x = pos.first
            val y = pos.second
            canvas.drawCircle(x, y, 50f, paint)

            paint.textSize = 40f
            paint.style = Paint.Style.FILL
            canvas.drawText(players[index], x - 30, y + 10, paint)
            paint.style = Paint.Style.STROKE
        }
    }
}
