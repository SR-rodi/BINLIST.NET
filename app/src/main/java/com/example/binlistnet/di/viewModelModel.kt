package com.example.binlistnet.di

import com.example.binlistnet.presentation.startFragment.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModel = module {

    viewModel {
        StartViewModel(get(),get())
    }
}