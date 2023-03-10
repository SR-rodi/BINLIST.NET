package com.example.binlistnet.feater_search_bin.presentation.startFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.widget.doOnTextChanged
import com.example.binlistnet.core.basemodel.base_fragment.BaseStartFragment
import com.example.binlistnet.core.state.ClickItemState
import com.example.binlistnet.databinding.FragmentStartBinding

class StartFragment : BaseStartFragment() {

    override fun initBinding(inflater: LayoutInflater) = FragmentStartBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(binding.historyRecyclerView)

        onClickSearchButton()

        buttonEnabledListener()

        observeData()

    }

    private fun buttonEnabledListener() {

        binding.toolbar.editText.doOnTextChanged { text, _, _, _ ->
            binding.toolbar.searchButton.isEnabled = (text?.length ?: 0) == 8
        }
    }

    private fun onClickSearchButton() {
        binding.toolbar.searchButton.setOnClickListener {
            viewModel.onClickSearchButton(binding.toolbar.editText.text.toString())
        }
    }

    override fun onClickItem(clickItemState: ClickItemState) {
        when (clickItemState) {
            ClickItemState.ITEM -> {
                viewModel.onClickSearchButton(clickItemState.data)
                binding.historyRecyclerView.smoothScrollToPosition(0)
                binding.appbar.setExpanded(true)
            }
            else -> startNewApp(clickItemState.data)
        }
    }
}