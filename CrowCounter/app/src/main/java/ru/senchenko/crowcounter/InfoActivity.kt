package ru.senchenko.crowcounter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    private lateinit var mShowCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        mShowCount = findViewById(R.id.show_count_info)
        showNumber()
    }

    fun showNumber() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        mShowCount.text = count.toString()
    }

}