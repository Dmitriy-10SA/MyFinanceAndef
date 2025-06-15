package com.andef.myfinance.di.expense

import com.andef.myfinance.data.expense.repository.ExpenseRepositoryImpl
import com.andef.myfinance.domain.expense.repository.ExpenseRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ExpenseRepositoryModule {
    @Binds
    @Singleton
    fun bindExpenseRepository(impl: ExpenseRepositoryImpl): ExpenseRepository
}