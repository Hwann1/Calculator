package com.example.calculatortest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.toast

class MulActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mul)

        val num1=intent.getStringExtra("num1")?.toInt()
        val num2=intent.getStringExtra("num2")?.toInt()

        val MulResult = (num1!! * num2!!)

        toast("$MulResult")
    }
}