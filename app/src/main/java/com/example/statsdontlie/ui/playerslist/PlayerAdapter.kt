package com.example.statsdontlie.ui.playerslist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.statsdontlie.R

class PlayerAdapter(
    private val viewModel: PlayersViewModel
): RecyclerView.Adapter<PlayerViewHolder>() {

    override fun getItemCount(): Int {
        return viewModel.listDummies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.player_item_layout, parent, false) as ConstraintLayout
        view.apply {
            setOnClickListener {
                it.findNavController().navigate(R.id.action_playersFragment_to_detailFragment)
            }
        }
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val data = viewModel.listDummies[position]

        (holder.constraintLayout[0] as TextView).text = "${data.firstName} ${data.lastName}"
        (holder.constraintLayout[1] as TextView).text = when (data.position) {
            "G" -> "Guard"
            "F" -> "Forward"
            "C" -> "Center"
            else -> "Not specified"
        }
        (holder.constraintLayout[2] as TextView).text = "${data.team.fullName}"
    }
}