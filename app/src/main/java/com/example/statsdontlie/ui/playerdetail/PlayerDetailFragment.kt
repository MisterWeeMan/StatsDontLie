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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding: FragmentPlayerDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_player_detail, container, false)

        binding.lifecycleOwner = this

        val player = PlayerDetailFragmentArgs.fromBundle(arguments!!).player
        val viewModelFactory = PlayerViewModel.PlayerViewModelFactory(player, application)

        binding.viewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(PlayerViewModel::class.java)

        return binding.root
    }
}
