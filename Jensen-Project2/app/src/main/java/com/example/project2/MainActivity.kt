package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.project2.databinding.ActivityMainBinding //FOR BIND
import net.objecthunter.exp4j.ExpressionBuilder //FOR CALCULATIONS


class MainActivity : AppCompatActivity(), FragCommunication {
    lateinit var bind : ActivityMainBinding
    val bFrag = BottomFragment()
    val tFrag = TopFragment()
    var answrInText = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bFrag.arguments = intent.extras
        val transaction = supportFragmentManager.beginTransaction().add(R.id.btmFragment, bFrag).commit()

        tFrag.arguments = intent.extras
        val transaction1 = supportFragmentManager.beginTransaction().add(R.id.topFragment, tFrag).commit()
    }

    //later: need to parse till find ".", or operator
    override fun PassNums(idNum: Int) {
        var returnNumStr : String = ""
        if (answrInText == true)
        {
            tFrag.SetNumScreen(" ")
            answrInText = false
        }
        when (idNum) {
            R.id.one_button -> returnNumStr = "1" //1 +
            R.id.two_button -> returnNumStr = "2"
            R.id.three_button -> returnNumStr = "3"
            R.id.four_button -> returnNumStr = "4"
            R.id.five_button -> returnNumStr = "5"
            R.id.six_button -> returnNumStr = "6"
            R.id.seven_button -> returnNumStr = "7"
            R.id.eight_button -> returnNumStr = "8"
            R.id.nine_button -> returnNumStr = "9"
            R.id.zero_button -> returnNumStr = "0"

            R.id.point_button -> returnNumStr = "." //drop the space, add decimal
            R.id.plus_button -> returnNumStr = "+"
            R.id.minus_button -> returnNumStr = "-"
            R.id.multiply_button -> returnNumStr = "*"
            R.id.divide_button -> returnNumStr = "/"
            R.id.sqrt_button -> returnNumStr = "sqrt" //will look like: sqrt25*aNum
            R.id.mod_button -> returnNumStr = "%"

            R.id.clear_all_button -> tFrag.ClearAll()
            R.id.clear_recent_button -> tFrag.ClearRecent()

            R.id.equal_button -> GetCalculations()
        }

        tFrag.IntoNumScreen(returnNumStr)
    }

    public fun GetCalculations(){
        var numString = tFrag.GetNumString()

        try
        {
            var expression = ExpressionBuilder(numString).build()
            var answer = expression.evaluate()
            tFrag.SetNumScreen(answer.toString())
            answrInText = true
        }
        catch (e: Exception){
            Log.d("Exception", "error: entry")
            tFrag.SetNumScreen("error")
            answrInText = true
        }

    }


}