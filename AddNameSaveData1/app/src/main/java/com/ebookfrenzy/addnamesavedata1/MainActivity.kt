package com.ebookfrenzy.addnamesavedata1

import androidx.fragment.app.FragmentActivity
import android.os.Bundle
import androidx.core.view.get
import com.ebookfrenzy.addnamesavedata1.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() , Fragment1.ToolbarListener {

    private lateinit var binding: ActivityMainBinding

    override fun onButtonClick(fontsize: Int, text: String) {
        val textFragment = supportFragmentManager.findFragmentById(
            R.id.namesFragment) as Fragment2
        textFragment.changeTextProperties(fontsize, text)
    }
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}