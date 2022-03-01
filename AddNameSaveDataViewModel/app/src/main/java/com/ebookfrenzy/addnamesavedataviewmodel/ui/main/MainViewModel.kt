package com.ebookfrenzy.addnamesavedataviewmodel.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var result = ""

    fun buildString(name: String) {
        result = result + "\n" + name
    }

    fun getResult(): String {
        return result
    }
}