package com.okanserdaroglu.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var userKg : String = ""
    private val constantKiloToPound : Double = 2.2045
    private val constantMars : Double = 0.38
    private val constantPoundToKg : Double = 0.45359237
    private val constantVenus : Double = 0.91
    private val constantJupiter : Double = 2.34
    private var weightPound : Double = 0.0
    private var weightInMars : Double = 0.0
    private var weightInMarsKg : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
        checkBoxJupiter.setOnClickListener(this)
        checkBoxMars.setOnClickListener(this)
        checkBoxVenus.setOnClickListener(this)

    }

    private fun kgToPound(kg: Double): Double {

        return kg * constantKiloToPound

    }

    private fun poundToKg(pound: Double): Double {

        return pound * constantPoundToKg

    }

    private fun Double.format (number : Int) = java.lang.String.format("%.${number}f",this)
    //extension function added for Double class

    override fun onClick(v: View?) {

        if (!TextUtils.isEmpty(editTextWeight.text.toString())) {
            userKg = editTextWeight.text.toString()
            weightPound = kgToPound(userKg.toDouble())
        } else {
            return
        }

        when (v) {
            is CheckBox -> { // check v is a checkBox

                weightInPound(weightPound,v)

            }
            is Button -> { // check v is a button

                weightInMars = weightPound * constantMars
                weightInMarsKg = poundToKg(weightInMars)

                textViewResult.text = weightInMarsKg.format(2).toString()

            }
        }


    }

    private fun weightInPound (pound : Double, checkBox: CheckBox){

        var result = 0.0

        when (checkBox.id){

            R.id.checkBoxMars -> result = pound * constantMars
            R.id.checkBoxVenus -> result = pound * constantVenus
            R.id.checkBoxJupiter -> result = pound * constantJupiter

        }

        val resultToKg = poundToKg(result)
        textViewResult.text = resultToKg.format(2).toString()

    }


}
