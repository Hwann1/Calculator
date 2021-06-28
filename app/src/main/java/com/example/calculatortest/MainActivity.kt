package com.example.calculatortest

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        btnAdd.setOnClickListener {
            saveData(edtNum1.text.toString().toInt(),
            edtNum2.text.toString().toInt())
            startActivity<PlusActivity>(
                "num1" to edtNum1.text.toString(),
                "num2" to edtNum2.text.toString()
            )
        }

        btnSub.setOnClickListener {
            saveData(edtNum1.text.toString().toInt(),edtNum2.text.toString().toInt())
            startActivity<MinusActivity>(
                "num1" to edtNum1.text.toString(),
                "num2" to edtNum2.text.toString()
            )
        }

        btnMul.setOnClickListener {
            saveData(edtNum1.text.toString().toInt(),edtNum2.text.toString().toInt())
            startActivity<MulActivity>(
                "num1" to edtNum1.text.toString(),
                "num2" to edtNum2.text.toString()
            )
        }

        btnDiv.setOnClickListener {
            saveData(edtNum1.text.toString().toInt(),edtNum2.text.toString().toInt())
            startActivity<DivActivity>(
                "num1" to edtNum1.text.toString(),
                "num2" to edtNum2.text.toString()
            )
        }
    }

    private fun saveData(num1: Int,num2: Int){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor=pref.edit()

        editor.putInt("KEY_NUM1",num1)
            .putInt("KEY_NUM2",num2)
            .apply()
    }
    private fun loadData(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val num1 = pref.getInt("KEY_NUM1",0)
        val num2 = pref.getInt("KEY_NUM2",0)

        if(num1 !=0 && num2 !=0){
            edtNum1.setText(num1.toString())
            edtNum2.setText(num2.toString())
        }
    }
}