package com.example.binlistnet.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.binlistnet.data.model.UserInfoSmall
import com.example.binlistnet.data.state.ClickItemState
import com.example.binlistnet.databinding.ItemHistoryBinding

class HistoryAdapter(
    private val listHistory: List<UserInfoSmall>,
    private val onClick: (state: ClickItemState) -> Unit
) : RecyclerView.Adapter<HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HistoryViewHolder(
        ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(listHistory[position]) { onClick(it) }
    }

    override fun getItemCount() = listHistory.size
}