package com.example.binlistnet.feater_search_bin.presentation.adapter

import android.annotation.SuppressLint
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.binlistnet.feater_search_bin.data.model.UserInfoSmall
import com.example.binlistnet.core.state.ClickItemState
import com.example.binlistnet.databinding.ItemHistoryBinding

class HistoryViewHolder(private val binding: ItemHistoryBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: UserInfoSmall, onClick: (state: ClickItemState) -> Unit) {
        binding.bin.text = "$BIN_TEXT ${item.bin}"
        binding.bank.text = "$BANK_TEXT: ${item.bankName ?: "N/A"}"

        binding.bankLocation.isVisible = item.latitude != null
        binding.bankPhone.isVisible = item.bankPhone != null
        binding.bankUrl.isVisible = item.bankUrl != null


        binding.bankLocation.setOnClickListener {
            onClick(ClickItemState.LOCATION.apply { data = "$PREF_INTENT_GEO ${item.latitude},${item.latitude}" })
        }
        binding.bankPhone.setOnClickListener {
            onClick(ClickItemState.PHONE.apply { data = PREF_INTENT_PHONE + item.bankPhone })
        }
        binding.bankUrl.setOnClickListener {
            onClick(ClickItemState.URL.apply { data = PREF_INTENT_URL+ item.bankUrl})
        }

        binding.root.setOnClickListener {
            onClick(ClickItemState.ITEM.apply { data = item.bin})
        }
    }

    companion object{
        const val PREF_INTENT_GEO ="geo:"
        const val PREF_INTENT_PHONE ="tel:"
        const val PREF_INTENT_URL ="https://"
        const val BIN_TEXT ="BIN:"
        const val BANK_TEXT ="BANK:"
    }

}