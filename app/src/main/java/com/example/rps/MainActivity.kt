package com.example.rps

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private val ivCom by lazy {findViewById<ImageView>(R.id.ivCom)}
    private val ibScissors by lazy {findViewById<ImageButton>(R.id.ibScissors)}
    private val ibStone by lazy {findViewById<ImageButton>(R.id.ibStone)}
    private val ibPaper by lazy {findViewById<ImageButton>(R.id.ibPaper)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ibScissors.setOnClickListener {
            val x= comPlay()
            when (x){
                1 ->showMsg(getText(R.string.draw).toString())
                2 ->showMsg(getText(R.string.you_lose).toString())
                3 ->showMsg(getText(R.string.you_win).toString())
            }
        }
        ibStone.setOnClickListener {
            val x= comPlay()
            when (x){
                1 ->showMsg(getText(R.string.you_win).toString())
                2 ->showMsg(getText(R.string.draw).toString())
                3 ->showMsg(getText(R.string.you_lose).toString())
            }
        }
        ibPaper.setOnClickListener {
            val x= comPlay()
            when (x){
                1 ->showMsg(getText(R.string.you_lose).toString())
                2 ->showMsg(getText(R.string.you_win).toString())
                3 ->showMsg(getText(R.string.draw).toString())

            }
        }
    }
    private fun showMsg(msg:String){
        val dlg = AlertDialog.Builder(this)
        //設定標題 dlg.setTitle(msg)
        dlg.setMessage(msg)
        dlg.setCancelable(false)
        dlg.setPositiveButton("ok"){ dialogInterface: DialogInterface, i: Int ->}
        dlg.show()
    }
    private fun comPlay():Int {
        val x =(Math.random()*3+1).toInt()
        when (x){
            1 -> ivCom.setImageResource(R.drawable.scissors)
            2 -> ivCom.setImageResource(R.drawable.stone)
            3 -> ivCom.setImageResource(R.drawable.paper)
        }
        return x
    }

}