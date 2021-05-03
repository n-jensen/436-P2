package com.example.project2

import android.R.attr.data
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.project2.databinding.FragmentBottomBinding //FOR BIND


class BottomFragment : Fragment(), FragCommunication {
    lateinit var fragBinding: FragmentBottomBinding //FOR BIND
    var activityCallback: FragCommunication? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityCallback = context as FragCommunication
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_bottom, container, false)
        fragBinding = FragmentBottomBinding.inflate(inflater, container, false) //FOR BIND

        fragBinding.oneButton.setOnClickListener() { PassNums(fragBinding.oneButton.id) }
        fragBinding.twoButton.setOnClickListener() { PassNums(fragBinding.twoButton.id) }
        fragBinding.threeButton.setOnClickListener() { PassNums(fragBinding.threeButton.id) }
        fragBinding.fourButton.setOnClickListener() { PassNums(fragBinding.fourButton.id) }
        fragBinding.fiveButton.setOnClickListener() { PassNums(fragBinding.fiveButton.id) }
        fragBinding.sixButton.setOnClickListener() { PassNums(fragBinding.sixButton.id) }
        fragBinding.sevenButton.setOnClickListener() { PassNums(fragBinding.sevenButton.id) }
        fragBinding.eightButton.setOnClickListener() { PassNums(fragBinding.eightButton.id) }
        fragBinding.nineButton.setOnClickListener() { PassNums(fragBinding.nineButton.id) }
        fragBinding.zeroButton.setOnClickListener() { PassNums(fragBinding.zeroButton.id) }

        fragBinding.pointButton.setOnClickListener() { PassNums(fragBinding.pointButton.id) }
        fragBinding.plusButton.setOnClickListener() { PassNums(fragBinding.plusButton.id) }
        fragBinding.minusButton.setOnClickListener() { PassNums(fragBinding.minusButton.id) }
        fragBinding.multiplyButton.setOnClickListener() { PassNums(fragBinding.multiplyButton.id) }
        fragBinding.divideButton.setOnClickListener() { PassNums(fragBinding.divideButton.id) }
        fragBinding.sqrtButton.setOnClickListener() { PassNums(fragBinding.sqrtButton.id) }
        fragBinding.modButton.setOnClickListener() { PassNums(fragBinding.modButton.id) }

        fragBinding.clearAllButton.setOnClickListener() { PassNums(fragBinding.clearAllButton.id) }
        fragBinding.clearRecentButton.setOnClickListener() { PassNums(fragBinding.clearRecentButton.id) }

        fragBinding.equalButton.setOnClickListener() { PassNums(fragBinding.equalButton.id) }

        return fragBinding.root //FOR BIND
    }

    //idNum indicates the ID of the button that was pressed - pass in button ID
    override fun PassNums(idNum : Int) {
        activityCallback?.PassNums(idNum)
    }

}