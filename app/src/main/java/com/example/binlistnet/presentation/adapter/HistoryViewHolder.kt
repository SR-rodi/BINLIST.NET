package com.example.binlistnet.presentation.adapter

import android.annotation.SuppressLint
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.binlistnet.data.model.UserInfoSmall
import com.example.binlistnet.data.state.ClickItemState
import com.example.binlistnet.databinding.ItemHistoryBinding

class HistoryViewHolder(private val binding: ItemHistoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: UserInfoSmall, onClick: (state: ClickItemState) -> Unit) {
        binding.bin.text = "BIN: ${item.bin}"
        binding.bank.text = "BANK: ${item.bankName ?: "N/A"}"

        binding.bankLocation.isVisible = item.latitude != null
        binding.bankPhone.isVisible = item.bankPhone != null
        binding.bankUrl.isVisible = item.bankUrl != null


        binding.bankLocation.setOnClickListener {
            onClick(ClickItemState.LOCATION.apply { data = "geo: ${item.latitude},${item.latitude}" })
        }
        binding.bankPhone.setOnClickListener {
            onClick(ClickItemState.PHONE.apply { data ="tel: ${item.bankPhone}"})
        }
        binding.bankUrl.setOnClickListener {
            onClick(ClickItemState.URL.apply { data = "https://${item.bankUrl}"})
        }

        binding.root.setOnClickListener {
            onClick(ClickItemState.ITEM.apply { data = item.bin})
        }
    }
}