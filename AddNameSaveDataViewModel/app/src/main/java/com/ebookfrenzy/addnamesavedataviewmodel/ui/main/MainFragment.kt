package com.ebookfrenzy.addnamesavedataviewmodel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.addnamesavedataviewmodel.R.id
import com.ebookfrenzy.addnamesavedataviewmodel.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

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
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        binding.textView.text = viewModel.getResult().toString()
        binding.button.setOnClickListener {
            if (binding.editText.text.isNotEmpty()) {
                viewModel.buildString(binding.editText.text.toString())
                binding.textView.text = viewModel.getResult()
            } else {
                binding.textView.text = "Enter a name"
            }
        }
    }

}