package com.example.statsdontlie.screens.lists


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation

import com.example.statsdontlie.R
import com.example.statsdontlie.databinding.FragmentPlayersBinding

/**
 * A simple [Fragment] subclass.
 */
class PlayersFragment : Fragment() {

    private lateinit var binding: FragmentPlayersBinding
    private lateinit var viewModel: PlayersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_players, container, false)
        viewModel = ViewModelProviders.of(this).get(PlayersViewModel::class.java)

        binding.apply {
            // FIXME
//            lebronDummyText.setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.action_playersFragment_to_detailFragment)
//            )
//            adDummyText.setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.action_playersFragment_to_detailFragment)
//            )
//            durantDummyText.setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.action_playersFragment_to_detailFragment)
//            )
        }

        return binding.root
    }
}
