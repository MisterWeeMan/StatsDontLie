package com.mattiabano.statsdontlie.ui.playerslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.mattiabano.statsdontlie.databinding.FragmentPlayersListBinding

/**
 * Fragment that show the recyclerview view containing the list of players.
 */
class PlayersListFragment : Fragment() {

    /**
     * Lazily initialize our [PlayersViewModel].
     */
    private val playersViewModel: PlayersViewModel by lazy {
        ViewModelProviders.of(this).get(PlayersViewModel::class.java)
    }

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate layout
        val binding = FragmentPlayersListBinding.inflate(inflater)

        // Sets lifecycle owner to observe live data
        binding.lifecycleOwner = this

        // Giving binding access to the viewModel
        binding.playersViewModel = playersViewModel

        // Set recyclerView adapter
        binding.playersList.adapter = PlayersAdapter(PlayersAdapter.OnClickListener {
            playersViewModel.displayPlayerDetail(it)
        })

        playersViewModel.navigateToPlayerDetail.observe(this, Observer {
            if (it != null) {
                this.findNavController().navigate(
                    PlayersListFragmentDirections.actionPlayersFragmentToDetailFragment(it)
                )
                playersViewModel.displayPlayerDetailComplete()
            }
        })

        playersViewModel.status.observe(this, Observer { status ->
            binding.apply {
                when (status) {
                    PlayersApiStatus.LOADING -> {
                        playersList.visibility = View.GONE
                        connectionErrorImage.visibility = View.GONE
                        loadingAnimation.visibility = View.VISIBLE
                    }
                    PlayersApiStatus.ERROR, null -> {
                        playersList.visibility = View.GONE
                        connectionErrorImage.visibility = View.VISIBLE
                        loadingAnimation.visibility = View.GONE
                    }
                    PlayersApiStatus.DONE -> {
                        playersList.visibility = View.VISIBLE
                        connectionErrorImage.visibility = View.GONE
                        loadingAnimation.visibility = View.GONE
                    }
                }
            }
        })

        return binding.root
    }
}
