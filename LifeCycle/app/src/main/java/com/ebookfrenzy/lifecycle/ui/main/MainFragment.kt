package com.ebookfrenzy.lifecycle.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.lifecycle.R
import androidx.lifecycle.Observer
import com.ebookfrenzy.lifecycle.DemoObserver
import com.ebookfrenzy.lifecycle.databinding.MainFragmentBinding

private var _binding: MainFragmentBinding? = null
val binding get() = _binding!!

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        // TODO: Use the ViewModel
        //added these 3 lines
        lifecycle.addObserver(DemoObserver())

        val resultObserver = Observer<String> { result -> binding.message.text = result.toString() }

        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)



    }

}