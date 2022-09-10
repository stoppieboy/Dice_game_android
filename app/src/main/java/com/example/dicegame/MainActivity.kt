package com.example.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener { rollDice() }
        rollDice()
    }

    /**
     * Roll the dice and update the textView
     */
    private fun rollDice() {
        // Create a dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the text with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableRes = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableRes)
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(private val sides: Int){
        fun roll(): Int{
            return (1..sides).random()
        }
    }
}