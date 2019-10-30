package com.example.myfirstapp

import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MessageViewAct : AppCompatActivity() {
    private lateinit var tapMeButton: Button
    private lateinit var textView: TextView
    val changeColor = arrayListOf("#4285F4", "#DB4437", "#F4B400", "#0F9D58", "#F6CCD1", "#E87CFE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_view)

        tapMeButton = findViewById(R.id.tap_button)
        textView = findViewById(R.id.title_view)

        tapMeButton.setOnClickListener{view ->
            val random = Random
            val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
            view.startAnimation(bounceAnimation)

            val randomColor = random.nextInt(changeColor.count())
            val color:String = changeColor[randomColor]
            val colorSet:Int = Color.parseColor(color)
            textView.setTextColor(colorSet)
        }


        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }
    }
}
