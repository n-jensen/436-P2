package com.example.project2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.project2.databinding.FragmentTopBinding //FOR BIND


class TopFragment : Fragment() {
    lateinit var fragBinding: FragmentTopBinding //FOR BIND

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_top, container, false)
        fragBinding = FragmentTopBinding.inflate(inflater, container, false) //FOR BIND


        return fragBinding.root //FOR BIND
    }

    public fun IntoNumScreen(singleNum : String){
        if(fragBinding.numView.text == "0"){
            fragBinding.numView.text = singleNum
        }
        else if (fragBinding.numView.text != "0")
        {
            var str = fragBinding.numView.text.toString()
            fragBinding.numView.text = str + singleNum
        }
    }

    public fun SetNumScreen(answer : String){
        fragBinding.numView.text = answer
    }


    public fun ClearAll(){
        fragBinding.numView.text = ""
    }

    public fun ClearRecent() {
        if(fragBinding.numView.text.toString().takeLast(4) == "sqrt")
            fragBinding.numView.text = fragBinding.numView.text.toString().dropLast(4) //no space - -looks like sqrt4
        else if(fragBinding.numView.text.toString().takeLast(1) == " ")
            fragBinding.numView.text = fragBinding.numView.text.toString().dropLast(2) //includes space
        else
            fragBinding.numView.text = fragBinding.numView.text.toString().dropLast(1) //includes space

    }

    public fun GetNumString() : String{
        return  fragBinding.numView.text.toString()
    }
}