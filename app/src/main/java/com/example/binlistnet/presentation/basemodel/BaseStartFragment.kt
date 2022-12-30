package com.example.binlistnet.presentation.basemodel

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.binlistnet.data.state.ClickItemState
import com.example.binlistnet.data.state.LoadState
import com.example.binlistnet.databinding.FragmentStartBinding
import com.example.binlistnet.presentation.adapter.HistoryAdapter
import com.example.binlistnet.presentation.startFragment.StartViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseStartFragment : BaseFragment<FragmentStartBinding>() {

    protected val viewModel by viewModel<StartViewModel>()

    abstract override fun initBinding(inflater: LayoutInflater): FragmentStartBinding?

    protected fun historyObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.history.collect { list ->
                binding.historyRecyclerView.adapter = HistoryAdapter(list) { onClickItem(it) }
            }
        }
    }

    protected abstract fun onClickItem(clickItemState: ClickItemState)

    protected fun loadStateObserve() {
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

    protected fun userInfoObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userInfo.collect { info ->

                binding.toolbar.bankUrl.setOnClickListener { startNewApp("https://${info.bank.url}") }

                binding.toolbar.bankPhone.setOnClickListener { startNewApp("tel: ${info.bank.phone}") }

                binding.toolbar.bankLocation.setOnClickListener {
                    startNewApp("geo: ${info.country.longitude},${info.country.latitude}")
                }

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

    protected fun startNewApp(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}