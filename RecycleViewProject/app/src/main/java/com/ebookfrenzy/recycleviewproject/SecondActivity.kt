package com.ebookfrenzy.recycleviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import com.ebookfrenzy.recycleviewproject.databinding.ActivityMain2Binding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?: return
        val iTop = extras.getString("titleString")
        val iMiddle = extras.getString("detailString")
        val iBottom = extras.getInt("imageView")

       //need to update top middle and bottom
        binding.top.text = iTop
        binding.middle.text = iMiddle
        binding.bottom.setImageResource(iBottom)
    }

    fun returnText(view: View) {finish()
    }
    override fun finish() {
        val data = Intent()
        val returnString = binding.top.text.toString()
        val returnString2 = binding.middle.text.toString()
        //need to find specific picture
        val returnImage = R.drawable.android_image_1
        data.putExtra("returnData", returnString)
        data.putExtra("returnData", returnString2)
        data.putExtra("returnData", returnImage)


        setResult(RESULT_OK, data)
        super.finish()
    }

}