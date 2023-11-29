package com.example.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.bmicalculator.Result
import java.lang.Exception

class home : AppCompatActivity() {


    lateinit var text_wieght:TextView
    lateinit var text_age:TextView
    lateinit var minus_wiegth_btn:ImageButton
    lateinit var plus_wiegth_btn:ImageButton
    lateinit var minus_age_btn:ImageButton
    lateinit var plus_age_btn:ImageButton
    lateinit var calc:Button
    lateinit var value:TextView


    var value_wiegth=0
    var value_age=0
    var hieght=0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val seek = findViewById<SeekBar>(R.id.seekBar)
        text_wieght=findViewById(R.id.text_wieght)
        text_age=findViewById(R.id.text_age)
        minus_wiegth_btn=findViewById(R.id.m_wieght)
        plus_wiegth_btn=findViewById(R.id.p_wieght)
        minus_age_btn=findViewById(R.id.m_age)
        plus_age_btn=findViewById(R.id.p_age)
        calc=findViewById(R.id.calculate)
        value=findViewById(R.id.value)




        minus_wiegth_btn.setOnClickListener(View.OnClickListener {
           if(value_wiegth>0)
           {
               value_wiegth--
               text_wieght.text=value_wiegth.toString()

           }
            else
           {
               Toast.makeText(this, "canot minus ", Toast.LENGTH_SHORT).show()
           }
        })
        plus_wiegth_btn.setOnClickListener(View.OnClickListener {
            if(value_wiegth<200)
            {
                value_wiegth++
                text_wieght.text=value_wiegth.toString()
            }
            else
            {
                Toast.makeText(this, "canot add again ", Toast.LENGTH_SHORT).show()
            }

        })








        minus_age_btn.setOnClickListener(View.OnClickListener {
            if(value_age>0)
            {
                value_age--
                text_age.text=value_age.toString()

            }
            else
            {
                Toast.makeText(this, "canot minus ", Toast.LENGTH_SHORT).show()
            }
        })
        plus_age_btn.setOnClickListener(View.OnClickListener {
            if(value_age<150)
            {
                value_age++
                text_age.text=value_age.toString()
            }
            else
            {
                Toast.makeText(this, "canot  add again ", Toast.LENGTH_SHORT).show()
            }

        })


        calc.setOnClickListener(View.OnClickListener {
            try {



                if(value_age<=10||value_wiegth<=20||hieght<=60)
                {
                    if(value_age<=10)
                    {
                        Toast.makeText(this,"age should be greater than 10 " , Toast.LENGTH_SHORT).show()
                    }

                    if(value_wiegth<=20)
                    {
                        Toast.makeText(this, "wiegth should be greater than 20", Toast.LENGTH_SHORT).show()
                    }
                    if(hieght<=60)
                    {
                        Toast.makeText(this,"hieght should be greater than 60" , Toast.LENGTH_SHORT).show()
                    }

                }
                else
                {
                    var intent=Intent(this,Result::class.java)
                    intent.putExtra("BMI",(calculateBMI(value_wiegth.toDouble(),hieght.toDouble())))
                    startActivity(intent)

                }





            }
            catch (e:Exception)
            {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            }

        })

        seek?.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                value.text=progress.toString()

            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
                hieght = seek.progress
                Toast.makeText(this@home, hieght.toString(), Toast.LENGTH_SHORT).show()

            }
        })








    }

    fun calculateBMI(weight: Double, height: Double): Double {
        val heightInMeters = height / 100

        return weight / (heightInMeters * heightInMeters)

    }
}