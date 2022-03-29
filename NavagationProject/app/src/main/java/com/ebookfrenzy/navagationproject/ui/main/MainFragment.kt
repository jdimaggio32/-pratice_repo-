package com.ebookfrenzy.navagationproject.ui.main

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import com.ebookfrenzy.navagationproject.R
import com.ebookfrenzy.navagationproject.databinding.MainFragmentBinding
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

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

        binding.button1.setOnClickListener {


            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
                action.message = "Image 1"
                action.picture = R.drawable.android_image_1

            Navigation.findNavController(it).navigate(action)
        }

        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
                action.message = "Image 2"
                action.picture = R.drawable.android_image_2

            Navigation.findNavController(it).navigate(action)
        }

        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.MainToSecond =
                MainFragmentDirections.mainToSecond()
                action.message = "Image 3"
                action.picture = R.drawable.android_image_3

            Navigation.findNavController(it).navigate(action)
        }

    }

}