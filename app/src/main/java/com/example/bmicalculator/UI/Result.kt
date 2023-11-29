package com.example.bmicalculator.UI

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.bmicalculator.R

class Result : AppCompatActivity() {
    lateinit var ad:TextView
    lateinit var status:TextView
    lateinit var result:TextView
    lateinit var back_home:ImageButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var advice= arrayOf("1)Nutrition:\n" +
                "\n- Focus on nutrient-dense foods to increase calorie intake." +
                "\n-Include healthy fats, such as avocados, nuts, and olive oil." +
                "\n-Choose protein-rich foods like lean meats, dairy, and legumes." +
                "\n\n2)Meal Frequency:" +
                "\n-Aim for more frequent, smaller meals and snacks throughout the day." +
                "\n-Include protein and carbohydrates in each meal." +
                "\n\n3) Strength Training:" +
                "\n-Incorporate strength training exercises to build muscle mass." +
                "\n-Consult with a fitness professional for a safe and effective exercise plan." +
                "\n\n4) Consult a Professional:" +
                "\n-Consider consulting with a healthcare provider or a registered dietitian for personalized advice.",



            "1)Maintain Balanced Diet:" +
                    "\n-Continue to focus on a well-balanced diet with a variety of nutrients." +
                    "\n-Be mindful of portion sizes to maintain a healthy weight." +
                    "\n\n2)Regular Exercise:" +
                    "\n-Engage in regular physical activity for overall health." +
                    "\n-Aim for a mix of aerobic exercises and strength training." +
                    "\n\n3)Mindful Eating:\n" +
                    "\n-Practice mindful eating to listen to your body's hunger and fullness cues." +
                    "\n-Be aware of emotional eating habits.",


            "1)Healthy Eating Habits:" +
                    "\n-Adopt a balanced and portion-controlled diet." +
                    "\n-Choose whole, unprocessed foods and limit intake of sugary and high-fat foods." +
                    "\n\n2)Regular Exercise Routine:" +
                    "\n-Incorporate regular physical activity into your routine." +
                    "\n-Aim for at least 150 minutes of moderate-intensity aerobic exercise per week." +
                    "\n\n3)Behavioral Changes:" +
                    "\n-Identify and address potential triggers for overeating." +
                    "\n-Consider seeking support from friends, family, or a healthcare professional."
            ,

            "1)Comprehensive Lifestyle Changes:" +
                    "\n-Implement comprehensive lifestyle changes, including diet and exercise." +
                    "\n-Set realistic and achievable weight loss goals." +
                    "\n\n2)Professional Support:" +
                    "\n-Consult with healthcare professionals, such as a registered dietitian or a weight loss specialist." +
                    "\n-Consider a structured weight loss program if appropriate." +
                    "\n\n3)Physical Activity:" +
                    "\n-Gradually increase physical activity, including both aerobic exercises and strength training." +
                    "\n\n4)Behavioral Strategies:" +
                    "\n-Focus on behavior modification strategies, such as mindful eating and stress management."


        )

        ad=findViewById(R.id.advice)
        status=findViewById(R.id.stat)
        result=findViewById(R.id.res)
        back_home=findViewById(R.id.back)

        val receivedValue = intent.getDoubleExtra("BMI", 0.0)
        result.text=String.format("%.1f", receivedValue).toDouble().toString()


        if(receivedValue>=0&&receivedValue<=18.5)
        {
            ad.text=advice[0]
            status.text="Underweight"
            status.setTextColor(ContextCompat.getColor(this, R.color.yello))
        }
        else if(receivedValue>=18.6&&receivedValue<=24.9)
        {
            ad.text=advice[1]
            status.text="Normal"
            status.setTextColor(ContextCompat.getColor(this, R.color.green))
        }
        else if(receivedValue>=18.6&&receivedValue<=24.9)
        {
            ad.text=advice[2]
            status.text="Overweight"
            status.setTextColor(ContextCompat.getColor(this, R.color.red_transparent))
        }
        else
        {
            ad.text=advice[3]
            status.text="Obesity"
            status.setTextColor(ContextCompat.getColor(this, R.color.red))
        }


        back_home.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, home::class.java))
        })




/*        ad.text=advice[3]*/








    }
}