package com.example.coffee

import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val myImageView: ImageView = findViewById(R.id.imageview)

        val images = listOf(
            R.drawable.capuccino,
            R.drawable.latte,
            R.drawable.espresso
        )

        val myRadioGroup: RadioGroup = findViewById<RadioGroup>(R.id.coffee_radiogroup)

        myRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val myRadioButton: RadioButton = findViewById(checkedId)
            if (checkedId==R.id.cappuccino_radio)
            {
                myImageView.setImageResource(images[0])
            }
            else if (checkedId==R.id.latte_radio)
            {
                myImageView.setImageResource(images[1])
            }
            else if (checkedId==R.id.espresso_radio)
            {
                myImageView.setImageResource(images[2])
            }
        }

        val myTextView: TextView = findViewById<TextView>(R.id.textview)

        val seekBar = findViewById<SeekBar>(R.id.coffee_amount)

        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                myTextView.text = "Ilość kaw: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })






    }
}