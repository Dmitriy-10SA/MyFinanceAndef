package com.andef.myfinance.di.viewmodel

import androidx.lifecycle.ViewModel
import com.andef.myfinance.presentation.income.IncomeMainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(IncomeMainViewModel::class)
    fun bindIncomeMainViewModel(impl: IncomeMainViewModel): ViewModel
}