package com.example.statsdontlie.player.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.statsdontlie.R
import com.example.statsdontlie.databinding.FragmentPlayersBinding

/**
 * A simple [Fragment] subclass.
 * This fragment show the recyclerview containing the players list.
 */
class PlayersFragment : Fragment() {

    private lateinit var binding: FragmentPlayersBinding
    private lateinit var viewModel: PlayersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_players, container, false)
        viewModel = ViewModelProviders.of(this).get(PlayersViewModel::class.java)

        val adapter = PlayerAdapter(viewModel)
        binding.playersList.adapter = adapter

        return binding.root
    }
}
