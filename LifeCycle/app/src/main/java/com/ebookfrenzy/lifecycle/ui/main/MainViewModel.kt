package com.ebookfrenzy.lifecycle.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ebookfrenzy.lifecycle.DemoObserver

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel



    private var result: MutableLiveData<String> = MutableLiveData()


    fun getResult(): MutableLiveData<String> {
        return result
    }
}