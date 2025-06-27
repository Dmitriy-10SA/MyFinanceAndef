package com.andef.myfinance.di.expense

import android.app.Application
import com.andef.myfinance.data.expense.datasource.ExpenseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ExpenseDaoModule {
    @Provides
    @Singleton
    fun provideExpenseDao(application: Application) = ExpenseDatabase.getInstance(application).dao
}