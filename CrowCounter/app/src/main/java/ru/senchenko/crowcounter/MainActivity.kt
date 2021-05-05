package ru.senchenko.crowcounter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mCount : Int = 0
    private lateinit var mShowCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mShowCount = findViewById(R.id.show_count)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", mCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mCount = savedInstanceState.getInt("count")
        mShowCount.text = mCount.toString()
    }

    fun goInfo(view: View) {
        val intent = Intent(this, InfoActivity::class.java)
        val countString = mShowCount.text.toString()
        val count = Integer.parseInt(countString)
        intent.putExtra(InfoActivity.TOTAL_COUNT, count)
        startActivity(intent)
    }

    fun countUp(view: View) {
        ++mCount
        mShowCount.text = mCount.toString()
    }
}