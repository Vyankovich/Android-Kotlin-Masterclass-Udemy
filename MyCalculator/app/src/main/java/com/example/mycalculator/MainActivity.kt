package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    // whether last pressed key is numeric or not
    private var lastNumeric = false
    // if true, don't add another dot
    private var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        // call the parent constructor
        super.onCreate(savedInstanceState)
        // align the xml view to this class
        setContentView(R.layout.activity_main)
    }

/**
    appends the numeric Button.text to the View
*/
    fun onDigit(view: View) {
        tvInput.append((view as Button).text)
    // set the flag
        lastNumeric = true
    }

    /**
     * Clear the TextView
     */
    fun onClear(view: View) {
        tvInput.text=""
        // reset flags
        lastNumeric = false
        lastDot = false
    }
    /**
    appends . (dot) to the TextView
     */
    fun onDecimalPoint(view: View) {
        // if the last appended value is numeric and not a dot then append dot
        if (lastNumeric && !lastDot) {
            tvInput.append(".")
            // update flags
            lastNumeric = false
            lastDot = true
        }
    }
    /**
     * Remove the zero after decimal point
     */
    private fun removeZeroAfterDot(result: String): String {
        var value = result
        if (result.contains(".0")) {
            value = result.substring(0, result.length-2)
        }
        return value
    }

    /**
     * Append +,-,*,/ operators to the TextView as per the Button.Text
     */
    fun onOperator(view: View) {
        if (lastNumeric && !isOperatorAdded(tvInput.text.toString())) {
            tvInput.append((view as Button).text)
            lastNumeric = false // update flag
            lastDot = true // reset Dot flag
        }
    }
    /**
     * It is used to check whether any of the operator is used or not.
     */
    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*") ||
            value.contains("+") || value.contains("-")
        }
    }
    /**
     * Calculate the output
     */
    fun onEqual(view: View) {
        // last key should be number in order to get result
        if (lastNumeric) {
            // read text value
            var tvValue = tvInput.text.toString()
            var prefix = ""
            try {
                // remove leading minus in order to point correct delimiter
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                when {
                    tvValue.contains("-") -> {
                        // divide the string into 2 value we want to calculate
                        val splitValue = tvValue.split("-")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }
                        tvInput.text = removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                    }
                    tvValue.contains("+") -> {
                        val splitValue = tvValue.split("+")
                        var one = splitValue[0] // value one
                        var two = splitValue[1] // value two
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }
                        tvInput.text = removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())
                    }
                    tvValue.contains("÷") -> {
                        val splitValue = tvValue.split("÷")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        // if prefix isn't empty we move it back. line 95
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }

                        // calculate the result based on operator and display it to TextView
                        tvInput.text = removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())
                    }
                    tvValue.contains("×") -> {
                        val splitValue = tvValue.split("×")
                        var one = splitValue[0]
                        var two = splitValue[1]
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }
                        tvInput.text = removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                    }
                }
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

}
