package com.example.helloworld

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to button
        var timeClicked = 0
        // set on-click listener
        button.setOnClickListener {
            timeClicked += 1
            textView.text = timeClicked.toString()
            Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
    }
}
