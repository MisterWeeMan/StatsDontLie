package com.example.statsdontlie.screens.lists

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.statsdontlie.dummies.*

class PlayerAdapter: RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    val listPlayer = listOf(dummyLebron, dummyDurant, dummyCurry)

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun getItemCount(): Int {
        return listPlayer.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listPlayer[position]
        holder.textView.text = "${data.firstName} ${data.lastName}"
    }
}