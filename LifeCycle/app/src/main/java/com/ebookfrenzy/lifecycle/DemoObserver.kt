package com.ebookfrenzy.lifecycle

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.ebookfrenzy.lifecycle.ui.main.binding

class DemoObserver: LifecycleObserver {

    var theText = ""

    private val LOG_TAG = "DemoObserver"
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG, "onResume")
        theText += "onResume was fired\n******\n"
        binding.message.text = theText
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG, "onPause")
        theText += "onPause was fired\n******\n"
        binding.message.text = theText
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG, "onCreate")
        theText += "onCreate was fired\n"
        binding.message.text = theText
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG, "onStart")
        theText += "onStart was fired\n"
        binding.message.text = theText

    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG, "onStop")
        theText += "onStop was fired\n"
        binding.message.text = theText
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG, "onDestroy")
        theText += "onDestroy was fired\n******\n"
        binding.message.text = theText
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)

    }

}