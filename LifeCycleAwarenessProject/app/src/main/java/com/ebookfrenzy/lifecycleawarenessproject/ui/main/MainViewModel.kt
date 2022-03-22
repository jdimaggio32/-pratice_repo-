package com.ebookfrenzy.lifecycleawarenessproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var result: MutableLiveData<String> = MutableLiveData()

    fun getResult(): MutableLiveData<String> {
        return result
    }
}