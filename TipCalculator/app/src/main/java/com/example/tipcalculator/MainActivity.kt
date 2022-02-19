package com.example.tipcalculator

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.isDigitsOnly
import com.example.tipcalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun calculateTip(billTotal: Int) {
            if (binding.billTotal.text.isDigitsOnly()) {
                val beforeTip = binding.billTotal.text.toString().toInt()

                var ten = beforeTip * 1.1
                ten = String.format("%.3f", ten).toDouble()

                var fifteen = beforeTip * 1.15
                fifteen = String.format("%.3f", fifteen).toDouble()

                var twenty = beforeTip * 1.2
                twenty = String.format("%.3f", twenty).toDouble()

                binding.tipTotal.text = "The tips are as follows\n10% = $ten\n15% = $fifteen\n20% = $twenty"
            } else {
                binding.tipTotal.text = "You must enter a bill amount"
            }
        }

        binding.button.setOnClickListener {
            if (binding.billTotal.text.isDigitsOnly()) {
                calculateTip(binding.billTotal.text.toString().toInt())
            } else {
                binding.tipTotal.text = "YOU MUST ENTER A BILL AMOUNT"
            }

        }


    }





}