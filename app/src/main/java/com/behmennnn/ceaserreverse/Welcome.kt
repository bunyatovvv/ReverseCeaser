package com.behmennnn.ceaserreverse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.behmennnn.ceaserreverse.databinding.ActivityWelcomeWindowBinding

class Welcome : AppCompatActivity() {
    private lateinit var bind: ActivityWelcomeWindowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind= ActivityWelcomeWindowBinding.inflate(layoutInflater)
        setContentView(bind.root)


        bind.createButton.setOnClickListener {
            val input = bind.inputEditText.text.toString()
            val caesar = caesarCipher(input,3)
            val reverse = reverseCipher(input)

            when(bind.radiogroup.checkedRadioButtonId){
                bind.caesar.id -> bind.resultText.text = caesar
                bind.reverse.id -> bind.resultText.text = reverse
            }
        }
    }

    fun reverseCipher(text: String): String {
        return text.reversed()
    }

    fun caesarCipher(text: String, shift: Int): String {
        val result = StringBuilder()
        for (char in text) {
            if (char.isLetter()) {
                val base = if (char.isLowerCase()) 'a' else 'A'
                val shiftedChar = ((char - base + shift) % 26 + base.code).toChar()
                result.append(shiftedChar)
            } else {
                result.append(char)
            }
        }
        return result.toString()
    }
}