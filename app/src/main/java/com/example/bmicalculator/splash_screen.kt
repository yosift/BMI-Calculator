package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class splash_screen : AppCompatActivity() {
    lateinit var mylogo: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        mylogo=findViewById(R.id.mylogo)
        mylogo.animate().alpha(1f).setDuration(3000)

        var intent= Intent(this, home::class.java)
        setdelay(1000,intent)


    }
    fun setdelay(ms:Int,i: Intent)
    {
        android.os.Handler().postDelayed({
            startActivity(i)
        }, 3000)
    }
}