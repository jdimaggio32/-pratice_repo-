package com.ebookfrenzy.lifecycleawarenessproject.ui.main

import android.R.attr.data
import android.app.Notification
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.whenCreated
import com.ebookfrenzy.lifecycleawarenessproject.DemoObserver
import com.ebookfrenzy.lifecycleawarenessproject.databinding.MainFragmentBinding
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


class MainFragment : Fragment() {


    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var result: MutableLiveData<String> = MutableLiveData()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View

    {

        val binding: MainFragmentBinding = MainFragmentBinding.inflate(
            inflater,  container, false
        )
        val view: View = binding.root

        return view

        //return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        lifecycle.addObserver(DemoObserver())

        val resultObserver = Observer<String> {
                result -> binding.resultText.text = result.toString()
        }
    }


}