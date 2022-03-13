package com.ebookfrenzy.addnamesavedataviewmodel.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var names: MutableLiveData<String> = MutableLiveData()
    var result: MutableLiveData<String> = MutableLiveData()

    fun buildString() {

            result.value = result.value + "\n" + names.value

    }

}