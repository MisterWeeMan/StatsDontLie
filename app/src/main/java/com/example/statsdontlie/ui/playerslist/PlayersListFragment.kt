package com.example.statsdontlie.ui.playerslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.statsdontlie.R
import com.example.statsdontlie.databinding.FragmentPlayersListBinding

/**
 * Fragment that show the recyclerview view containing the list of players.
 */
class PlayersListFragment : Fragment() {

    private lateinit var binding: FragmentPlayersListBinding
    private lateinit var viewModel: PlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_players_list, container, false)
        viewModel = ViewModelProviders.of(this).get(PlayersViewModel::class.java)

        val adapter = PlayerAdapter(viewModel)
        binding.playersList.adapter = adapter

        return binding.root
    }
}
