package com.okanserdaroglu.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val KILO_TO_POUND = 2.2045
    private val MARS = 0.38
    private val POUND_TO_KG = 0.45359237

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userKg = editTextWeight.text

        buttonCalculate.setOnClickListener {

            var weightPound = kgToPound(userKg.toString().toDouble())
            var weightInMars = weightPound * MARS
            var weightInMarsKg = poundToKg(weightInMars)

            textViewResult.text = weightInMarsKg.format(2).toString()

        }

    }

    private fun kgToPound(kg: Double): Double {

        return kg * KILO_TO_POUND

    }

    private fun poundToKg(pound: Double): Double {

        return pound * POUND_TO_KG

    }

    private fun Double.format (number : Int) = java.lang.String.format("%.${number}f",this) /** extention function added for Double class */

    override fun onClick(p0: View?) {



    }


}
