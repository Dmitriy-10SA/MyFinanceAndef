package com.andef.myfinance.di

import android.app.Application
import com.andef.myfinance.MainActivity
import com.andef.myfinance.di.expense.ExpenseDaoModule
import com.andef.myfinance.di.expense.ExpenseRepositoryModule
import com.andef.myfinance.di.income.IncomeDaoModule
import com.andef.myfinance.di.income.IncomeRepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        //expense
        ExpenseRepositoryModule::class,
        ExpenseDaoModule::class,
        //income
        IncomeRepositoryModule::class,
        IncomeDaoModule::class
    ]
)
interface MyFinanceComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): MyFinanceComponent
    }
}