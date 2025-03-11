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



    }
}
