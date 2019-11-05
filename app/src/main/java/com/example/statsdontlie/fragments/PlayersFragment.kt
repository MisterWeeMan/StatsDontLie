package com.example.statsdontlie.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.statsdontlie.R
import com.example.statsdontlie.databinding.FragmentPlayersBinding

/**
 * A simple [Fragment] subclass.
 */
class PlayersFragment : Fragment() {

    private lateinit var binding: FragmentPlayersBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_players, container, false)

        return binding.root
    }
}
