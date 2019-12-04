package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = findViewById<EditText>(R.id.editTextCarPrice)
        val b = findViewById<EditText>(R.id.editTextDownPayment)
        val c = findViewById<EditText>(R.id.editTextInterestRate)
        val d = findViewById<EditText>(R.id.editTextLoanPeriod)

        val textLoan = findViewById<TextView>(R.id.textView)
        val textInterest = findViewById<TextView>(R.id.textView2)
        val textMonthly = findViewById<TextView>(R.id.textView3)

        val calculate = findViewById<Button>(R.id.buttonCalculate)
        val clear = findViewById<Button>(R.id.buttonReset)

        calculate.setOnClickListener {
            val carPrice = a.text.toString().toInt()
            val downPayment = b.text.toString().toInt()
            val interestRate = c.text.toString().toDouble() /100
            val loanPeriod = d.text.toString().toInt()

            val carLoan = carPrice - downPayment
            val interest = carLoan * interestRate * loanPeriod
            val monthlyRepayment = (carLoan + interest) / loanPeriod / 12

            textLoan.setText(carLoan.toString())
            textInterest.setText(interest.toString())
            textMonthly.setText(String.format("%.2f", (monthlyRepayment)))
        }

        clear.setOnClickListener {
            a.setText("")
            b.setText("")
            c.setText("")
            d.setText("")
            textLoan.setText("")
            textInterest.setText("")
            textMonthly.setText("")
        }
    }
}
