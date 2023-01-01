package com.example.binlistnet.core.basemodel.base_fragment

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.binlistnet.core.state.ClickItemState
import com.example.binlistnet.core.state.LoadState
import com.example.binlistnet.core.touchhelper.SwipeToDeleteCallback
import com.example.binlistnet.databinding.FragmentStartBinding
import com.example.binlistnet.feater_search_bin.presentation.adapter.HistoryAdapter
import com.example.binlistnet.feater_search_bin.presentation.adapter.HistoryViewHolder.Companion.PREF_INTENT_GEO
import com.example.binlistnet.feater_search_bin.presentation.adapter.HistoryViewHolder.Companion.PREF_INTENT_PHONE
import com.example.binlistnet.feater_search_bin.presentation.adapter.HistoryViewHolder.Companion.PREF_INTENT_URL
import com.example.binlistnet.feater_search_bin.presentation.startFragment.StartViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseStartFragment : BaseFragment<FragmentStartBinding>() {

    protected val viewModel by viewModel<StartViewModel>()

    abstract override fun initBinding(inflater: LayoutInflater): FragmentStartBinding?

    private val swipeItem = SwipeToDeleteCallback { position -> onSwipeItem(position) }

    protected val itemTouchHelper = ItemTouchHelper(swipeItem)

    private fun onSwipeItem(position: Int) {
        viewModel.onSwiped(position)
    }

    private fun historyObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.history.collect { list ->
                val adapter = HistoryAdapter(list) { onClickItem(it) }
                binding.historyRecyclerView.adapter = adapter
            }
        }
    }

    protected abstract fun onClickItem(clickItemState: ClickItemState)

    protected fun observeData() {
        loadStateObserve()
        userInfoObserve()
        historyObserve()
    }

    private fun loadStateObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadState.collect { loadState ->
                when (loadState) {
                    LoadState.START -> {
                        binding.toolbar.errorMessage.isVisible = false
                        binding.toolbar.errorMessage.isVisible = false
                        binding.toolbar.holder.isVisible = true
                    }
                    LoadState.ERROR -> {
                        binding.toolbar.progressCircular.isVisible = false
                        binding.toolbar.holder.isVisible = true
                        binding.toolbar.errorMessage.isVisible = true
                        binding.toolbar.errorMessage.text = loadState.message
                        binding.toolbar.searchButton.isEnabled = true
                    }
                    LoadState.LOADING -> {
                        binding.toolbar.progressCircular.isVisible = true
                        binding.toolbar.holder.isVisible = true
                        binding.toolbar.errorMessage.isVisible = false
                        binding.toolbar.searchButton.isEnabled = false
                    }
                    LoadState.SUCCESS -> {

                        binding.toolbar.searchButton.isEnabled = true
                        binding.toolbar.holder.isVisible = false
                    }
                }
            }
        }
    }

    private fun userInfoObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userInfo.collect { info ->

                onClickButton(
                    info.bank.url,
                    info.bank.phone,
                    "${info.country.longitude},${info.country.latitude}")

                binding.apply {
                    toolbar.bank.text = info.bank.name ?: "N/A"
                    toolbar.leftColumn.schemeText.text = info.scheme
                    toolbar.leftColumn.brand.text = info.brand ?: "N/A"
                    toolbar.leftColumn.length.text = info.cardNumber.length.toString()
                    if (info.cardNumber.luhn) toolbar.leftColumn.luhnYes.isChecked = true
                    else toolbar.leftColumn.luhnNo.isChecked = true
                    toolbar.rightColumn.typeGroup.isVisible = info.type != null
                    if (info.type == "debit") toolbar.rightColumn.typeDebit.isChecked = true
                    else toolbar.rightColumn.typeCredit.isChecked = true
                    if (info.prepaid) toolbar.rightColumn.prepaidYes.isChecked = true
                    else toolbar.rightColumn.prepaidNo.isChecked = true
                    toolbar.rightColumn.country.text = info.country.name

                    toolbar.bankLocation.isVisible = info.country.latitude != null
                    toolbar.bankPhone.isVisible = info.bank.phone != null
                    toolbar.bankUrl.isVisible = info.bank.url != null
                }
            }
        }
    }

    private fun onClickButton(bankUrl: String?, bankPhone: String?, location: String?) {
        binding.toolbar.bankUrl.setOnClickListener { startNewApp(PREF_INTENT_URL + bankUrl) }

        binding.toolbar.bankPhone.setOnClickListener { startNewApp(PREF_INTENT_PHONE + bankPhone) }

        binding.toolbar.bankLocation.setOnClickListener { startNewApp(PREF_INTENT_GEO + location) }
    }

    protected fun startNewApp(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}