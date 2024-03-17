package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private var infixExpression : String? = ""
    private var postfixExpression : String? = ""
    private var currentValue = "0"

    private val allClear get() = binding.button1
    private val changeSign get() = binding.button2
    private val percentage get() = binding.button3
    private val divide get() = binding.button4

    private val seven get() = binding.button5
    private val eight get() = binding.button6
    private val nine get() = binding.button7
    private val multiply get() = binding.button8

    private val four get() = binding.button9
    private val five get() = binding.button10
    private val six get() = binding.button11
    private val subtract get() = binding.button12

    private val one get() = binding.button13
    private val two get() = binding.button14
    private val three get() = binding.button15
    private val add get() = binding.button16

    private val zero get() = binding.button17
    private val dot get() = binding.button18
    private val equals get() = binding.button19

    private val screenDisplay get() = binding.textView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupOnClickListeners()
    }

    private fun setupOnClickListeners() {
        allClear.setOnClickListener { clearExpression() }
        changeSign.setOnClickListener { changeSignCurrentValue() }
        percentage.setOnClickListener{ getPercentageCurrentValue() }
        divide.setOnClickListener { addOperator('/') }

        seven.setOnClickListener { addDigit('7') }
        eight.setOnClickListener { addDigit('8') }
        nine.setOnClickListener { addDigit('9') }
        multiply.setOnClickListener { addOperator('*') }

        four.setOnClickListener { addDigit('4') }
        five.setOnClickListener { addDigit('5') }
        six.setOnClickListener { addDigit('6') }
        subtract.setOnClickListener { addOperator('-') }

        three.setOnClickListener { addDigit('3') }
        two.setOnClickListener { addDigit('2') }
        one.setOnClickListener { addDigit('1') }
        add.setOnClickListener { addOperator('+') }

        zero.setOnClickListener { addDigit('0') }
        dot.setOnClickListener { addDigit('.') }
        equals.setOnClickListener { evaluateExpression() }

    }

    private fun clearExpression() {
        infixExpression = ""
        postfixExpression = ""
        currentValue = "0"
        screenDisplay.text = addCommasToInteger(currentValue)
    }

    private fun changeSignCurrentValue() {
        currentValue = (currentValue.toInt() * -1).toString()
        screenDisplay.text = addCommasToInteger(currentValue)
    }

    private fun getPercentageCurrentValue() {
        currentValue = (currentValue.toFloat() / 100).toString()
        screenDisplay.text = addCommasToInteger(currentValue)
    }

    private fun addOperator(operator : Char) {
        infixExpression = infixExpression + operator
    }

    private fun addDigit(digit : Char) {
        if (currentValue == "0") {
            currentValue = digit.toString()
        }

        else if (currentValue != "0" && currentValue.length < 9) {
            currentValue = currentValue + digit
        }

        screenDisplay.text = addCommasToInteger(currentValue)
    }

    private fun evaluateExpression() {

    }

    private fun addCommasToInteger(number: String): String {
        val formatter = NumberFormat.getInstance(Locale.US)
        return formatter.format(number.toInt())
    }
}