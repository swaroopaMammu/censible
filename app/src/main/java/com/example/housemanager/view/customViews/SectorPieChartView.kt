package com.example.housemanager.view.customViews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.housemanager.view.model.SplitObject

class SectorPieChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var expenseList: List<SplitObject> = emptyList()
    private val percentList = mutableListOf<Float>()
    private var totalExp = 0.0
    private var centerX = 0f
    private var centerY = 0f
    private var textY = 0f
    private var rectF = RectF()

    private val piePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        typeface = Typeface.DEFAULT_BOLD
        textAlign = Paint.Align.CENTER
    }

    private val legendPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 40f
        textAlign = Paint.Align.LEFT
        typeface = Typeface.SANS_SERIF
    }

    private val legendBoxPaint = Paint().apply {
        style = Paint.Style.FILL
    }

    /** Public function to update the pie chart data */
    fun setExpenses(expList: List<SplitObject>) {
        expenseList = expList
        calculatePercentages()
        invalidate()
    }

    private fun calculatePercentages() {
        percentList.clear()
        totalExp = expenseList.sumOf { it.expense }
        if (totalExp > 0) {
            expenseList.forEach {
                percentList.add((it.expense / totalExp).toFloat())
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        centerX = width / 2f
        centerY = height / 3f
        val radius = (width * 0.35f)
        textPaint.textSize = radius * 0.2f

        rectF = RectF(
            centerX - radius,
            centerY - radius,
            centerX + radius,
            centerY + radius
        )

        textY = centerY - ((textPaint.descent() + textPaint.ascent()) / 2)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var startAngle = 0f

        // Stroke paint for sector separators
        val separatorPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = Color.WHITE
            strokeWidth = 4f
            style = Paint.Style.STROKE
        }

        for (i in percentList.indices) {
            val sweepAngle = percentList[i] * 360f

            // Draw filled sector
            piePaint.color = expenseList[i].color
            canvas.drawArc(rectF, startAngle, sweepAngle, true, piePaint)

            // Draw white separator stroke
            canvas.drawArc(rectF, startAngle, sweepAngle, true, separatorPaint)

            startAngle += sweepAngle
        }

        // Draw center total
        canvas.drawText("₹$totalExp", centerX, textY, textPaint)

        // Draw legend
        val legendLeft = 50f
        var legendTop = rectF.bottom + 80f
        val boxSize = 40f
        val boxPadding = 20f
        for (i in expenseList.indices) {
            legendBoxPaint.color = expenseList[i].color
            canvas.drawRect(legendLeft, legendTop, legendLeft + boxSize, legendTop + boxSize, legendBoxPaint)
            canvas.drawText(expenseList[i].tag, legendLeft + boxSize + boxPadding, legendTop + boxSize, legendPaint)
            legendTop += boxSize + 30f
        }
    }
}
