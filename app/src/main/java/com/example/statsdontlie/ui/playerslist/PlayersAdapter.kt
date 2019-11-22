package com.example.statsdontlie.ui.playerslist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.statsdontlie.R
import com.example.statsdontlie.api.model.PlayerJson
import com.example.statsdontlie.databinding.PlayerItemLayoutBinding

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 */
class PlayersAdapter(val onClickListener: OnClickListener)
    : ListAdapter<PlayerJson, PlayersAdapter.PlayerViewHolder>(DiffCallback) {

    /**
     * The [PlayerViewHolder] constructor takes the binding variable from the associated
     * PlayerItemLayout, which nicely gives it access to the full [Player] information.
     */
    class PlayerViewHolder(private var binding: PlayerItemLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(player: PlayerJson) {
            binding.player = player
            // It forces the data binding to execute immediately,
            // which allows the RecyclerView to make the correct view size measurements
            binding.executePendingBindings()
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [PlayerJson]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<PlayerJson>() {
        override fun areItemsTheSame(oldItem: PlayerJson, newItem: PlayerJson): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PlayerJson, newItem: PlayerJson): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding: PlayerItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.player_item_layout,
            parent,
            false
        )

        return PlayerViewHolder(binding)
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = getItem(position)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(player)
        }
        holder.bind(player)
    }

    /**
     * OnClickListener that takes a player and return nothing
     */
    class OnClickListener(val onClickListener: (playerJson: PlayerJson) -> Unit) {
        fun onClick(playerJson: PlayerJson) = onClickListener(playerJson)
    }
}