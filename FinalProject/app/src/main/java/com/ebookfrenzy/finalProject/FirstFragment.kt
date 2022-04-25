package com.ebookfrenzy.finalProject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.finalProject.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    //create 2 arrays. one to hold names and one to hold phone numbers
    var nameArray = arrayListOf<String>("Jim","Sarah","Bob")
    var phoneArray = arrayListOf<String>("7344293403","74868161","14565616")

    //functions for getting the binding info (enterName and enterPhone)
    fun getBindersName(): String {
        return binding.enterName.text.toString()
    }
    fun getBindersPhone(): String {
        return binding.enterPhone.text.toString()
    }

    fun addNameandPhone(name: String, phone: String) {
        nameArray.add(name)
        phoneArray.add(phone)

    }

    //getter for accessing the arrays in the recycleAdapter class
    fun getNArray(): ArrayList<String> {
        return nameArray
    }
    fun getPArray(): ArrayList<String> {
        return phoneArray
    }



    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener { v: View ->
            if ((binding.enterName.length()<1) or (binding.enterPhone.length()<1)) {
                Snackbar.make(
                    v, "You must enter a name and phone number",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()
            } else {
                addNameandPhone(binding.enterName.text.toString(), binding.enterPhone.text.toString())
            }
        }
        binding.findButton.setOnClickListener { v: View ->

            val userStr = binding.enterName.text.toString()

            if (!nameArray.contains(binding.enterName.text.toString())) {
                Snackbar.make(
                    v, "There are no contacts with the entered characters",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()
            } else {
                nameArray.set(0,binding.enterName.text.toString())
            }

        }
        binding.ascButton.setOnClickListener {
            //method to sort array alphabethical
            nameArray.sort()
            phoneArray.sort()

        }
        binding.descButton.setOnClickListener {
            //method to sort array reverse alphabethical
            nameArray.sortDescending()
            phoneArray.sort()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}