package com.andef.myfinance.di.income

import com.andef.myfinance.data.income.repository.IncomeRepositoryImpl
import com.andef.myfinance.domain.income.repository.IncomeRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface IncomeRepositoryModule {
    @Binds
    @Singleton
    fun bindIncomeRepository(impl: IncomeRepositoryImpl): IncomeRepository
}