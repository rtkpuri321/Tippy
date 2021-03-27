package com.example.tippy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tippy.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calbut.setOnClickListener { calculateTip() }
    }

    fun calculateTip() {
        val stringInTextField = binding.costServ.text.toString()
        val cost = stringInTextField.toDouble()

        val tipper = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.opt1 -> 0.20
            R.id.opt2 -> 0.18
            else -> 0.15
        }

        var ans = tipper * cost

        if (binding.roundUp.isChecked) {
            ans = kotlin.math.ceil(ans)
        }

        val formattedTip = NumberFormat.getCurrencyInstance().format(ans)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}