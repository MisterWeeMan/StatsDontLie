package com.example.statsdontlie.ui.playerdetail

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.statsdontlie.R
import com.example.statsdontlie.databinding.FragmentPlayerDetailBinding
import com.example.statsdontlie.ui.playerslist.PlayersViewModel

/**
 * Fragment that show a player details.
 */
class PlayerDetailFragment : Fragment() {

    private lateinit var binding: FragmentPlayerDetailBinding
    private lateinit var viewModel: PlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player_detail, container, false)
        viewModel = ViewModelProviders.of(this).get(PlayersViewModel::class.java)

        return binding.root
    }
}
