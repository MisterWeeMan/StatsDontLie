package com.example.statsdontlie.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.statsdontlie.R
import com.example.statsdontlie.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        binding.apply {
            playersBtn.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_mainFragment_to_playersFragment)
            )
            whoDoneButton.setOnClickListener { setName(it) }
        }

        return binding.root
    }

    private fun setName(view: View) {
        binding.apply {
            val newName = binding.whoEditText.text
            welcomeText.text = getString(R.string.welcome_message_username, newName)
        }

        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
