package com.mattiabano.statsdontlie

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mattiabano.statsdontlie.api.model.PlayerJson
import com.mattiabano.statsdontlie.ui.playerslist.PlayersAdapter
import timber.log.Timber

@BindingAdapter("listPlayers")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PlayerJson>?) {
    val adapter = recyclerView.adapter as PlayersAdapter
    adapter.submitList(data)
}

@BindingAdapter("playerName")
fun bindPlayerName(textView: TextView, player: PlayerJson?) {
    val resource = textView.context.resources
    player?.let {
        textView.text = resource.getString(R.string.player_full_name, player.firstName, player.lastName)
    }
}

@BindingAdapter("playerPosition")
fun bindPlayerPosition(textView: TextView, player: PlayerJson?) {
    player?.let {
        textView.text = when (player.position){
            "C" -> "Center"
            "G" -> "Guard"
            "F" -> "Forward"
            "C-F" -> "Center Forward"
            "F-C" -> "Forward Center"
            "G-F" -> "Guard Forward"
            "F-G" -> "Forward Guard"
            else -> "Not Specified"
        }
    }
}

@BindingAdapter("teamLogo")
fun bindTeamLogo(textView: TextView, player: PlayerJson?) {
    player?.let {
        textView.text = player.team.fullName
    }
}

@BindingAdapter("statPct")
fun bindPct(textView: TextView, doublePct: Double?) {
    doublePct?.let {
        val pct = doublePct * 100
        textView.text = "$pct%"
    }
}