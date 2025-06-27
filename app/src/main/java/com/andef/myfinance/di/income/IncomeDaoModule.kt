package com.andef.myfinance.di.income

import android.app.Application
import com.andef.myfinance.data.income.datasource.IncomeDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class IncomeDaoModule {
    @Provides
    @Singleton
    fun provideIncomeDao(application: Application) = IncomeDatabase.getInstance(application).dao
}